package com.ecaresoft.cumulus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ecaresoft.cumulus.R;
import com.ecaresoft.cumulus.helpers.database.DataBaseHelper;

/**
 * Created by erodriguez on 11/10/2015.
 */
public class Signin extends ActionBarActivity implements View.OnClickListener {
    private ImageButton registrarse;
    private TextView txtError;
    private EditText txtName, txtCurp, txtUserName, password, passwordConfirm;
    private Button btnConfitm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signin);
        registrarse=(ImageButton)findViewById(R.id.enter);
        txtError=(TextView)findViewById(R.id.txtError);

        txtCurp=(EditText)findViewById(R.id.txtCurp);
        txtUserName=(EditText)findViewById(R.id.txtUserName);
        password =(EditText)findViewById(R.id.password);
        passwordConfirm=(EditText)findViewById(R.id.passwordConfirm);
        btnConfitm=(Button)findViewById(R.id.registrarse);
        btnConfitm.setOnClickListener(this);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /*
    * El evento del boton entrar, verifica si el usuario existe en la base de datos remota, si existe remotamente
    * y no local, lo guarda localmente para acceder cuando no se tenga internet
    * */
    @Override
    public void onClick(View view) {
        txtError.setText("");
        if (!txtUserName.getText().toString().trim().equals("") && !password.getText().toString().trim().equals("")) {
            DataBaseHelper.setDummyRegistry(getApplicationContext(), txtUserName.getText().toString(), password.getText().toString());
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        } else {
            txtError.setText("Debe llenar los campos de usuario y contraseña");
        }
    }
}
