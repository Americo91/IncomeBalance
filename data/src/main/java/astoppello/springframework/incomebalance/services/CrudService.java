package astoppello.springframework.incomebalance.services;

import java.util.List;

/**
 * Created by @author stopp on 05/10/2020
 */
public interface CrudService<T, ID> {
    T findById(ID id);

    T save(T object);

    List<T> saveAll(List<T> list);

    List<T> findAll();

    void delete(T object);

    void deleteById(ID id);
}
