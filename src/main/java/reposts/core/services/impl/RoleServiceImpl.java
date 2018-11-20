package reposts.core.services.impl;

import org.springframework.stereotype.Service;
import reposts.core.dto.RoleDTO;
import reposts.core.mappers.RoleMapper;
import reposts.core.repositories.RoleRepository;
import reposts.core.services.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper mapper;
    private final RoleRepository repository;

    public RoleServiceImpl(RoleMapper mapper, RoleRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public RoleDTO findByName(String name) {
        return mapper.toDTO(repository.findByName(name));
    }

    @Override
    public List<RoleDTO> findAll() {
        return null;
    }

    @Override
    public RoleDTO findById(Long id) {
        return null;
    }

    @Override
    public RoleDTO save(RoleDTO obj) {
        return mapper.toDTO(repository.save(mapper.fromDTO(obj)));
    }

    @Override
    public void delete(RoleDTO obj) {

    }
}
