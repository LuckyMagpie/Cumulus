package com.ecaresoft.cumulus;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;

/**
 * Created by dsolano on 9/10/15.
 */
public class Login extends ActionBarActivity implements View.OnClickListener {
    private Button enter;
    private EditText user;
    private EditText password;
    private TextView tvError;
    private TextView registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Si hay una session activa no se inicia el login
        if(DataBaseHelper.getSession(getApplicationContext()) > 0){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.login);
            enter=(Button)findViewById(R.id.enter);
            user=(EditText)findViewById(R.id.user);
            registro=(TextView)findViewById(R.id.registrarse);
            tvError=(TextView)findViewById(R.id.tvError);
            password=(EditText) findViewById(R.id.password);
            enter.setOnClickListener(this);
            registro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tvError.setText("");
                    if (!user.getText().toString().trim().equals("") && !password.getText().toString().trim().equals("")) {
                        DataBaseHelper.setDummyRegistry(getApplicationContext(), user.getText().toString(), password.getText().toString());
                        tvError.setText("Se ha creado el registro");
                    }
                }
            });
        }
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
        tvError.setText("");
        if (user.getText().toString().trim().equals("") || password.getText().toString().trim().equals("")) {
            tvError.setText(R.string.mensaje_error);
        } else if (DataBaseHelper.getLogin(getApplicationContext(), user.getText().toString(), password.getText().toString()) > 0) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            tvError.setText("Datos incorrectos. Favor de verificar haberse dado de alta en el dispositivo asi como su usuario y contraseña.");
        }
    }
}
