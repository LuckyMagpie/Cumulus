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
import android.widget.Toast;

import com.ecaresoft.cumulus.helpers.DataBaseHelper;

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
            DataBaseHelper dataBaseHelper=new DataBaseHelper(getApplicationContext());
            if(dataBaseHelper.selectData(dataBaseHelper,user.getText().toString().trim(),password.getText().toString().trim())) {
                dataBaseHelper.insertData(dataBaseHelper, user.getText().toString().trim(), password.getText().toString().trim());
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                tvError.setText(R.string.mensaje_error);
                }
            }
        }
    }
