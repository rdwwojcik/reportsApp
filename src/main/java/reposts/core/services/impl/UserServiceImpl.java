package reposts.core.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reposts.core.dto.UserDTO;
import reposts.core.entities.User;
import reposts.core.mappers.UserMapper;
import reposts.core.repositories.UserRepository;
import reposts.core.services.ServiceInterface;
import reposts.core.services.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.toDTO(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO obj) {
        User user = userMapper.fromDTO(obj);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO findByLogin(String login) {
        return userMapper.toDTO(userRepository.findByLogin(login));
    }
}
