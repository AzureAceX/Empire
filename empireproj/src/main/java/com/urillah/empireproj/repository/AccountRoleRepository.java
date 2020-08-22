package com.urillah.empireproj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urillah.empireproj.model.AccountRole;

@Repository
public interface AccountRoleRepository extends CrudRepository<AccountRole, Long> {

}
