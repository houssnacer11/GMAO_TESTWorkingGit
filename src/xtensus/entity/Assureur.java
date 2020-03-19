package xtensus.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "assureur")
public class Assureur extends Entite implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196076758286887105L;
	private Integer assureurId;
	private String assureurLibelle;
	private String assureurAdresse;
	private String assureurVille;
	private String assureurGouvernorat;
	private String assureurNumeroTelephone;
	private String assureurFax;
	private String assureurEmails;
	private String assureurNomComplet;
	private String assureurSiteWeb;
	
	
	public Assureur() {
	}
	public Assureur(String assureurLibelle, String assureurAdresse,
			String assureurVille, String assureurGouvernorat,
			String assureurNumeroTelephone, String assureurFax,
			String assureurEmails, String assureurNomComplet,
			String assureurSiteWeb) {
		
		this.assureurLibelle = assureurLibelle;
		this.assureurAdresse = assureurAdresse;
		this.assureurVille = assureurVille;
		this.assureurGouvernorat = assureurGouvernorat;
		this.assureurNumeroTelephone = assureurNumeroTelephone;
		this.assureurFax = assureurFax;
		this.assureurEmails = assureurEmails;
		this.assureurNomComplet = assureurNomComplet;
		this.assureurSiteWeb = assureurSiteWeb;
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "assureurId", unique = true, nullable = false)
	public Integer getAssureurId() {
		return assureurId;
	}



	public void setAssureurId(Integer assureurId) {
		this.assureurId = assureurId;
	}


	@Column(name = "assureurLibelle", length = 254)
	public String getAssureurLibelle() {
		return assureurLibelle;
	}



	public void setAssureurLibelle(String assureurLibelle) {
		this.assureurLibelle = assureurLibelle;
	}


	@Column(name = "assureurAdresse", length = 254)
	public String getAssureurAdresse() {
		return assureurAdresse;
	}



	public void setAssureurAdresse(String assureurAdresse) {
		this.assureurAdresse = assureurAdresse;
	}


	@Column(name = "assureurVille", length = 254)
	public String getAssureurVille() {
		return assureurVille;
	}



	public void setAssureurVille(String assureurVille) {
		this.assureurVille = assureurVille;
	}


	@Column(name = "assureurGouvernorat", length = 254)
	public String getAssureurGouvernorat() {
		return assureurGouvernorat;
	}



	public void setAssureurGouvernorat(String assureurGouvernorat) {
		this.assureurGouvernorat = assureurGouvernorat;
	}


	@Column(name = "assureurNumeroTelephone", length = 254)
	public String getAssureurNumeroTelephone() {
		return assureurNumeroTelephone;
	}



	public void setAssureurNumeroTelephone(String assureurNumeroTelephone) {
		this.assureurNumeroTelephone = assureurNumeroTelephone;
	}


	@Column(name = "assureurFax", length = 254)
	public String getAssureurFax() {
		return assureurFax;
	}



	public void setAssureurFax(String assureurFax) {
		this.assureurFax = assureurFax;
	}


	@Column(name = "assureurEmails", length = 254)
	public String getAssureurEmails() {
		return assureurEmails;
	}



	public void setAssureurEmails(String assureurEmails) {
		this.assureurEmails = assureurEmails;
	}


	@Column(name = "assureurNomComplet", length = 254)
	public String getAssureurNomComplet() {
		return assureurNomComplet;
	}



	public void setAssureurNomComplet(String assureurNomComplet) {
		this.assureurNomComplet = assureurNomComplet;
	}


	@Column(name = "assureurSiteWeb", length = 254)
	public String getAssureurSiteWeb() {
		return assureurSiteWeb;
	}



	public void setAssureurSiteWeb(String assureurSiteWeb) {
		this.assureurSiteWeb = assureurSiteWeb;
	}


	@Override
	public String toString() {
		return "Assureur [assureurId=" + assureurId + ", assureurLibelle="
				+ assureurLibelle + ", assureurAdresse=" + assureurAdresse
				+ ", assureurVille=" + assureurVille + ", assureurGouvernorat="
				+ assureurGouvernorat + ", assureurNumeroTelephone="
				+ assureurNumeroTelephone + ", assureurFax=" + assureurFax
				+ ", assureurEmails=" + assureurEmails
				+ ", assureurNomComplet=" + assureurNomComplet
				+ ", assureurSiteWeb=" + assureurSiteWeb + "]";
	}
	
	
	
	
	
	
	
}
