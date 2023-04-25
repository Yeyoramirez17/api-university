package com.apiuniversity.service.impl;

import com.apiuniversity.exception.ModelNotFoundException;
import com.apiuniversity.repository.IGenericRepository;
import com.apiuniversity.service.IAPICRUD;

import java.util.List;

public abstract class APICRUDImpl<T, ID> implements IAPICRUD<T, ID> {

    protected abstract IGenericRepository<T, ID> getRepository();

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public T update(ID id, T t) {
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND : " + id) );
        return getRepository().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND : " + id));
    }

    @Override
    public void deleteById(ID id) {
        getRepository().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND : " + id) );
        getRepository().deleteById(id);
    }

    @Override
    public Boolean existsById(ID id) {
        return getRepository().existsById(id);
    }

}
