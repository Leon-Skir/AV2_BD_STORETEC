package br.edu.unijuazeiro.StoreTec1.dao;

import java.util.List;

import javax.persistence.EntityManager;


import br.edu.unijuazeiro.StoreTec1.Models.Business.Sale;
import br.edu.unijuazeiro.StoreTec1.dao.util.ConnectionFactory;

public class SaleDAO {
    
    public static void save(Sale sale) {
        EntityManager em = ConnectionFactory.getEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(sale);
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
    
        public void update(Sale sale) {
            EntityManager em = ConnectionFactory.getEntityManager();
            try {
                em.getTransaction().begin();
                em.merge(sale);
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
        public void remove(Integer saleid) {
            EntityManager em = ConnectionFactory.getEntityManager();
            try {
                em.getTransaction().begin();
                Sale sale = em.find(Sale.class, saleid);
                em.remove(sale);
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
    
        public Sale findById(Integer code) {
            EntityManager em = ConnectionFactory.getEntityManager();
            Sale sale = em.find(Sale.class, code);
            if (em.isOpen()) {
                em.close();
            }
            return sale;
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
    
            
        public List<Sale> list() {
            EntityManager em = ConnectionFactory.getEntityManager();
            List<Sale> sales = em.createQuery("from Sale", Sale.class).getResultList();
            if (em.isOpen()) {
                em.close();
            }
            return sales;
        }
}
