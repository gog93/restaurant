package manager;

import java.util.List;

public interface Manager<T, E> {
    void create(T object);

    List<T> getAll();

    T getById(E id);

    void update(T id);

    void delete(E id);
}
