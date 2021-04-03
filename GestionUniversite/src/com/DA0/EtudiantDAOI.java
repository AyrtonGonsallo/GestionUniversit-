package com.DA0;

import java.sql.SQLException;

import com.DA0.exceptions.DAOException;
import com.beans.Etudiant;

public interface EtudiantDAOI {
	Etudiant trouver( String nom,String prenom ) throws DAOException,SQLException;
}
