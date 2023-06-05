package com.mendix.recipe.repository.interfaces;

public interface CrudRepository<T, ID> {

    T save(T entity);

    Iterable<T> findAll();

}
