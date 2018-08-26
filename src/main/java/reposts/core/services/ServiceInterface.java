package reposts.core.services;

import java.util.List;

public interface ServiceInterface<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T obj);
    void delete(T obj);
}
