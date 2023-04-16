package com.urillah.empireproj.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urillah.empireproj.dto.AccountDTO;
import com.urillah.empireproj.model.Account;
import com.urillah.empireproj.util.RolesUtil;
import com.urillah.empireproj.util.EmailUtil;
import com.urillah.empireproj.repository.AccountRepository;
import com.urillah.empireproj.repository.AccountRoleRepository;
import com.urillah.empireproj.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

//    @Autowired
//    AccountDetailsRepository accountDetailsRepositoryObj;

    @Autowired
    AccountRoleRepository accountRoleRepositoryObj;

	@GetMapping(value = "/v1/list")
	public List<Account> getAll() {
		return accountService.getAccounts();
		//HTTP status - try catch?
	}

	@GetMapping(value = "/v1/{accountId}")
	public Account getById(@PathVariable("accountId") Long accountId) {
		return accountService.getAccount(accountId);
	}

	@PostMapping(value = "/v1/create")
	public ResponseEntity<Account> initiateCreate(@RequestBody AccountDTO accountDto) {
		try {
			return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	// @PostMapping(value = "/v1/create")
	// public Account initiateCreate(@RequestBody AccountDTO accountDto) 
	// {
	// 	return accountService.createAccount(accountDto);
	// }

	
	// @PutMapping("{id}")
	// public ResponseEntity<entityClassName> update(@PathVariable("id")
	// entityIdType id,
	// @RequestBody entityClassName item) {
	// Optional<entityClassName> existingItemOptional = repository.findById(id);
	// if (existingItemOptional.isPresent()) {
	// entityClassName existingItem = existingItemOptional.get();
	// System.out
	// .println("ust be
	// implemented manually.");
	// // existingItem.setSomeField(item.getSomeField());
	// return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }

	@DeleteMapping(value = "/v1/delete:{accountId}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("accountId") Long accountId) {
		try {
			accountService.deleteAccount(accountId);
			// accountRepositoryObj.delete(accountId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}