package dao;

import database.HibernateUtil;
import model.Autor;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {
    private Session session;

    public void agregarAutor(Autor autor) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
    }

    public Autor getAutor(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        Autor autor = session.get(Autor.class, id);
        session.getTransaction().commit();
        session.close();
        return autor;
    }

    public List<Libro> obtenerLibrosPorAutor(int idAutor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Autor autor = session.get(Autor.class, idAutor);
        session.getTransaction().commit();
        session.close();
        return autor.getLibros();
    }

    public List<Autor> getAllautores (){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Autor> query = session.createQuery("from Autor", Autor.class);
        List<Autor> listaAutores = query.list();
        session.getTransaction().commit();
        session.close();
        return listaAutores;
    }

    public List<Autor> getAutoresQuery (){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Autor> query = session.createNamedQuery("Autor.obtenerAutores", Autor.class);
        List<Autor> listaAutores = query.list();
        session.getTransaction().commit();
        session.close();
        return listaAutores;
    }


}
