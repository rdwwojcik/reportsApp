package reposts.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import reposts.core.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
