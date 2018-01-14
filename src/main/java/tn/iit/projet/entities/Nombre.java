package tn.iit.projet.entities;

import java.io.Serializable;

public class Nombre implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private long creneau;
	private long ensignant;
	private long groupe;
	private long seance;
	private long salle;

	public long getCreneau() {
		return creneau;
	}

	public void setCreneau(long creneau) {
		this.creneau = creneau;
	}

	public long getEnsignant() {
		return ensignant;
	}

	public void setEnsignant(long ensignant) {
		this.ensignant = ensignant;
	}

	public long getGroupe() {
		return groupe;
	}

	public void setGroupe(long groupe) {
		this.groupe = groupe;
	}

	public long getSeance() {
		return seance;
	}

	public void setSeance(long seance) {
		this.seance = seance;
	}

	public long getSalle() {
		return salle;
	}

	public void setSalle(long salle) {
		this.salle = salle;
	}

	public Nombre(long creneau, long ensignant, long groupe, long seance, long salle) {
		super();
		this.creneau = creneau;
		this.ensignant = ensignant;
		this.groupe = groupe;
		this.seance = seance;
		this.salle = salle;
	}

	public Nombre() {
		super();
	}

	@Override
	public String toString() {
		return "Nombre [creneau=" + creneau + ", ensignant=" + ensignant + ", groupe=" + groupe + ", seance=" + seance
				+ ", salle=" + salle + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (creneau ^ (creneau >>> 32));
		result = prime * result + (int) (ensignant ^ (ensignant >>> 32));
		result = prime * result + (int) (groupe ^ (groupe >>> 32));
		result = prime * result + (int) (salle ^ (salle >>> 32));
		result = prime * result + (int) (seance ^ (seance >>> 32));
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
		Nombre other = (Nombre) obj;
		if (creneau != other.creneau)
			return false;
		if (ensignant != other.ensignant)
			return false;
		if (groupe != other.groupe)
			return false;
		if (salle != other.salle)
			return false;
		if (seance != other.seance)
			return false;
		return true;
	}

}
