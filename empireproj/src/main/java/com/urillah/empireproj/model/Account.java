package com.urillah.empireproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.urillah.empireproj.util.Roles;

import lombok.Data;

@Entity
@Table(name = "account")
@Data public class Account {

    @Id
    @Column(name = "account_id", unique = true, nullable = false)
    private long accountId;
    
    @Column(name = "account_type")
    private Roles accountType;
    
    private String email;

    private String firstName;
    
    private String lastName;
    
    @Column(name = "phone_no")
    private Long phoneNo;

}