package br.com.mrdroid.br.com.mrdroid.dao;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.mrdroid.WebServiceC;
import br.com.mrdroid.br.com.mrdroid.model.Config;
import br.com.mrdroid.br.com.mrdroid.model.Funcionario;

public class FuncionarioDao {


    private static String salvar = "/gravar";
    private static String excluir = "/excluir/";
    private static String buscar = "/buscar";

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


    public String excluir(int id){
        Config a = new Config();
        a.getShaed();
        //Log.i("Config",a.getIp() + ":"+ a.getPorta());
        WebServiceC web = new WebServiceC(a,excluir+id);

        return web.delete();
    }

    public List<Funcionario> listar(){
        List list = null ;
        list = new ArrayList<Funcionario>();
        Config a = new Config();
        a.getShaed();

        /*Funcionario f = new Funcionario();
        f.setNome("Joao das Contas");
        f.setSalario(2.500);

        f.setDataEmi(new Date());*/

       Gson s = new Gson();
       Type typeListUser = new TypeToken<ArrayList<Funcionario>>(){}.getType();
       WebServiceC web = new WebServiceC(a,buscar);

       list = s.fromJson(web.sendRequest(),typeListUser);



        return list;
    }

    public String editar(){

        return null;
    }
}
