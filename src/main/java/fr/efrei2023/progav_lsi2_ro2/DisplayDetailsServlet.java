package fr.efrei2023.progav_lsi2_ro2;

import fr.efrei2023.model.EmployesEntity;
import fr.efrei2023.model.EmployesSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "displayDetailsServlet", value = "/details")
public class DisplayDetailsServlet extends HttpServlet {

    @EJB
    private EmployesSessionBean em;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idEmploye = request.getParameter("idEmploye");

        String action = request.getParameter("action");

        if ("Details".equals(action)) {
            if(idEmploye != null){
                EmployesEntity user = em.getEmployeById(Integer.parseInt(idEmploye));
                request.setAttribute("employe", user);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            }

        } else if ("Supprimer".equals(action)) {
            if(idEmploye != null){
                EmployesEntity user = em.getEmployeById(Integer.parseInt(idEmploye));
                em.deleteEmployeById(user);
            }
            listEmploye(request, response);
        } else if ("Retour".equals(action)) {
            listEmploye(request, response);
        } else if ("Update".equals(action)) {
            handleUpdate(request, response);
        } else {
            listEmploye(request, response);
        }
    }

    protected void listEmploye(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EmployesEntity> list = em.getTousLesEmployes();
        request.setAttribute("tousLesEmployes", list);
        request.getRequestDispatcher("bienvenue.jsp").forward(request, response);
    }


    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idEmploye"));
        EmployesEntity employe = em.getEmployeById(id);

        employe.setNom(request.getParameter("nom"));
        employe.setPrenom(request.getParameter("prenom"));
        employe.setTeldom(request.getParameter("teldom"));
        employe.setTelport(request.getParameter("telport"));
        employe.setTelpro(request.getParameter("telpro"));
        employe.setAdresse(request.getParameter("adresse"));
        employe.setCodepostal(request.getParameter("codepostal"));
        employe.setVille(request.getParameter("ville"));
        employe.setEmail(request.getParameter("email"));

        em.updateEmploye(employe);
        listEmploye(request, response);
    }
}