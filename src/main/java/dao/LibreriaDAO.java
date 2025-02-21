package dao;

import database.HibernateUtil;

import model.Libreria;
import model.Libro;
import org.hibernate.Session;

import java.util.List;

public class LibreriaDAO {
    private Session session;

    public void agregarLibreria(Libreria libreria) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public void actualizarLibreria(Libreria libreria) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libro> obtenerLibros(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Libreria libreria = session.get(Libreria.class, id);
        session.getTransaction().commit();
        session.close();
        return libreria.getLibros();
    }


    public Libreria obtenerLibreria(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Libreria libreria = session.get(Libreria.class, id);
        session.getTransaction().commit();
        session.close();
        return libreria;
    }

    public List<Libreria> obtenerLibrerias(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Libreria> librerias = session.createQuery("from Libreria").list();
        session.getTransaction().commit();
        session.close();
        return librerias;
    }
}
