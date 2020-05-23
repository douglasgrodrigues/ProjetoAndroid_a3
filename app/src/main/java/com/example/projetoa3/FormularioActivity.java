package com.example.projetoa3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormularioActivity extends AppCompatActivity {
    private EditText etMarca, etPreco;
    private Button btnSalvar;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etMarca  = findViewById( R.id.etMarca);
        etPreco  = findViewById( R.id.etPreco );
        btnSalvar = findViewById( R.id.btnSarvar );

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar(){
        String marca = etMarca.getText().toString();
        String preco = etPreco.getText().toString();

        if( !marca.isEmpty()  && !preco.isEmpty() ){
            preco = preco.replace(",", ".");
            double valor = Double.valueOf( preco );
            Veiculo produto = new Veiculo();
            produto.marca = marca;
            produto.preco = valor;

            database = FirebaseDatabase.getInstance();
            reference = database.getReference();
            reference.child("produtos").push().setValue( produto );
            finish();
        }
    }

}
