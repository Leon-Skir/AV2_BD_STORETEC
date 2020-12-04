package br.edu.unijuazeiro.StoreTec1.Models.Collectsale;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.edu.unijuazeiro.StoreTec1.Models.Business.Product;
import lombok.Data;



@Data
@Entity
public class Collectproduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_collectproduct")
    @SequenceGenerator(sequenceName = "seq_collectproduct", allocationSize = 1, initialValue = 1, name = "gen_collectproduct")
    private Long code;

    @ManyToOne
    @JoinColumn(name = "Id_product")
    private Product product;

    private Double quantities;

    public Collectproduct(Product product, Double quantities){
        this.product = product;
        this.quantities = quantities;
    }

    public Product getProduct(){
        return this.product;
    }

    public void setProduct(Product product){
        this.product = product;
    }


    public Double getQuantity(){
        return this.quantities;
    }

    public void setQuantity(Double quantities){
        this.quantities = quantities;
    }

}



