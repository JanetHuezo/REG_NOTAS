package com.example.reg_notas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText user,pass;
    Button btnIniciar, btnRegistrar;
    DaoUsuario dao;
    public boolean estado = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.Usuario);
        pass=(EditText)findViewById(R.id.Contraseña);
        btnIniciar=(Button)findViewById(R.id.btnIniciar);

        dao=new DaoUsuario(this);

        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (validarLogin()) {
            Intent i = new Intent(this, MenuPrincipal.class);
            startActivity(i);
        }

    }
    private boolean validarLogin() {
        estado = false;
        if (user.getText().toString().trim().isEmpty()) {
           user.setError("Ingrese su usuario");
        } else if (pass.getText().toString().trim().isEmpty()) {
            pass.setError("Ingrese su password");
        } else {
            if (user.getText().toString().equals("Admin") && pass.getText().toString().equals("Admin")) {
                estado = true;
            } else {
                Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_SHORT).show();
            }
        }
        return estado;
    }

}