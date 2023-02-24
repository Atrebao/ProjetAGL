package com.projet.model;
// Generated 14 févr. 2023, 03:22:35 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(name = "client", catalog = "bd_projet_agl")
public class Client implements java.io.Serializable {

	private Integer idClient;
	private String nom;
	private String prenom;
	private String numTelephone;
	private String domicile;
	private Integer codeReservation;

	public Client() {
	}

	public Client(String nom, String prenom, String numTelephone, String domicile, Integer codeReservation) {
		this.nom = nom;
		this.prenom = prenom;
		this.numTelephone = numTelephone;
		this.domicile = domicile;
		this.codeReservation = codeReservation;
	}
	// Mon constructeur perso
	public Client(String nom, Integer codeReservation) {
		super();
		this.nom = nom;
		this.codeReservation = codeReservation;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_CLIENT", unique = true, nullable = false)
	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	@Column(name = "NOM", length = 30)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOM", length = 30)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "NUM_TELEPHONE", length = 30)
	public String getNumTelephone() {
		return this.numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	@Column(name = "DOMICILE", length = 30)
	public String getDomicile() {
		return this.domicile;
	}

	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}

	@Column(name = "CODE_RESERVATION")
	public Integer getCodeReservation() {
		return this.codeReservation;
	}

	public void setCodeReservation(Integer codeReservation) {
		this.codeReservation = codeReservation;
	}

}
