package com.app.minhasanotaes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencia preferencia;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editText2);

        preferencia = new AnotacaoPreferencia(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar se foi digitado algo
                String textoRecuperado = editAnotacao.getText().toString();
                if(textoRecuperado.equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha a anotação!", Toast.LENGTH_LONG).show();
                }else{
                    preferencia.salvarAnotacao(textoRecuperado);
                    Toast.makeText(getApplicationContext(), "Anotação salva com sucesso!", Toast.LENGTH_LONG).show();                }
            }
        });

        //Recuperar anotação
        String anotacao = preferencia.retornarAnotacao();
        if ( !anotacao.equals("") ) {
            editAnotacao.setText(anotacao);
        }
    }

}
