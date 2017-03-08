package br.com.fiap.segundotina.exemplofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void criar(View view) {
        FileOutputStream fos = null;
        try {

            // Criando o arquivo
            fos = openFileOutput("teste.txt",MODE_PRIVATE);
            String texto = "Churros é bom!";
            fos.write(texto.getBytes()); // Escrevendo no arquivo txt
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ler(View view) {

        try{
            FileInputStream fis = openFileInput("teste.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String texto = br.readLine();
            fis.close();

            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        }catch(Exception e){

        }
    }
}
