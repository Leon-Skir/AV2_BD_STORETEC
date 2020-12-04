package br.edu.unijuazeiro.StoreTec1.Models.Employee;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data 
@Entity 
public class Employee {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_employee")
    @SequenceGenerator(sequenceName = "seq_employee", allocationSize = 2, initialValue = 1, name = "gen_employee")
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String cpf;


    @Column(nullable = false)
    private String function;

    private String passw;

    
    public Employee(String name, String cpf, String function, String passw){
        this.name = name;
        this.cpf = cpf;
        this.function = function;
        this.passw = passw;
    }


    public String getName(){
        return this.name;
    }
    
    public String getCPF(){
        return this.cpf;
    }

    public String getFunction(){
        return this.function;
    }
    
    public String getPassword(){
        return this.passw;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String passw){
        this.passw = passw;
    }


    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setFunction(String function){
        this.function = function;
    }
}