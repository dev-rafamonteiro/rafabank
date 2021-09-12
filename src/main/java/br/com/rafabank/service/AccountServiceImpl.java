package br.com.rafabank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.rafabank.model.Account;
import br.com.rafabank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public void saveAccount(Account account) {
		this.accountRepository.save(account);
	}

	@Override
	public Account getAccountByCodigo(long codigo) {
		Optional<Account> optional = accountRepository.findById(codigo);
		Account account = null;
		if (optional.isPresent()) {
			account = optional.get();
		} else {
			throw new RuntimeException(" Account not found for id :: " + codigo);
		}
		return account;
	}
	

	@Override
	public void deleteAccountByCodigo(long codigo) {
		this.accountRepository.deleteById(codigo);
	}

	@Override
	public Page<Account> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.accountRepository.findAll(pageable);
	}
}
