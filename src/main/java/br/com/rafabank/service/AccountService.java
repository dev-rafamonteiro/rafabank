package br.com.rafabank.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.rafabank.model.Account;

public interface AccountService {
	List<Account> getAllAccount();
	void saveAccount(Account account);
	Account getAccountByCodigo(long codigo);
	void deleteAccountByCodigo(long codigo);
	Page<Account> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}

