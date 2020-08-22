package com.urillah.empireproj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urillah.empireproj.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

}