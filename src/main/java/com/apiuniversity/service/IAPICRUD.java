package com.apiuniversity.service;

import java.util.List;

public interface IAPICRUD<T, ID> {

    T save (T t);

    T update (ID id, T t);

    List<T> findAll ();

    T findById (ID id);

    void deleteById (ID id);

    Boolean existsById(ID id);
}
