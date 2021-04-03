package com.DA0;

import java.sql.SQLException;

import com.DA0.exceptions.DAOException;
import com.beans.Note;

public interface NoteDAOI {
	Note[] trouverNotesProfesseur( int num ) throws DAOException, SQLException;
	Note[] trouverNotesEtudiant( int num ) throws DAOException, SQLException;
}
