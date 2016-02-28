package com.formation.spring.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnexionBD {
	// La liste des attributs dependant de la connexion
	private Connection con;
	private Statement smt;
	private ResultSet result = null;
	private String BD;
	private String url;
	private String login, pass;
	private String driver;

	// Constructeurs pour initialiser la connexion
	public ConnexionBD() {
		driver = "com.mysql.jdbc.Driver";
		BD = "bd_Spring_Biblio";
		url = "jdbc:mysql://localhost/" + BD;
		login = "root";
		pass = "";
	}

	public ConnexionBD(String drive, String base, String URLChemin, String log,
			String password) {
		driver = drive;
		BD = base;
		url = URLChemin + BD;
		login = log;
		pass = password;
	}

	// Methode vous permettant de se connecter a la BD
	public void connect() {

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, pass);
			smt = con.createStatement();
		} catch (ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Problème de Base de données");
			System.err.println(" Erreur de chargement du driver :" + e1);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Problème de Base de données");
			System.err.println(" Erreur lors de la connexion : " + sqle);
		}
	}

	// Methode pour se deconnecter
	public void DisConnect() {
		try {
			smt.close();
			con.close();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Problème de Base de données");
			Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	// Methode retournant un resultset Ã  partir d'une requete de type select
	public ResultSet select(String query) {
		try {
			result = smt.executeQuery(query);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"Problème de la requete de selection");
			Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return result;
	}

	// requete de mise a jour pour : insert,update,delete returnn 0 si erreur
	// d'execution
	public int MiseAjour(String query) {
		int i = 0;
		try {
			i = smt.executeUpdate(query);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"Problème d'execution de la requete de mise a jours");
			Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE,
					null, ex);

		}
		return i;
	}

	// methode de mise ajours d'une liste de selection
	public int MiseAjourListe(String query) {
		int i = 0;
		try {
			i = smt.executeUpdate(query);

		} catch (Exception ex) {

		}
		return i;
	}

	// Methode vous permettant de se connecter a la BD
	public void ValiderTransaction() {

		try {
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException sqle) {
			System.err.println(" Erreur lors de la transaction : " + sqle);
		}
	}

	// affichage du resultat sous forme de tableau en utilisant les metadata
	void afficheResultat(ResultSet result) {
		try {
			System.out.println("\n");

			ResultSetMetaData metadata = result.getMetaData();

			for (int i = 1; i <= metadata.getColumnCount(); i++)
				System.out.print("\t   "
						+ metadata.getColumnName(i).toUpperCase() + " ");

			System.out.println("\n");

			while (result.next()) {
				for (int i = 1; i <= metadata.getColumnCount(); i++)
					System.out.print("\t" + result.getObject(i).toString()
							+ "\t |");

				System.out
						.println("\n-------------------------------------------------------");

			}
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
