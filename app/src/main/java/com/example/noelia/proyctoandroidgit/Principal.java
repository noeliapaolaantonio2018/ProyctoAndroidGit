package com.example.noelia.proyctoandroidgit;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.noelia.proyctoandroidgit.aplication.BaseApplication;

public class Principal extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText telefono;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity);
        nombre= (EditText)findViewById(R.id.etnombre);
        apellido=(EditText)findViewById(R.id.etapellido);
        telefono=(EditText)findViewById(R.id.ettelefono);
        guardar=(Button)findViewById(R.id.btnguardar);
        guardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ((BaseApplication)getApplication()).insertarCliente(nombre.getText().toString(),
                        apellido.getText().toString(),
                        telefono.getText().toString());
                Intent in=new Intent (Principal.this,ListActivity.class);
                startActivity(in);
            }
        });
    }


}
