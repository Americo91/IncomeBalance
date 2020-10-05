package services;

import java.util.Set;

/**
 * Created by @author stopp on 05/10/2020
 */
public interface CrudService<T, ID> {
    T findById(ID id);

    T save(T object);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}
