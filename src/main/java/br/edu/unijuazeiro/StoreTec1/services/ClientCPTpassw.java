package br.edu.unijuazeiro.StoreTec1.services;

import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.edu.unijuazeiro.StoreTec1.Models.Client.Client;
import br.edu.unijuazeiro.StoreTec1.Models.Employee.Employee;
import br.edu.unijuazeiro.StoreTec1.dao.ClientDAO;
import br.edu.unijuazeiro.StoreTec1.dao.EmployeeDAO;

public class ClientCPTpassw {

    private  ClientDAO clientDAO = new ClientDAO();

    public void save(Client client) {
        if (client.getPassword().length() > 15) {
            // disparo uma exception
        }
        clientDAO.save(client);
    }

    public void update(Client client) {
        if (client.getPassword() == null) {
            throw new RuntimeException("Senha necessária. Favor, digite-a!");
        }
        String pwdCipher = BCrypt.withDefaults().hashToString(11, client.getPassword().toCharArray());
        System.out.println(pwdCipher);
        client.setPassword(pwdCipher);
        clientDAO.update(client);
    }

    public Client login(String cpf, String password) {
        Client client = clientDAO.findByCPF(cpf);
        if (client == null) {
            throw new RuntimeException("Dados inválidos");
        }
        if (!BCrypt.verifyer().verify(password.toCharArray(), client.getPassword().toCharArray()).verified) {
            throw new RuntimeException("Dados inválidos");
        }
        return client;
    }

    public List<Client> list() {
        return clientDAO.list();
    }



public void ctpconcret(){
    ClientCPTpassw clientCPTpassw = new ClientCPTpassw();    
    List<Client> clients = clientCPTpassw.list();
    clients.forEach(empy -> {
    //     System.out.println(c.getCode());
    System.out.println(empy.getName());
    //     System.out.println(c.getEmail());
    System.out.println("> " + empy.getPassword());
        try {
            empy.setPassword("123");
            System.out.println("> " + empy.getPassword());
            clientCPTpassw.update(empy);
        }   catch (Exception e) {
            System.out.println(e.getMessage());
            }
        });}
}