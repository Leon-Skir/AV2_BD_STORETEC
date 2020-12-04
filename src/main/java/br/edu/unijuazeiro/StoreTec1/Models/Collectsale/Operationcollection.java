package br.edu.unijuazeiro.StoreTec1.Models.Collectsale;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "tb_Operationcollection")
public class Operationcollection {

    @Id // indica que CODE é o campo chave-primária
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_operationcollection")
    @SequenceGenerator(sequenceName = "seq_operationcollection", allocationSize = 1, initialValue = 1, name = "gen_operationcollection")
    private Long code;

    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Collectproduct> collectproducts;

    public void sumTotal() {
        total = 0.0;
        for (Collectproduct collectproduct : collectproducts) {
            try {
                total += collectproduct.getQuantity() * collectproduct.getProduct().getPrice();
            } catch (NullPointerException e) {
                // TODO: handle exception
            }
        }
    }

//     public void decreaseproduct(){}
}


