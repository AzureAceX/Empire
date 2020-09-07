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
import com.urillah.empireproj.model.AccountRole;
import com.urillah.empireproj.repository.AccountRepository;
import com.urillah.empireproj.repository.AccountRoleRepository;

@RestController
@RequestMapping("/accounts")
class AccountController {

	@Autowired
	private AccountRepository accountRepositoryObj;

	@Autowired
	private ModelMapper modelMapper;
	
//    @Autowired
//    AccountDetailsRepository accountDetailsRepositoryObj;

    @Autowired
    AccountRoleRepository accountRoleRepositoryObj;

	@GetMapping(value = "/list")
	public List<Account> getAll() {
		List<Account> accounts = new ArrayList<>();
		accountRepositoryObj.findAll().forEach(accounts::add);
		return accounts;
	}

	@GetMapping(value = "/{accountId}")
	public Account getById(@PathVariable("accountId") Long accountId) {
		return accountRepositoryObj.findOne(accountId);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Account> create(@RequestBody AccountDTO accountDto) {
		try {
			Account accountObj = modelMapper.map(accountDto, Account.class);
			AccountRole accountRole = new AccountRole(accountDto.getAccountType().ordinal() , accountDto.getAccountId());
			
			accountRoleRepositoryObj.save(accountRole);
			accountRepositoryObj.save(accountObj);
			
//             accountProfileRepositoryObj.set
			
			return new ResponseEntity<>(accountObj, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	// @PutMapping("{id}")
	// public ResponseEntity<entityClassName> update(@PathVariable("id")
	// entityIdType id,
	// @RequestBody entityClassName item) {
	// Optional<entityClassName> existingItemOptional = repository.findById(id);
	// if (existingItemOptional.isPresent()) {
	// entityClassName existingItem = existingItemOptional.get();
	// System.out
	// .println("TODO for developer - update logic is unique to entity and must be
	// implemented manually.");
	// // existingItem.setSomeField(item.getSomeField());
	// return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
	// } else {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// }

	@DeleteMapping(value = "/{accountId}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("accountId") Long accountId) {
		try {
			accountRepositoryObj.delete(accountId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}