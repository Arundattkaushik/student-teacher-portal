package com.hiber.utility;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {
	private static SessionFactory factory = null;
	private static Session session = null;
	private static Boolean isFactoryClosed = false;
	private static Boolean isSessionClosed = false;
	private static Scanner scanner = null;
	
	private static SessionFactory getFactory() {
		if (factory == null) {
			factory = new Configuration().configure("com/hiber/todo/cfg.xml").buildSessionFactory();
			return factory;
		}
		else {
			return factory;
		}
	}
	
	public static Session getSession() {
		if (session==null) {
			session = Utils.getFactory().openSession();
			return session;
		} 
		else {
			return session;
		}
	}
	
	public static Boolean closeFactory() {
		if (factory.isOpen()) {
			factory.close();
			isFactoryClosed = true;
		}
		return isFactoryClosed;
	}
	
	public static Boolean closeSession() {
		if (session.isOpen()) {
			session.close();
			isSessionClosed = true;
		}
		return isSessionClosed;
	}
	
	public static Scanner input() {
		if (scanner==null) {
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
}
