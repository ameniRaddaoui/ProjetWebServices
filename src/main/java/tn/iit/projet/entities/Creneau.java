package tn.iit.projet.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Creneau implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean etat;
	private String date;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Groupe groupe;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Enseignant enseignant;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Seance seance;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Salle salle;
	public Creneau(Long id, Groupe groupe, Enseignant enseignant, Seance seance, Salle salle,String date) {
		super();
		this.id = id;
		this.groupe = groupe;
		this.enseignant = enseignant;
		this.seance = seance;
		this.salle = salle;
		
		this.date=date;
	}
	public Creneau(Groupe groupe, Enseignant enseignant, Seance seance, Salle salle,String date) {
		super();
		this.groupe = groupe;
		
		this.enseignant = enseignant;
		this.seance = seance;
		this.salle = salle;
		this.date=date;
	}
	public boolean getEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public Creneau() {
		super();
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Groupe getNiveau() {
		return groupe;
	}
	public void setNiveau(Groupe groupe) {
		this.groupe = groupe;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Seance getSeance() {
		return seance;
	}
	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Creneau [id=" + id + ", groupe=" + groupe + ", enseignant=" + enseignant + ", seance=" + seance
				+ ", salle=" + salle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enseignant == null) ? 0 : enseignant.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((groupe == null) ? 0 : groupe.hashCode());
		result = prime * result + ((salle == null) ? 0 : salle.hashCode());
		result = prime * result + ((seance == null) ? 0 : seance.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Creneau other = (Creneau) obj;
		if (enseignant == null) {
			if (other.enseignant != null)
				return false;
		} else if (!enseignant.equals(other.enseignant))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (groupe == null) {
			if (other.groupe != null)
				return false;
		} else if (!groupe.equals(other.groupe))
			return false;
		if (salle == null) {
			if (other.salle != null)
				return false;
		} else if (!salle.equals(other.salle))
			return false;
		if (seance == null) {
			if (other.seance != null)
				return false;
		} else if (!seance.equals(other.seance))
			return false;
		return true;
	}

}
