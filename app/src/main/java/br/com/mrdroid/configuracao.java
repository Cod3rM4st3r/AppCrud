package br.com.mrdroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.mrdroid.br.com.mrdroid.model.Config;


public class configuracao extends AppCompatActivity {

    private EditText ip;
    private EditText porta;
    private Button save;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);

        ip = findViewById(R.id.ip);
        porta = findViewById(R.id.porta);
        save = findViewById(R.id.imageButton2);


        carregarPreferencias();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Config conf;
                    conf = new Config(porta.getText().toString(),ip.getText().toString());

                    SharedPreferences sh = getSharedPreferences("config", Context.MODE_PRIVATE);
                    SharedPreferences.Editor  edit = sh.edit();

                    edit.putString("ip",conf.getIp());
                    edit.putInt("porta",conf.getPorta());

                    edit.apply();

                    Toast.makeText(getApplicationContext(),"Salvo com sucesso!",Toast.LENGTH_SHORT).show();
                    finish();


                }catch (Exception e ){
                    AlertDialog.Builder builder =  new AlertDialog.Builder(configuracao.this);

                    builder.setTitle("Atenção");
                    builder.setMessage("Ocorreu um erro\nErro : " + e.getMessage());

                }

            }
        });


    }


    private void carregarPreferencias(){
        SharedPreferences sh = getSharedPreferences("config", Context.MODE_PRIVATE);
        Config conf = new Config();
        conf.setIp(sh.getString("ip",""));
        conf.setPorta(sh.getInt("porta",0));


        ip.setText(conf.getIp());
        porta.setText(String.valueOf(conf.getPorta()));
    }
}
