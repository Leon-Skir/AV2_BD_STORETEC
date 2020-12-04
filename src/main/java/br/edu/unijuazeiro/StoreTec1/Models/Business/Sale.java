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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import br.edu.unijuazeiro.StoreTec1.Models.Client.Client;
import br.edu.unijuazeiro.StoreTec1.Models.Employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sale {
    
    //Sequence fará isso
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_protocol")
    @SequenceGenerator(sequenceName = "seq_protocol", allocationSize = 1, initialValue = 1, name = "gen_protocol")
    private Integer protocol;

    @Column(nullable = false)
    private Double total; 


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Employee employee;

    // @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @JoinColumn
    // private Client client;


    public Sale(Double total){
        this.total = total;
    }

    public Double getTotal(){
        return total;
    }

    public void setTotal(Double total){
        this.total = total;
    }




}
