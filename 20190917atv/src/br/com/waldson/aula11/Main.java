package br.com.waldson.aula11;

import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.insert(9);
        arvore.insert(1);
        arvore.insert(10);
        arvore.insert(6);
        arvore.insert(2);
        arvore.insert(5);
        arvore.insert(3);
        arvore.insert(4);
        arvore.insert(7);
        arvore.insert(0);

        arvore.remove(9);
        arvore.remove(7);

        JFrame frame = new JFrame("Visualizador de ABB");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400,450);

        ArvoreBinariaBuscaView view = new ArvoreBinariaBuscaView(arvore);
        frame.add(view);

        frame.setVisible(true);


    }
}
