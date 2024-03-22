/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2labp2_michaelmartinez;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Michael Martínez
 */
public class hiloPrimerCarro implements Runnable{
    private JProgressBar barra;
    private int velocidad;
    private JProgressBar barra2;
    private int velocidad2;
    private String ganador;
    private JLabel label;
    

    public hiloPrimerCarro(JProgressBar barra, int velocidad, JProgressBar barra2, int velocidad2, String ganador, JLabel label) {
        this.barra = barra;
        this.velocidad = velocidad;
        this.barra2 = barra2;
        this.velocidad2 = velocidad2;
        this.ganador = ganador;
        this.label = label;
    }
    

    
    

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public JProgressBar getBarra2() {
        return barra2;
    }

    public void setBarra2(JProgressBar barra2) {
        this.barra2 = barra2;
    }

    public int getVelocidad2() {
        return velocidad2;
    }

    public void setVelocidad2(int velocidad2) {
        this.velocidad2 = velocidad2;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
    

    @Override
    public void run() {
        int seconds = 0;
        int minutes = 0;
        String crono = "";
        int velocidadF1=0;
        int velocidadF2=0;

        boolean bandera = true;
        while (bandera) {
            barra.setValue(velocidadF1);
            barra2.setValue(velocidadF2);

            if (velocidadF1 >= barra.getMaximum()) {
                bandera = false;
                setGanador("Carro 1");

            } else if (velocidadF2 >= barra2.getMaximum()) {
                bandera = false;
                setGanador("Carro 2");
            }
            velocidadF1 += velocidad;
            velocidadF2 += velocidad2;
            try {
                Thread.sleep(600);
            } catch (Exception e) {
            }

            if (seconds < 10) {
                crono = "00:0" + seconds;
                label.setText(crono);
                seconds++;
            } else if (seconds >= 10) {
                crono = "00:" + seconds;
                label.setText(crono);
                seconds++;
            } else if (seconds > 60) {
                minutes++;
                crono = "0" + minutes + ":00";
                label.setText(crono);
                seconds = 0;
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }

        JOptionPane.showMessageDialog(null, "El ganador fue el  " + ganador+" con un tiempo de : "+label.getText());

    }

}
