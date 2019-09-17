package br.com.waldson.aula11;

import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(6);
        arvore.insert(1);
        arvore.insert(7);
        arvore.insert(2);
        arvore.insert(5);
        arvore.insert(0);

        arvore.remove(2);
        arvore.remove(0);
        arvore.remove(5);

        JFrame frame = new JFrame("Visualizador de ABB");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        ArvoreBinariaBuscaView view = new ArvoreBinariaBuscaView(arvore);
        frame.add(view);

        frame.setVisible(true);


    }
}
