package com.urillah.empireproj.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.urillah.empireproj.repository.AccountRepository;
import com.urillah.empireproj.dto.AccountDTO;
import com.urillah.empireproj.model.Account;

@Service
public class AccountService {
    
    @Autowired
	private ModelMapper modelMapper;
    
    @Autowired
	private AccountRepository accountRepositoryObj;

    public List<Account> getAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		accountRepositoryObj.findAll().forEach(accounts::add);
		return accounts;
	}

    public Account getAccount(Long accountId) {
		return accountRepositoryObj.findOne(accountId);
	}

    public Account createAccount(AccountDTO accountDTO) {
        Account accountObj = modelMapper.map(accountDTO, Account.class);
		return accountRepositoryObj.save(accountObj);
	}

    public Account updateAccount(Long accountId) {
		return accountRepositoryObj.findOne(accountId);
	}

    public Account deleteAccount(Long accountId) {
		return accountRepositoryObj.findOne(accountId);
	}
}
