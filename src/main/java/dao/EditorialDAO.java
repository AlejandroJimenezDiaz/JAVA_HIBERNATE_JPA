package dao;

import database.HibernateUtil;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;

import java.util.List;

public class EditorialDAO {
    private Session session;

    public void agregarEditorial(Editorial editorial) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(editorial);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libro> getLibrosEditorial(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Editorial editorial =session.get(Editorial.class, id);
        session.getTransaction().commit();
        session.close();
        return editorial.getLibros();
    }
}
