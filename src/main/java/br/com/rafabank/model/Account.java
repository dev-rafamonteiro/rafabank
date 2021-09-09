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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@Column(name = "nome")
	private String name;

	@Column(name = "agencia")
	private String branch;

	@Column(name = "numero_conta")
	private String numberAccount;

	@Column(name = "cheque_especial")
	private String overdraft;

	@Column(name = "cheque_especial_liberado")
	private String releasedOverdraft;

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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	public String getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}

	public String getReleasedOverdraft() {
		return releasedOverdraft;
	}

	public void setReleasedOverdraft(String releasedOverdraft) {
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
