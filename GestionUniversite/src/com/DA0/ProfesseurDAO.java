package com.DA0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DA0.exceptions.DAOException;
import com.beans.Note;
import com.beans.Professeur;

public class ProfesseurDAO implements ProfesseurDAOI{
	 private DAOFactory  daoFactory;

	    ProfesseurDAO( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }
	@Override
	public Professeur trouver(String nom, String prenom) throws DAOException, SQLException {
		Connection cx=null;
		int numero=0;
		Professeur p=null;
		Note[]note=null;
		String sql="select * from professeur where nom=? and prenom =?";
		PreparedStatement pst=null;
		try {
			cx=daoFactory.getConnection();
			pst=cx.prepareStatement(sql);
			pst.setString(1, nom);
			pst.setString(2, prenom);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
			p=new Professeur();
			p.setNom(rs.getString("nom"));
			p.setPrenom(rs.getString("prenom"));
			p.setMatiere(rs.getString("matiere"));
			numero=rs.getInt("idprofesseur");
			note=new NoteDAO(daoFactory).trouverNotesProfesseur(numero);
			p.setNotes(note);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(cx!=null) {
				cx.close();
			}
		}
		return p;

	}

}
