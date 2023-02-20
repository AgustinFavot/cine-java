package com.afavot.apiCine.Repositories.Generic;

import org.springframework.data.repository.CrudRepository;

import com.afavot.apiCine.Models.BaseEntity;

public interface IGenericRepository<T extends BaseEntity> extends CrudRepository<T, Long>{

}
