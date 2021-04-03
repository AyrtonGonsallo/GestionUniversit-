package com.DA0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DA0.exceptions.DAOException;
import com.beans.Etudiant;
import com.beans.Note;

public class EtudiantDAO implements EtudiantDAOI{
	private DAOFactory  daoFactory;

    EtudiantDAO( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	@Override
	public Etudiant trouver(String nom, String prenom) throws DAOException, SQLException {
		Connection cx=null;
		int numero=0;
		Etudiant et=null;
		Note[]note=null;
		String sql="select * from etudiant where nom=? and prenom =?";
		PreparedStatement pst=null;
		try {
			cx=daoFactory.getConnection();
			pst=cx.prepareStatement(sql);
			pst.setString(1, nom);
			pst.setString(2, prenom);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
			et=new Etudiant();
			et.setNom(rs.getString("nom"));
			et.setPrenom(rs.getString("prenom"));
			et.setFiliere(rs.getString("filiere"));
			numero=rs.getInt("idetudiant");
			note=new NoteDAO(daoFactory).trouverNotesEtudiant(numero);
			et.setNotes(note);
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
		return et;

	}

}
