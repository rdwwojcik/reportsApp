package reposts.core.services.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reposts.core.dto.UserDTO;
import reposts.core.entities.User;
import reposts.core.mappers.UserMapper;
import reposts.core.repositories.UserRepository;
import reposts.core.services.UserService;
import reposts.core.services.exceptions.UserAccountExistsException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDTO(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return userMapper.toDTO(user.get());
    }

    @Transactional
    @Override
    public UserDTO save(UserDTO obj) throws UserAccountExistsException {
        if(userExist(obj.getLogin())){
            throw new UserAccountExistsException("User for login " + obj.getLogin() + " exist in system.");
        }

        User user = userMapper.fromDTO(obj);
        user.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void delete(UserDTO obj) {
        userRepository.delete(userMapper.fromDTO(obj));
    }

    @Override
    public UserDTO findByLogin(String login) {
        return userMapper.toDTO(userRepository.findByLogin(login));
    }

    private boolean userExist(String login){
        User user = userRepository.findByLogin(login);
        if(user != null){
            return true;
        }

        return false;
    }
}
