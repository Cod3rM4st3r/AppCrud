package br.com.mrdroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.mrdroid.br.com.mrdroid.dao.FuncionarioDao;
import br.com.mrdroid.br.com.mrdroid.model.Funcionario;


public class Cadastrar extends   Fragment {

    private EditText nome;
    private EditText salario;
    private Button btnSalva;
    private Button foto;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);


        return  rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nome = view.findViewById(R.id.nome);
        salario = view.findViewById(R.id.salario);
        btnSalva = view.findViewById(R.id.btnSalvar);
        foto = view.findViewById(R.id.btnCamera);

        btnSalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nome.getText().toString();
                String salar = salario.getText().toString();
                Funcionario f = new Funcionario();
                f.setNome(name);
                try{
                    f.setSalario(salar);
                    //f.setDate() tem q fazer
                    FuncionarioDao fdao = new FuncionarioDao();
                    Toast.makeText(getContext(),fdao.gravar(f),Toast.LENGTH_LONG).show();
                }catch(Exception e ){

                }
            }
        });
    }


}
