package com.example.renato_jokenpo.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.example.renato_jokenpo.R;
import com.example.renato_jokenpo.model.Jogada;
import com.example.renato_jokenpo.model.Jogo;
import com.example.renato_jokenpo.view.MainActivity;
import com.example.renato_jokenpo.view.PlacarActivity;

public class Auxiliar {
    public static Jogo jogo = new Jogo();

    public static Jogada criaUmaJogada(int opcao) {
        Jogada jogada = new Jogada();
        jogada.setOpcao(opcao);
        jogo.adicionarJogo(jogada);
        return jogada;
    }

    public static void abrirMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void abrirPlacarActivity(Context context) {
        Intent intent = new Intent(context, PlacarActivity.class);
        context.startActivity(intent);
    }

    public static void fecharApp(Activity context) {
        context.finishAffinity();
    }

    public static void zerarJogo(Context context) {
        jogo.zerarJogo();
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static boolean onOptionsItemSelected(Activity context, MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_novo) {
            abrirMainActivity(context);
            return true;
        } else if (id == R.id.menu_placar) {
            abrirPlacarActivity(context);
            return true;
        } else if (id == R.id.menu_zerar) {
            zerarJogo(context);
            return true;
        } else if (id == R.id.menu_encerrar) {
            fecharApp(context);
            return true;
        }
        return false;
    }


}
