package br.edu.unijuazeiro.StoreTec1.dao;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.EntityManager;

import br.edu.unijuazeiro.StoreTec1.Models.Client.Address;
// Importe, mas antes precisar criar a pasta util
// import br.edu.unijuazeiro.StoreTec1.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.StoreTec1.Models.Client.Client;
import br.edu.unijuazeiro.StoreTec1.dao.util.ConnectionFactory;
import br.edu.unijuazeiro.StoreTec1.services.ClientCPTpassw;

public class ClientDAO {

    public static void save(Client client) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            client.setCreatedAt(new Date());;
            em.getTransaction().begin();
            em.persist(client);
            // em.persist(address);
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

    
    public static void update(Client client) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(client);
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
    public static void remove(Integer clientid) {
        EntityManager em = ConnectionFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            Client client = em.find(Client.class, clientid);
            em.remove(client);
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

    
    public static Client findById(Integer code) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Client client = em.find(Client.class, code);
        if (em.isOpen()) {
            em.close();
        }
        return client;
    }

    public Client findByCPF(String cpf) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Client client = null;
        try {
            client = em.createQuery("from Customer c where c.email = :mail", Client.class).setParameter("CPF", cpf)
                    .getSingleResult();
        } catch (NoResultException e) {
            // System.out.println("Não foi encontrado cliente com esse e-mail.");
            return null;
        }
        if (em.isOpen()) {
            em.close();
        }
        return client;
    }

    public static List<Client> findByName(String name) {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Client> clients = em.createQuery("select clients from Client clients where lower(clients.name) like lower(:name)", Client.class)
                .setParameter("name", "%" + name + "%").getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return clients;
    }

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


    public static List<Client> list() {
        EntityManager em = ConnectionFactory.getEntityManager();
        List<Client> clients = em.createQuery("from Client", Client.class).getResultList();
        if (em.isOpen()) {
            em.close();
        }
        return clients;
    }

    
}