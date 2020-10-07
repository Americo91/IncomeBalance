package astoppello.springframework.incomebalance.services.map;

import astoppello.springframework.incomebalance.model.BaseEntity;
import astoppello.springframework.incomebalance.services.CrudService;

import java.util.*;

/**
 * Created by @author stopp on 05/10/2020
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    public List<T> findAll() {
        return new LinkedList<>(map.values());
    }

    public T findById(Long id) {
        return map.get(id);
    }

    public List<T> saveAll(List<T> list) {
        List<T> returnedList = new LinkedList<>();
        for(T t : list) {
            returnedList.add(save(t));
        }
        return returnedList;
    }

    public T save(T object){
        if(object != null) {
            if(object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet())+1;
        } catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }


}
