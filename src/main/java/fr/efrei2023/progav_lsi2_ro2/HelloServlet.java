package fr.efrei2023.progav_lsi2_ro2;


import fr.efrei2023.model.EmployesEntity;
import fr.efrei2023.model.EmployesSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @EJB
    private EmployesSessionBean em;
    fr.efrei2023.progav_lsi2_ro2.Utilisateur unUtilisateur;
    public static final String LOGIN_VALIDE = "admin";
    public static final String MOT_DE_PASSE_VALIDE = "prograv";

    public static final String MESSAGE_ERREUR_CREDENTIALS_KO = "Infos de connexion non valides. Merci de les saisir à nouveau";

    public void processRequest (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Les données saisies par l'utilisateur sont placées dans le contexte
        placerUtilisateurDansContexte(request);

        // Récupération de la liste de tous les employés via notre service getTousLesEmployes()
        List<EmployesEntity> tousLesEmployees = em.getTousLesEmployes();

        // Je mets la liste dans l'objet request afin qu'il soit accessible dans les autres couches, notamment la Vue
        request.setAttribute("tousLesEmployes", tousLesEmployees);

        aiguillerVersLaProchainePage(request, response);
    }

    // Une tâche <-> une méthode
    public boolean verifierInfosConnexion(fr.efrei2023.progav_lsi2_ro2.Utilisateur unUtilisateur){
        return (unUtilisateur.getLoginSaisi().equals(LOGIN_VALIDE) && unUtilisateur.getMotDePasseSaisi().equals(MOT_DE_PASSE_VALIDE));
    }


    public void placerUtilisateurDansContexte(HttpServletRequest request){
        unUtilisateur = new fr.efrei2023.progav_lsi2_ro2.Utilisateur();

        unUtilisateur.setLoginSaisi(request.getParameter("champLogin"));
        unUtilisateur.setMotDePasseSaisi(request.getParameter("champMotDePasse"));

        request.setAttribute("utilisateur", unUtilisateur);
    }

    public void aiguillerVersLaProchainePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (verifierInfosConnexion(unUtilisateur )){
            request.getRequestDispatcher("bienvenue.jsp").forward(request, response);
        }else{
            request.setAttribute("messageErreur", MESSAGE_ERREUR_CREDENTIALS_KO);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void init() {
    }

    public void destroy() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

}