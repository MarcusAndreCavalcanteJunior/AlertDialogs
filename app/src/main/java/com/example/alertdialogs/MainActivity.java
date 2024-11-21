package com.example.alertdialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder dialog; // criamos a classe dialog e o metodo builder
    AlertDialog.Builder dialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnAbrir = findViewById(R.id.btn_abrir);
        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(MainActivity.this);/*//Lembrar do context
                no casso o MainActivity.this*/
                dialog.setTitle("Teste de Alerta Dialog");//METODO PARA SETAR O TITULO
                dialog.setMessage("Este é exemplo para o curso do IFSP");//METODO SETAR A PARA MENSAGEM.
                dialog.setIcon(android.R.drawable.ic_delete);
                dialog.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Acontece algo ao tocar no Positivo
                        Toast.makeText(MainActivity.this, "OK",
                                Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Cancelar",
                                Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNeutralButton("Neutro", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Neutro",
                                Toast.LENGTH_LONG).show();
                    }
                });

                dialog.show();//O metodo show vai exibir o dialog(o dialogo) na tela
            }
        });

        Button btnAbrir2 = findViewById(R.id.btn_abrir2);
        btnAbrir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nova visualozação da dialog.xml
                dialog2 = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog, null);
                dialog2.setView(view);
                EditText edtNome = view.findViewById(R.id.tvw_Name);
                EditText edtSenha = view.findViewById(R.id.twv_password);
                Button btnOK = view.findViewById(R.id.btn_login);
                Button btnCancelar = view.findViewById(R.id.btn_cancel);
                AlertDialog alertDialog = dialog2.show();
                btnCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String strNome = edtNome.getText().toString();
                        String strSenha = edtSenha.getText().toString();
                        Toast.makeText(MainActivity.this, strNome +" " + strSenha,
                                Toast.LENGTH_LONG).show();
                        alertDialog.dismiss();// Nunca esqueça do dismss com 2 layout xml
                    }
                });
                /* Elementos padrões da API exemplos
                dialog2.setTitle("Login");
                dialog2.setIcon(android.R.drawable.ic_dialog_email);
                dialog2.show();*/
            }
        });
    }
}