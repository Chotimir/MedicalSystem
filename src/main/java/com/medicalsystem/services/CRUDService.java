package com.medicalsystem.services;

import java.util.List;

/**
 * @author Kamil Komenda
 */
public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
