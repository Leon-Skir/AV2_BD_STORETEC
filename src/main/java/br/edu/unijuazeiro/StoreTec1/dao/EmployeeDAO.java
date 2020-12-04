package br.edu.unijuazeiro.StoreTec1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.edu.unijuazeiro.StoreTec1.Models.Employee.Employee;
import br.edu.unijuazeiro.StoreTec1.dao.util.ConnectionFactory;

public class EmployeeDAO {

    public static void save(Employee employee) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public void update(Employee employee) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    //Observa o objeto ClientId
    public void remove(Integer employeeid) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Employee employee = em.find(Employee.class, employeeid);
            em.remove(employee);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public static Employee findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Employee employee = em.find(Employee.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return employee;
    }

     public static Employee findByCPF(String cpf) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Employee empy = null;
        try {
            empy = em.createQuery("from Employee empy where empy.cpf = :cpf", Employee.class).setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (NoResultException e) {
            // System.out.println("Não foi encontrado cliente com esse e-mail.");
            return null;
        }
        if (em.isOpen()) {
            em.close();
        }
        return empy;
    }


    // public Client findByEmail(String email) {
    //     EntityManager em = ConnectionFactory.getEntityManager();
    //     Customer c = null;
    //     try {
    //         c = em.createQuery("from Customer c where c.email = :mail", Customer.class).setParameter("mail", email)
    //                 .getSingleResult();
    //     } catch (NoResultException e) {
    //         // System.out.println("Não foi encontrado cliente com esse e-mail.");
    //         return null;
    //     }
    //     if (em.isOpen()) {
    //         em.close();
    //     }
    //     return c;
    // }

    // public List<Client> findByName(String name) {
    //     EntityManager em = ConnectionFactory.getEntityManager();
    //     List<Client> clients = em.createQuery("select clients from Client clients where lower(clients.name) like lower(:name)", Client.class)
    //             .setParameter("name", "%" + name + "%").getResultList();
    //     if (em.isOpen()) {
    //         em.close();
    //     }
    //     return clients;
    // }

    // public List<Customer> findByAddress(String street) {
    //     EntityManager em = ConnectionFactory.getEntityManager();
    //     List<Customer> customers = em.createQuery("select c from Customer c join c.address a where lower(a.street) like lower(:street)", Customer.class)
    //             .setParameter("street", "%" + street + "%").getResultList();
    //     if (em.isOpen()) {
    //         em.close();
    //     }
    //     return customers;
    // }

    // public List<Customer> findByNameOrAddress(String text) {
    //     EntityManager em = ConnectionFactory.getEntityManager();
    //     List<Customer> customers = em.createQuery("select c from Customer c join c.address a "+
    //        "where lower(c.name) like lower(:search) or lower(a.street) like lower(:search)", Customer.class)
    //             .setParameter("search", "%" + text + "%").getResultList();
    //     if (em.isOpen()) {
    //         em.close();
    //     }
    //     return customers;
    // }


    public List<Employee> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Employee> employees = em.createQuery("from Employee", Employee.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return employees;
    }
}
