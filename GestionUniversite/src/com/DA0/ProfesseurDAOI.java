package com.DA0;

import java.sql.SQLException;

import com.DA0.exceptions.DAOException;
import com.beans.Professeur;;

public interface ProfesseurDAOI {
	Professeur trouver( String nom,String prenom ) throws DAOException,SQLException;
}
