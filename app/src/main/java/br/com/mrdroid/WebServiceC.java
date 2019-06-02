package br.com.mrdroid;

import android.widget.Toast;

import java.io.IOException;

import br.com.mrdroid.br.com.mrdroid.model.Config;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WebServiceC {

    private String url;

    private String res = "";

    public String sendRequest() {
        OkHttpClient client = new OkHttpClient();
        final Request req = new Request.Builder().url(url).build();

        client.newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    res = response.body().string();

                }
            }
        });

        return res;
    }


    public void convertTojson(){

    }

    public WebServiceC(Config confi,String operation,String jsons){
        url  = confi.getIp() + ":";
        url+=  String.valueOf(confi.getPorta()) + "/"+operation;

    }

}
