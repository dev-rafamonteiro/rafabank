package br.com.rafabank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contas_bancarias")
public class Account implements Serializable{
	  
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@Column(name = "nome")
	private String name;

	@Column(name = "agencia")
	private Integer branch;

	@Column(name = "numero_conta")
	private Integer numberAccount;

	@Column(name = "cheque_especial")
	private String overdraft;

	@Column(name = "cheque_especial_liberado")
	private Integer releasedOverdraft;

	@Column(name = "saldo")
	private String balance;

	@Column(name = "taxa")
	private String rate;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBranch() {
		return branch;
	}

	public void setBranch(Integer branch) {
		this.branch = branch;
	}

	public Integer getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Integer numberAccount) {
		this.numberAccount = numberAccount;
	}

	public String getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}

	public Integer getReleasedOverdraft() {
		return releasedOverdraft;
	}

	public void setReleasedOverdraft(Integer releasedOverdraft) {
		this.releasedOverdraft = releasedOverdraft;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}


	
	
}
