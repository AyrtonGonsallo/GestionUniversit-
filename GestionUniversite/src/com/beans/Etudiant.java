package com.beans;

public class Etudiant {
	private String nom;
	private String prenom;
	private String filiere;
	private Note[] notes;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public Note[] getNotes() {
		return notes;
	}
	public int getLongueur() {
		return notes.length;
	}
	public void setNotes(Note[] notes) {
		this.notes = notes;
	}
	
	
	
}
