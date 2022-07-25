package com.xtremecorp.xtremeapp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {



    //Definir las views de la pantalla
    EditText UserView, OpView, PassView;
    CheckBox CheckView;
    Button LoginBtn;
    // Definir atributos FireBase
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    // Atributos para el ProgressDialog
    private ProgressDialog progressDialog;
    Dialog dialog;
    AlertDialog alertDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar
        //Se agigna titulo y boton de regreso
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null; //Afirma que el titulo no es null
        //Asigna un titulo
        actionBar.setTitle("Iniciar Sesión");
        actionBar.setDisplayShowHomeEnabled(true);


        //Conexión de vistas con la clase R
        UserView = findViewById(R.id.userText);
        OpView = findViewById(R.id.userOp);
        PassView= findViewById(R.id.user_password);
        CheckView = findViewById(R.id.checkbox_login);
        LoginBtn = findViewById(R.id.btn_loginMain);
        //Se crea un objeto del servicio de Auth
        firebaseAuth = FirebaseAuth.getInstance();
        //Objeto de dialogo
        progressDialog = new ProgressDialog(MainActivity.this);
        dialog = new Dialog(MainActivity.this);

        LoginBtn.setOnClickListener(view -> {
            String usuario = UserView.getText().toString();
            String operator = OpView.getText().toString();
            String password = PassView.getText().toString();

            if( !Patterns.EMAIL_ADDRESS.matcher(usuario).matches()){
                UserView.setError("Ingrese Usuario");
                UserView.setFocusable(true);
            }
            else if ( password.length() < 6 ){
                PassView.setError("Contraseña debe tener 6 caracteres");
                PassView.setFocusable(true);
            }
            else if( operator.isEmpty() ){
                OpView.setError("ingrese clave del operador");
                OpView.setFocusable(true);
            }else {
                loginUser(usuario, password);
            }
        });

    }

    //Método para logear usuario
    private void loginUser(String usuario, String password){

        dialogInicio();
        //Metodo de autenticacion firebase
        firebaseAuth.signInWithEmailAndPassword(usuario, password)
                .addOnCompleteListener(this, task -> {
                    //Validar si se inicia correctamente
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        firebaseUser = firebaseAuth.getCurrentUser();
                        //
                        startActivity(new Intent(MainActivity.this, Inicio.class));
                        assert firebaseUser != null;
                        Toast.makeText(MainActivity.this, "Bienvenido" + " " +firebaseUser.getEmail(), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        progressDialog.dismiss();
                        dialogNoInicio();
                        //Metodo para animacion de no inicio
                        Toast.makeText(MainActivity.this, "Something has occurred, try again", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(e -> {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    /**Metodo para dialogo no inicio **/
    private void dialogNoInicio(){
        dialog.setContentView(R.layout.no_sesion);
        Button retry = dialog.findViewById(R.id.retryBtn);

        retry.setOnClickListener(view -> dialog.dismiss());
        dialog.setCancelable(false);
        dialog.show();
    }
    /**Metodo para dialogo inicio sesion**/
    private void dialogInicio(){
        //AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.iniciando_sesion, null));
        alertDialog = builder.create();
        alertDialog.show();
    }
}