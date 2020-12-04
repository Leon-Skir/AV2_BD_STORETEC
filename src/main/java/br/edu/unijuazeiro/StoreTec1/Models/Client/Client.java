package br.edu.unijuazeiro.StoreTec1.Models.Client;



import java.net.PasswordAuthentication;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import br.edu.unijuazeiro.StoreTec1.services.ClientCPTpassw;

import org.hibernate.hql.internal.ast.tree.PathNode;
import org.hibernate.type.TrueFalseType;

import br.edu.unijuazeiro.StoreTec1.Models.Business.Product;
import br.edu.unijuazeiro.StoreTec1.Models.Business.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_client")
    @SequenceGenerator(sequenceName = "seq_client", allocationSize = 1, initialValue = 1, name = "gen_client")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String cpf;

    // @Temporal(TemporalType.TIMESTAMP)
    // private Date birthday;
    
    @Column(nullable = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Sale sale;


    public Client(String name, String cpf, String phone,String password, Address address){
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.password = password;
        this.address = address;
    }

    public Client(String name, String cpf, String phone, String password){
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.password = password;
    }

    

    public String getName(){
        return this.name;
    }
    
    public String getCpf(){
        return this.cpf;
    }

    public String getPhone(){
        return this.phone;
    }

    
    public String getPassword(){
        return this.password;
    }

    public Date getDate(){
        return this.createdAt;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public void setDate(Date createdAt){
        this.createdAt = createdAt;
    }
    
    
   

}
