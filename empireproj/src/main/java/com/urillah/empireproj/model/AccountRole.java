package com.urillah.empireproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account_role")
@Data public class AccountRole {

    public AccountRole(String accountRole, long accountId) {
		super();
		this.accountRole = accountRole;
		this.accountId = accountId;
	}

	@Id
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "account_id")
    private long accountId;
    
    @Column(name = "account_role")
    private String accountRole;


    
}
