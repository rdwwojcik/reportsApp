package reposts.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reposts.core.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

//    User findById(Long id);
    User findByLogin(String login);
}
