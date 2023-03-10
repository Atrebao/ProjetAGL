package com.projet.model;
// Generated 14 févr. 2023, 03:22:35 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Transaction generated by hbm2java
 */
@Entity
@Table(name = "transaction", catalog = "bd_projet_agl")
public class Transaction implements java.io.Serializable {

	private Integer numtransaction;
	private String dateTransaction;
	private Integer montant;

	public Transaction() {
	}

	public Transaction(String dateTransaction, Integer montant) {
		this.dateTransaction = dateTransaction;
		this.montant = montant;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "NUMTRANSACTION", unique = true, nullable = false)
	public Integer getNumtransaction() {
		return this.numtransaction;
	}

	public void setNumtransaction(Integer numtransaction) {
		this.numtransaction = numtransaction;
	}

	@Column(name = "DATE_TRANSACTION", length = 30)
	public String getDateTransaction() {
		return this.dateTransaction;
	}

	public void setDateTransaction(String dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	@Column(name = "MONTANT")
	public Integer getMontant() {
		return this.montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

}
