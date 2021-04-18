package com.devsuperior.hrworker.v1.adapter;

import com.devsuperior.hrworker.v1.core.servicies.exception.NegocioException;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

public interface RepositoryPort <T, I, E> extends RepositoryFilterPort <E, T>{

    T persist(T var1) throws NegocioException;

    void remove(T var1) throws EntityNotFoundException;

    T find(I var1) throws EntityNotFoundException;

    <M> Collection<T> query(M var1) throws EntityNotFoundException;

}
