package com.urillah.empireproj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urillah.empireproj.model.AccountLogin;

@Repository
public interface AccountLoginRepository extends CrudRepository<AccountLogin, Long>{

}