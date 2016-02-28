package com.formation.spring.service;

import java.util.Collection;

import com.formation.spring.Adherent;
import com.formation.spring.dao.IDaoAdherent;

public class IServiceAdherentImpl implements IServiceAdherent {
	private IDaoAdherent dao;

	public IServiceAdherentImpl() {
		super();
	}

	public IDaoAdherent getDao() {
		return dao;
	}

	public void setDao(IDaoAdherent dao) {
		this.dao = dao;
	}

	@Override
	public void initAdherent() {
		dao.initAdherent();
	}

	@Override
	public Collection<Adherent> getAllAdherent() {
		return dao.getAllAdherent();
	}

	@Override
	public String toString() {
		return "IServiceAdherentImpl [dao=" + dao + "]";
	}

}
