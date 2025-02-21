package dao;

import database.HibernateUtil;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;

import java.util.List;

public class LibroDAO {
    private Session session;

    public void agregarLibro(Libro libro) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libro);
        session.getTransaction().commit();
        session.close();
    }

    public void modificarLibro(Libro libro) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(libro);
        session.getTransaction().commit();
        session.close();
    }

    public Libro buscarLibro(int id) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Libro libro = session.get(Libro.class, id);
        session.getTransaction().commit();
        session.close();
        return libro;
    }

    public List<Libro> buscarLibros() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Libro> libros = session.createQuery("from Libro").list();
        session.getTransaction().commit();
        session.close();
        return libros;
    }

    public void asignarLibroALibreria(int idLibro, int idLibreria) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            // Obtener libro y librería desde la base de datos
            Libro libro = session.get(Libro.class, idLibro);
            Libreria libreria = session.get(Libreria.class, idLibreria);

            // Verificar que ambos existen
            if (libro == null || libreria == null) {
                System.out.println("El libro o la librería no existen.");
                session.getTransaction().rollback();
                return;
            }

            // Si la librería no está en la lista del libro, la agregamos
            if (!libro.getLibrerias().contains(libreria)) {
                libro.getLibrerias().add(libreria);
                libreria.getLibros().add(libro);
            }

            // Guardar los cambios en la base de datos
            session.merge(libro);
            session.merge(libreria);

            session.getTransaction().commit();
            System.out.println("Libro '" + libro.getTitulo() + "' asignado a librería '" + libreria.getNombre() + "'.");
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void agregarLibroALibreria(int idLibro, int idLibreria, int cantidad) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Buscar el libro y la librería
        Libro libro = session.get(Libro.class, idLibro);
        Libreria libreria = session.get(Libreria.class, idLibreria);

        if (libro != null && libreria != null) {
            // Verificar si el libro ya está asignado a la librería
            String sql = "SELECT cantidad FROM libreria_libro WHERE id_libro = :idLibro AND id_libreria = :idLibreria";
            Integer cantidadExistente = (Integer) session.createNativeQuery(sql)
                    .setParameter("idLibro", idLibro)
                    .setParameter("idLibreria", idLibreria)
                    .uniqueResult();

            if (cantidadExistente == null) {
                // Si no existe, crear la relación con la cantidad
                String insertQuery = "INSERT INTO libreria_libro (id_libro, id_libreria, cantidad) VALUES (:idLibro, :idLibreria, :cantidad)";
                session.createNativeQuery(insertQuery)
                        .setParameter("idLibro", idLibro)
                        .setParameter("idLibreria", idLibreria)
                        .setParameter("cantidad", cantidad)
                        .executeUpdate();
            } else {
                // Si existe, solo actualizar la cantidad
                String updateQuery = "UPDATE libreria_libro SET cantidad = cantidad + :cantidad WHERE id_libro = :idLibro AND id_libreria = :idLibreria";
                session.createNativeQuery(updateQuery)
                        .setParameter("idLibro", idLibro)
                        .setParameter("idLibreria", idLibreria)
                        .setParameter("cantidad", cantidad)
                        .executeUpdate();
            }
        }

        session.getTransaction().commit();
        session.close();
    }

    public Integer obtenerCantidadLibroEnLibreria(int idLibro, int idLibreria) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Consulta para obtener la cantidad de un libro en una librería específica
        String sql = "SELECT cantidad FROM libreria_libro WHERE id_libro = :idLibro AND id_libreria = :idLibreria";
        Integer cantidad = (Integer) session.createNativeQuery(sql)
                .setParameter("idLibro", idLibro)
                .setParameter("idLibreria", idLibreria)
                .uniqueResult();

        session.getTransaction().commit();
        session.close();

        return cantidad; // Retorna la cantidad o null si no se encuentra el libro en la librería
    }






}
