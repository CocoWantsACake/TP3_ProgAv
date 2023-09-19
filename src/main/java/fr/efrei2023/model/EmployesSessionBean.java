package fr.efrei2023.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class EmployesSessionBean {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP2_PU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<EmployesEntity> getTousLesEmployes(){
        return em.createQuery("select e from EmployesEntity e").getResultList();
    }

    public EmployesEntity getEmployeById(int id) {
        return em.find(EmployesEntity.class, id);
    }

    public void deleteEmployeById(EmployesEntity user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(user != null){
            em.remove(user);
            transaction.commit();
        }
    }

    public void updateEmploye(EmployesEntity employe) {
        em.merge(employe);
    }
}
