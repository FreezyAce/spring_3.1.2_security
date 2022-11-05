package FreezyAce.Spring_312.service;

import FreezyAce.Spring_312.model.Role;
import FreezyAce.Spring_312.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

}
