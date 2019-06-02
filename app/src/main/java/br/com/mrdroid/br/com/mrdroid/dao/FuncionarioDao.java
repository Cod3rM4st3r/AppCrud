package br.com.mrdroid.br.com.mrdroid.dao;

import android.util.Log;

import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.mrdroid.WebServiceC;
import br.com.mrdroid.br.com.mrdroid.model.Config;
import br.com.mrdroid.br.com.mrdroid.model.Funcionario;

public class FuncionarioDao {


    private static String salvar = "/gravar";
    private static String excluir = "/excluir/{id}";

    private WebServiceC web;
    public String gravar(Funcionario f){
        Gson g = new Gson();

        String jsonFunc = g.toJson(f);
        Log.i("func", jsonFunc);
        Config a = new Config();
        a.getShaed();
        //Log.i("Config",a.getIp() + ":"+ a.getPorta());
        WebServiceC web = new WebServiceC(a,salvar,jsonFunc);
        return web.sendRequest();
    }


    public String excluir(){
        return null;
    }

    public List<Funcionario> listar(){
        List<Funcionario> list = null ;
        list = new ArrayList<>();
        Funcionario f = new Funcionario();
        f.setNome("Joao das Contas");
        f.setSalario(2.500);

        f.setDataEmi(new Date());
        list.add(f);

        return list;
    }

    public String editar(){

        return null;
    }
}
