package com.formation.spring;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.formation.spring.service.IServiceAdherentImpl;

public class Main {

	public static void main(String[] args) {

		ClassPathResource cpr = new ClassPathResource("applicationContext.xml");

		ListableBeanFactory bf = new XmlBeanFactory(cpr);

		IServiceAdherentImpl sa = (IServiceAdherentImpl) bf.getBean("service");

		System.out.println(sa.toString());

		System.out.println(sa.getAllAdherent());

	}

}
