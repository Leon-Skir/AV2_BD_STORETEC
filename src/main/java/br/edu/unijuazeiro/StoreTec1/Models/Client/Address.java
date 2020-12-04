package br.edu.unijuazeiro.StoreTec1.Models.Client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
  
    //Novamente usando id, mas a sequence fará isso.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_address")
    @SequenceGenerator(sequenceName = "seq_address", allocationSize = 1, initialValue = 1, name = "gen_address")
    private Integer id_address;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String nbhood;

    @Column(nullable = true)
    private String street;

    
    @Column(nullable = true)
    private String cep;

    @Column(nullable = true)
    private String number;

    // @OneToOne
    // @JoinColumn(name = "idclient")
    // private Client client;


    public Address(String state, String city, String nbhood, String street, String cep, String number){
        this.state = state;
        this.city = city;
        this.nbhood = nbhood;
        this.street = street;
        this.cep = cep;
        this.number = number;
    }


    public String getState(){
        return this.state;
    }
    
    public String getCity(){
        return this.city;
    }

    public String getNbhood(){
        return this.nbhood;
    }

    public String getStreet(){
        return this.street;
    }

    
    public String getCep(){
        return this.cep;
    }

    public String getNumber(){
        return this.number;
    }


                                                         //Setters
    public void setState(String state){
        this.state = state;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setNbhood(String nbhood){
        this.nbhood = nbhood;
    }
    
    public void setStreet(String street){
        this.street = street;
    }
    
    public void setCep(String cep){
        this.cep = cep;
    }
    
    public void setNumber(String number){
        this.number = number;
    }

}
    
