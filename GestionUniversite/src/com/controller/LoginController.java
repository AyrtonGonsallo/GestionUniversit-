package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DA0.DAOFactory;
import com.DA0.EtudiantDAO;
import com.DA0.ProfesseurDAO;
import com.DA0.exceptions.DAOException;
import com.beans.Etudiant;
import com.beans.Professeur;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/index")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EtudiantDAO etudiantDAO=null;
    private ProfesseurDAO professeurDAO=null;
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.etudiantDAO = ((DAOFactory)getServletContext().getAttribute("daofactory")).getEtudiantDAO();
        this.professeurDAO = ((DAOFactory)getServletContext().getAttribute("daofactory")).getProfesseurDAO();
    }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=null;
		if(request.getParameter("envoi")==null){
			view=request.getRequestDispatcher("Index.jsp");
			view.forward(request, response);
		}
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom"); 
		Etudiant e=null;
		Professeur p=null;
		try {
			p=this.professeurDAO.trouver(nom, prenom);
			e=this.etudiantDAO.trouver(nom, prenom);
		} catch (DAOException |SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		if(e!=null){
			view=request.getRequestDispatcher("Accueil_Etudiant.jsp");
		}
		else if(p!=null){
			view=request.getRequestDispatcher("Accueil_Professeur.jsp");
		}
		else if(p==null && e==null){
			view=request.getRequestDispatcher("pas_inscrit.jsp");
		}
		HttpSession session = request.getSession();
		session.setAttribute("professeur", p);
		session.setAttribute("etudiant", e);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
