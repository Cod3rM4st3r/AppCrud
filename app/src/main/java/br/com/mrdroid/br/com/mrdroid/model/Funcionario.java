package br.com.mrdroid.br.com.mrdroid.model;

import java.util.Date;

public class Funcionario {
    private String nome;
    private Date dataEmi;
    private double salario;
    private Byte[] foto;


    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEmi() {

        return String.valueOf(this.dataEmi.getYear()+"/"+this.dataEmi.getMonth() + "/"+this.dataEmi.getDay());

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

    public void setSalario(String salario) throws Exception {
        try{
            this.salario = Double.parseDouble(salario);
        }catch(Exception e ){
            throw new Exception("Numero incorreto !");
        }
    }

    public String toString(){
        return "Nome :"+this.getNome() + "\nSalario :"+this.getSalario()+"\nData : "+this.getDataEmi();
    }
}
