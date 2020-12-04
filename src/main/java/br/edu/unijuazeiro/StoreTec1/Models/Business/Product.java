package br.edu.unijuazeiro.StoreTec1.Models.Business;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    //Sequence fará o trabalho

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_product")
    @SequenceGenerator(sequenceName = "seq_product", allocationSize = 1, initialValue = 1, name = "gen_product")
    private Integer Id_product;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Sale sale;

    public Product(String description, Double amount, Double price){
        this.description = description;
        this.amount = amount;
        this.price = price;
    }


    public String getDescription(){
        return this.description;
    }
    
    public Double getAmount(){
        return this.amount;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setDescriptiom(String description){
        this.description = description;
    }

    public void setAmount(Double amount){
        this.amount = amount;
    }

    public void setPrice(Double price){
        this.price = price;
    }






}
