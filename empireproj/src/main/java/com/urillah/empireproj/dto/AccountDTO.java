package com.urillah.empireproj.dto;

import com.urillah.empireproj.util.Roles;

import lombok.Data;

@Data public class AccountDTO {

	    private long accountId;
	    private Roles accountType;
	    private String email;
	    private String firstName;
	    private String lastName;
	    private Long phoneNo;
	    private String username;
	    private String password;
	    private Boolean enabled;
}
