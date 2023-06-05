package com.mendix.recipe.repository.interfaces;

public interface CrudRepository<T, ID> {

    T save(T entity);

    T findById(ID id);

    Iterable<T> findAll();

    Boolean existsById(ID id);
}
