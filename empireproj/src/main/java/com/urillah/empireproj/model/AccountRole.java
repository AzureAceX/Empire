package com.urillah.empireproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account_roles")
@Data public class AccountRole {

    public AccountRole(long roleId, long accountId) {
		super();
		this.roleId = roleId;
		this.accountId = accountId;
	}

	@Id
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "role_id")
    private long roleId;
    
    @Column(name = "account_id")
    private long accountId;

    
}
