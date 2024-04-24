package com.example.renato_jokenpo.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.renato_jokenpo.R;
import com.example.renato_jokenpo.model.Jogada;
import com.example.renato_jokenpo.viewModel.Auxiliar;

public class MainActivity extends AppCompatActivity {

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

        ImageButton imageButtonPedra = findViewById(R.id.buttonPedra); //0
        ImageButton imageButtonPapel = findViewById(R.id.buttonPapel); //1
        ImageButton imageButtonTesoura = findViewById(R.id.buttonTesoura); //2

        imageButtonPedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                Jogada jogada = Auxiliar.criaUmaJogada(0);
                int ponto = jogada.getPonto();
                int sorteio = jogada.getSorteio();
                boolean impate = jogada.isImpate();
                intent.putExtra("ponto", ponto);
                intent.putExtra("sorteio", sorteio);
                intent.putExtra("impate", impate);
                startActivity(intent);
            }
        });

        imageButtonPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                Jogada jogada = Auxiliar.criaUmaJogada(1);
                int ponto = jogada.getPonto();
                int sorteio = jogada.getSorteio();
                boolean impate = jogada.isImpate();
                intent.putExtra("ponto", ponto);
                intent.putExtra("sorteio", sorteio);
                intent.putExtra("impate", impate);
                startActivity(intent);
            }
        });

        imageButtonTesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                Jogada jogada = Auxiliar.criaUmaJogada(2);
                int ponto = jogada.getPonto();
                int sorteio = jogada.getSorteio();
                boolean impate = jogada.isImpate();
                intent.putExtra("ponto", ponto);
                intent.putExtra("sorteio", sorteio);
                intent.putExtra("impate", impate);
                startActivity(intent);
            }
        });

        setupToolbar();
    }//onCreate

    private void setupToolbar() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return Auxiliar.onOptionsItemSelected(this, item);
    }

}