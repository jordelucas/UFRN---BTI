package br.com.waldson.aula12;

import java.util.Observable;
import java.util.Observer;

public class FIlaObserver implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        ((FilaBanco)o).heapifyDown(((FilaBanco)o).getSize() - 1);
    }
}
