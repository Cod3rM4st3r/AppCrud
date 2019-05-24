package br.com.mrdroid.br.com.mrdroid.model;

import java.util.Date;

public class Funcionario {
    private String nome;
    private Date dataEmi;
    private double salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataEmi() {
        return dataEmi;
    }

    public void setDataEmi(Date dataEmi) {
        this.dataEmi = dataEmi;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
