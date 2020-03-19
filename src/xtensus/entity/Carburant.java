package xtensus.entity;

// Generated 22 juin 2013 11:30:04 by Hibernate Tools 3.4.0.Beta1

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

/**
 * Carburant generated by hbm2java
 */
@Entity
@Table(name = "carburant")
public class Carburant extends Entite implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196076758286887105L;
	private Integer carburantId;
	private String carburantLibelle;
	private Float carburantPrixLitre;
	

	public Carburant() {
	}

	public Carburant(String carburantLibelle, Float carburantPrixLitre) {
		this.carburantLibelle = carburantLibelle;
		this.carburantPrixLitre = carburantPrixLitre;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "carburantId", unique = true, nullable = false)
	public Integer getCarburantId() {
		return this.carburantId;
	}

	public void setCarburantId(Integer carburantId) {
		this.carburantId = carburantId;
	}

	@Column(name = "carburantLibelle", length = 254)
	public String getCarburantLibelle() {
		return this.carburantLibelle;
	}

	public void setCarburantLibelle(String carburantLibelle) {
		this.carburantLibelle = carburantLibelle;
	}

	@Column(name = "carburantPrixLitre", precision = 12, scale = 0)
	public Float getCarburantPrixLitre() {
		return this.carburantPrixLitre;
	}

	public void setCarburantPrixLitre(Float carburantPrixLitre) {
		this.carburantPrixLitre = carburantPrixLitre;
	}

	@Override
	public String toString() {
		return "Carburant [carburantId=" + carburantId + ", carburantLibelle="
				+ carburantLibelle + ", carburantPrixLitre="
				+ carburantPrixLitre + "]";
	}

	

}
