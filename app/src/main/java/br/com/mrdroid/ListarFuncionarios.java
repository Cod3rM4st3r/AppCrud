package br.com.mrdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.mrdroid.br.com.mrdroid.dao.FuncionarioDao;
import br.com.mrdroid.br.com.mrdroid.model.Funcionario;

public class ListarFuncionarios extends Fragment {

    private List<Funcionario> lista;

    private ListView listView;

    private Button atualizar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View rootView = inflater.inflate(R.layout.listarfuncionarios,container,false);

        return  rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.listView = view.findViewById(R.id.lista);
        atualizar = view.findViewById(R.id.refes);

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarLista();

                final ArrayAdapter<Funcionario> adapter = new ArrayAdapter<Funcionario>(getContext(), android.R.layout.simple_list_item_1, lista);

                listView.setAdapter(adapter);
            }
        });

        FuncionarioDao fdao = new FuncionarioDao();

        this.lista = fdao.listar();

        final ArrayAdapter<Funcionario> adapter = new ArrayAdapter<Funcionario>(getContext(), android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getContext(),
                        "Clicou no item " + position, Toast.LENGTH_LONG).show();*/
                Intent intent = new Intent(getContext(),Detalhe.class);
                intent.putExtra("id",lista.get(position).getId());
                intent.putExtra("nome",lista.get(position).getNome());
                intent.putExtra("salario",lista.get(position).getSalario());
                intent.putExtra("foto",lista.get(position).getFoto());


                startActivity(intent);



            }
        });
    }



    public void carregarLista(){
        FuncionarioDao fdao = new FuncionarioDao();

        this.lista = fdao.listar();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        this.lista = null;
    }
}