package com.example.renato_jokenpo.model;

import android.content.Context;

import com.example.renato_jokenpo.R;

import java.util.ArrayList;
import java.util.List;

public class Jogo {
    private int pontosUsuario=0;
    private int pontosAndroid=0;
    private List<Jogada> jogoList;

    public Jogo() {
        this.jogoList = new ArrayList<>();
    }

    public int getPontosUsuario() {
        return pontosUsuario;
    }

    public int getPontosAndroid() {
        return pontosAndroid;
    }

    public List<Jogada> getJogoList() {
        return jogoList;
    }

    public void adicionarJogo(Jogada jogada) {//foi definido que cada rodada vale 1 pontos
        jogoList.add(jogada);
        if (!jogada.isImpate()) {
            if (jogada.getPonto() == 1) {
                pontosUsuario ++;
            } else pontosAndroid ++;
        }

    }

    public void zerarJogo() {
        pontosAndroid = 0;
        pontosUsuario = 0;
        jogoList.removeAll(jogoList);
    }

    public String getPrimeiroColocado(Context context) {
        if (pontosUsuario <= pontosAndroid)
            return context.getString(R.string.andoid) + pontosAndroid;
        else return context.getString(R.string.usuario) + pontosUsuario;
    }

    public String getSegundoColocado(Context context) {
        if (pontosUsuario > pontosAndroid)
            return context.getString(R.string.andoid) + pontosAndroid;
        else return context.getString(R.string.usuario) + pontosUsuario;
    }

}
