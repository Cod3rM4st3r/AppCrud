package br.com.mrdroid.br.com.mrdroid.model;

import java.util.Date;

public class Funcionario {
    private String nome;
    private Date dataEmi;
    private double salario;
    private Byte[] foto;
    private int id=0;

    public int getId() {
        if(id ==0 ){
            return 0;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

        return "2018-01-01";

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
        return "\nCodigo:  "+this.getId()+"\nNome :"+this.getNome() + "\nSalario :"+this.getSalario()+"\nData : "+this.getDataEmi()+"\n";
    }
}
