package com.DA0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DA0.exceptions.DAOException;

import com.beans.Note;

public class NoteDAO implements NoteDAOI{
	private DAOFactory  daoFactory;

    NoteDAO( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	@Override
	public Note[] trouverNotesProfesseur(int num) throws DAOException, SQLException {
		Connection cx=null;
		Note[]n=null;
		String sql2="select count(*) as total from note where idprofesseur=?";
		String sql="select etudiant.nom as nom,etudiant.prenom as prenom,note.matiere as matiere,note.valeur as valeur from note,etudiant where idprofesseur=? and etudiant.idetudiant=note.idetudiant;";
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		try {
			cx=daoFactory.getConnection();
			pst2=cx.prepareStatement(sql2);
			pst2.setInt(1, num);
			ResultSet rs=pst2.executeQuery();
			while(rs.next()) {
				n=new Note[rs.getInt("total")];
				}
			pst=cx.prepareStatement(sql);
			pst.setInt(1, num);
			ResultSet rs2=pst.executeQuery();
			int i=0;
			while(rs2.next()) {
				Note note=new Note();
				note.setMatiere(rs2.getString("matiere"));
				note.setValeur(rs2.getInt("valeur"));
				note.setNom(rs2.getString("nom"));
				note.setPrenom(rs2.getString("prenom"));
				n[i]=note;
				i++;
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
		return n;
	}
	@Override
	public Note[] trouverNotesEtudiant(int num) throws DAOException, SQLException {
		Connection cx=null;
		Note[]n=null;
		String sql2="select count(*) as total from note where idetudiant=?";
		String sql="select etudiant.nom as nom,etudiant.prenom as prenom,note.matiere as matiere,note.valeur as valeur from note,etudiant where etudiant.idetudiant=? and etudiant.idetudiant=note.idetudiant;";
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		try {
			cx=daoFactory.getConnection();
			pst2=cx.prepareStatement(sql2);
			pst2.setInt(1, num);
			ResultSet rs=pst2.executeQuery();
			while(rs.next()) {
				n=new Note[rs.getInt("total")];
				}
			pst=cx.prepareStatement(sql);
			pst.setInt(1, num);
			ResultSet rs2=pst.executeQuery();
			int i=0;
			while(rs2.next()) {
				Note note=new Note();
				note.setMatiere(rs2.getString("matiere"));
				note.setValeur(rs2.getInt("valeur"));
				note.setNom(rs2.getString("nom"));
				note.setPrenom(rs2.getString("prenom"));
				n[i]=note;
				i++;
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
		return n;
	}

}
