package com.example.dao.impl;

import com.example.dao.GenericDao;
import com.example.entity.Student;
import jakarta.persistence.*;

import java.util.List;

public class StudentDao implements GenericDao<Student, Long> {

    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hillel-persistence-unit");

    public void save(Student entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
        em.close();
    }

    public Student findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    public Student findByEmail(String email) {
        EntityManager em = emf.createEntityManager();

        Student student = em.createQuery(
                        "SELECT s FROM Student s WHERE s.email = :email", Student.class)
                .setParameter("email", email)
                .getSingleResult();
        em.close();
        return student;
    }

    public List<Student> findAll() {
        EntityManager em = emf.createEntityManager();

        List<Student> list = em.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
        em.close();
        return list;
    }

    public Student update(Student entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student updated = em.merge(entity);
        tx.commit();
        em.close();
        return updated;
    }

    public boolean deleteById(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Student student = em.find(Student.class, id);

        if (student == null) {
            em.close();
            return false;
        }

        tx.begin();
        em.remove(student);
        tx.commit();
        em.close();
        return true;
    }

    public void deleteAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Student").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
