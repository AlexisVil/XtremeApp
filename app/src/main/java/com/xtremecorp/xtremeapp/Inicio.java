package com.xtremecorp.xtremeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Inicio extends AppCompatActivity {

    /**Fragmentos**/
    TaeFragment taeFragment = new TaeFragment();
    ServiceFragment serviceFragment = new ServiceFragment();
    UserFragment userFragment = new UserFragment();

    Button SignOutView;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //ActionBar
        //Se agigna titulo y boton de regreso
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null; //Afirma que el titulo no es null
        //Asigna un titulo
        actionBar.setTitle("Xtreme Multipagos");
        actionBar.setDisplayShowHomeEnabled(true);


        SignOutView = findViewById(R.id.btn_signout);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(taeFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar Producto");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });



        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        verificarInicio();
        super.onStart();
    }

    public void verificarInicio(){
        if(firebaseUser != null){
            Toast.makeText(Inicio.this, "Sesion iniciada", Toast.LENGTH_SHORT).show();
        }
        else {
            startActivity(new Intent(Inicio.this, MainActivity.class));
            finish();
        }
    }


    /**Navegacion en la barra bottom**/
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.taeFragment:
                    loadFragment(taeFragment);
                    return true;
                case R.id.servicesFragment:
                    loadFragment(serviceFragment);
                    return true;
                case R.id.userFragment:
                    loadFragment(userFragment);
                    return true;
            }
            return false;
        }
    };

    /**Método para cargar cada fragmento-Transacciones**/
    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.inicio_frame, fragment);
        transaction.commit();
    }
}