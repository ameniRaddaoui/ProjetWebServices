package tn.iit.projet.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelleSeance;
	private String heureDebut;
	private String heureFin;
	private String date;

	public Seance(String libelleSeance, String heureDebut, String heureFin, String date) {
		super();
		this.libelleSeance = libelleSeance;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.date = date;
	}

	public Seance() {
		super();
	}

	public Seance(Long id, String libelleSeance, String heureDebut, String heureFin, String date) {
		super();
		this.id = id;
		this.libelleSeance = libelleSeance;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((heureDebut == null) ? 0 : heureDebut.hashCode());
		result = prime * result + ((heureFin == null) ? 0 : heureFin.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelleSeance == null) ? 0 : libelleSeance.hashCode());
		return result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelleSeance() {
		return libelleSeance;
	}

	public void setLibelleSeance(String libelleSeance) {
		this.libelleSeance = libelleSeance;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (heureDebut == null) {
			if (other.heureDebut != null)
				return false;
		} else if (!heureDebut.equals(other.heureDebut))
			return false;
		if (heureFin == null) {
			if (other.heureFin != null)
				return false;
		} else if (!heureFin.equals(other.heureFin))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelleSeance == null) {
			if (other.libelleSeance != null)
				return false;
		} else if (!libelleSeance.equals(other.libelleSeance))
			return false;
		return true;
	}

}
