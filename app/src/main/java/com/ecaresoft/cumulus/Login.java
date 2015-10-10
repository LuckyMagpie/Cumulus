package com.ecaresoft.cumulus;


import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ecaresoft.cumulus.helpers.DataBaseHelper;
import com.ecaresoft.cumulus.request.JSONRequest;

/**
 * Created by dsolano on 9/10/15.
 */
public class Login extends ActionBarActivity implements View.OnClickListener {
    private Button enter;
    private EditText user;
    private EditText password;
    private TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        enter=(Button)findViewById(R.id.enter);
        user=(EditText)findViewById(R.id.user);
        tvError=(TextView)findViewById(R.id.tvError);
        password=(EditText) findViewById(R.id.password);
        enter.setOnClickListener(this);

        /*
        DESCOMENTAR LA PRIMERA VEZ PARA AGREGAR USUARIO
        DataBaseHelper dataBaseHelper=new DataBaseHelper(getApplicationContext());
        dataBaseHelper.insert(dataBaseHelper);*/
      /*  if(isConnected()){
            System.out.println("CONNECTED");
        }
        else{
            System.out.println("You are not connected");
        }
        new HttpAsyncTask().execute("http://192.168.11.190:8000/pacientes/1/");*/
        JSONRequest jsonRequest= new JSONRequest("http://192.168.11.190:8000/pacientes/1/");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    * El evento del boton entrar, verifica si el usuario existe en la base de datos remota, si existe remotamente
    * y no local, lo guarda localmente para acceder cuando no se tenga internet
    * */
    @Override
    public void onClick(View view) {
        if(user.getText().toString().trim().equals("") || password.getText().toString().trim().equals("") ){
            tvError.setText(R.string.mensaje_error);
        }else{
            //DataBaseHelper dataBaseHelper=new DataBaseHelper(getApplicationContext());
            //if(dataBaseHelper.selectData(dataBaseHelper,user.getText().toString().trim(),password.getText().toString().trim())) {
                //dataBaseHelper.insertData(dataBaseHelper, user.getText().toString().trim(), password.getText().toString().trim());
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
           // }else{
                //tvError.setText(R.string.mensaje_error);
                //}
            }
        }
/*
    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            inputStream = httpResponse.getEntity().getContent();
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
        inputStream.close();
        return result;
    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        }
    }*/
}
