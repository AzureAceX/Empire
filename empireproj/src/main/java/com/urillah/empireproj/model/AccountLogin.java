package com.urillah.empireproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account_login")
@Data public class AccountLogin {
	
	@Id
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "account_id")
    private long accountId;
    
    @Column(name = "enabled")
    private Boolean enabled;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "2fa_enabled")
    private Boolean twoFactorAuth;

}
