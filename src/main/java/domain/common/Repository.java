package domain.common;


public interface Repository<T extends Entity> {

    void update(T entity);

    void create(T entity);

    void delete(T entity);

    T getForId(String id);

}

