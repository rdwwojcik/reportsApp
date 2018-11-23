package reposts.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reposts.core.entities.Dictionary;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
}
