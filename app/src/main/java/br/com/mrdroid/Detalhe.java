package br.com.mrdroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class Detalhe extends AppCompatActivity {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE =10;
    private ImageView imgVi;
    private Button btnCamera;
    private Button btnEditar;
    private TextView txNome;

    private EditText nNome;
    private EditText nSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        txNome = findViewById(R.id.txnome);
        btnCamera = findViewById(R.id.btnCamera);
        btnEditar = findViewById(R.id.btnEditar);
        imgVi = findViewById(R.id.imgFunc);
        nNome = findViewById(R.id.nNome);
        nSal = findViewById(R.id.nSal);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamera();
            }
        });
        Bundle b = getIntent().getExtras();

        String name = b.getString("nome"," ");
        double sal = b.getDouble("salario",0);
        txNome.setText(name);
        nNome.setText(name);
        nSal.setText(String.valueOf(sal));

    }


    public void abrirCamera(){
        Intent inten = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String arquivo = Environment.getExternalStorageDirectory() + "/" + System.currentTimeMillis() + ".jpg";

        File file = new File(arquivo);

        Uri outputFileUri = Uri.fromFile(file);


        inten.putExtra("arquivo", arquivo);
        startActivityForResult(inten,CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);


        /*if(file.exists()){
            Bitmap foto = BitmapFactory.decodeFile(file.getAbsolutePath());
            imgVi.setImageBitmap(foto);
        }*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        System.gc();
        if(requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE){
            if(resultCode ==RESULT_OK){
                try{
                    //BitmapFactory.decodeFile(data.getExtras().getString("arquivo"));
                    Uri urlLocal = data.getData();

                    Bitmap foto = MediaStore.Images.Media.getBitmap(getContentResolver(),urlLocal);


                    imgVi.setImageBitmap(foto);
                   // dialog = new AlertDialog.Builder(MainActivit.this);
                   // dialog.setMessage("ASDF?:" +data.getExtras().getString("arquivo"));
                   // dialog.show();

                }catch (Exception e){
                    //dialog = new AlertDialog.Builder(MainActivit.this);
                   // dialog.setMessage("Ocorreu um erro no app ao tirar a foto !\n detalhes do erro : "+e.getMessage());
                   // dialog.show();
                }
            }
        }
    }
}
