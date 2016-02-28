package com.formation.spring.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.formation.spring.Adherent;

public class IDAOAdherentImplList implements IDaoAdherent {
	private ArrayList<Adherent> liste = new ArrayList<Adherent>();

	@Override
	public void initAdherent() {
		Adherent a1 = new Adherent("C100", "Mohammed", "Ali", "Rabat");
		Adherent a2 = new Adherent("C200", "Hari", "Badr", "Rabat");
		liste.add(a1);
		liste.add(a2);
	}

	@Override
	public Collection<Adherent> getAllAdherent() {
		return liste;
	}

	@Override
	public String toString() {
		return "IDAOAdherentImplList [liste=" + liste + "Et Taille"
				+ liste.size() + "]";
	}

}
