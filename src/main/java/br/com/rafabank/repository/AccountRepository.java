package br.com.rafabank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.rafabank.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query(value = "SELECT h from Account h WHERE h.name like %?1% or h.branch like %?1%")
	List<Account> findAccountByName(String name);
	
}

