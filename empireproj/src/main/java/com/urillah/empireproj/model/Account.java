package com.urillah.empireproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Data public class Account {

    @Id
    @Column(name = "account_id", unique = true, nullable = false)
    @Getter @Setter private long accountId;
    
    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "phone_no")
    private Long phoneNo;

}