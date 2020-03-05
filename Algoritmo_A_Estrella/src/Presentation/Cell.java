package Presentation;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private int fila,columna;
    public Cell(){

        this.setFocusable(false);
    }

    public void setColorNormal(){
        this.setBackground(Color.CYAN);
    }
    public void setColorInicio(){
        this.setBackground(Color.MAGENTA);
    }
    public void setColorCamino(){
        setBackground(Color.ORANGE);
    }

    public void setColorObstaculo(){
        this.setBackground(Color.black);
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColorFinal() {
        this.setBackground(Color.BLUE);
    }
}
