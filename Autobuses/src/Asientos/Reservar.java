/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asientos;

import java.awt.*;
import java.io.*;
import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author fernando
 */
public class Reservar extends JPanel
  implements Serializable, ChangeListener {

    private ArrayList<JCheckBox> asientos;
    private int nAsientos;
    private String distribucion;
    private JPanel lugares;
    private final int HILERAS = 4;

    private Font f;
    private int ocupados;
    private int numVehiculo;

    public Reservar() {
        this.distribucion = "HORIZONAL";
        this.nAsientos = 12;
        this.numVehiculo = Integer.MAX_VALUE;

        this.asientos = new ArrayList<>();

        this.lugares = new JPanel();
        this.ocupados = 0;
        this.lugares.setBackground(Color.WHITE);
        this.f = new Font("Dialog", 0, 18);

        add(this.lugares);
    }

    private void disVertical() {
        int e = 2;
        int filas = this.nAsientos / 4;
        this.lugares.setLayout(new GridLayout(filas, 0));

        for (int i = 1; i <= this.nAsientos; i++) {
            JCheckBox aux = new JCheckBox();
            aux.setText("" + i);
            aux.setBackground(Color.WHITE);
            aux.setFont(this.f);
            aux.setText("Disponible");
            aux.setBorderPaintedFlat(true);
            aux.addChangeListener((javax.swing.event.ChangeListener) this);
            this.asientos.add(aux);
            this.lugares.add(aux);
            if (i == e) {

                JLabel pasillo = new JLabel("Pasillo");
                this.lugares.add(pasillo);
                e += 4;
            }
        }
    }

    private void disHorizontal() {
        int columnas = this.nAsientos / 4;
        this.lugares.setLayout(new GridLayout(0, columnas));

        for (int i = 1; i <= 4; i++) {
            for (int j = i; j <= this.nAsientos - 4 - i; j += 4) {

                JCheckBox aux = new JCheckBox();
                aux.setBackground(Color.WHITE);
                aux.setBorderPaintedFlat(true);
                aux.setText("Disponible");
                aux.setFont(this.f);
                aux.setText("" + j);
                aux.addChangeListener((javax.swing.event.ChangeListener) this);
                this.asientos.add(aux);
                this.lugares.add(aux);
            }
            if (i == 2) {
                for (int e = 1; e <= this.nAsientos / 4; e++) {
                    JLabel pasillo = new JLabel("pasillo");
                    this.lugares.add(pasillo);
                }
            }
        }
    }

    public void setNumAsientos(int n) {
        this.nAsientos = n;
        this.asientos.clear();
        if (this.lugares.getComponentCount() > 0) {
            this.lugares.removeAll();
        }
        if (this.distribucion.equals("VERTICAL")) {
            disVertical();
        }
        if (this.distribucion.equals("HORIZONTAL")) {
            disHorizontal();
        }
        this.lugares.repaint();
        repaint();
    }

    public int getNumAsientos() {
        return this.nAsientos;
    }

    public boolean setCancelar(int nAsiento) {
        JCheckBox asiento = null;
        boolean esta = false;
        for (int na = 0; na < this.asientos.size() && !esta; na++) {
            esta = ((JCheckBox) this.asientos.get(na)).getText().equals("" + nAsiento);
            if (esta) {
                asiento = this.asientos.get(na);
                System.out.println("Num. " + na + " asie  " + ((JCheckBox) this.asientos.get(na)).getText() + " habil " + ((JCheckBox) this.asientos.get(nAsiento - 1)).isEnabled() + " selecc " + ((JCheckBox) this.asientos.get(nAsiento - 1)).isSelected());
                if (!asiento.isEnabled()) {
                    asiento.setEnabled(true);
                    asiento.setSelected(false);
                }
                return esta;
            }
        }
        return esta;
    }

    public void setReservar() {
        int ocu = 0;
        for (JCheckBox asiento : this.asientos) {
            if (asiento.isSelected() && asiento.isEnabled()) {
                asiento.setEnabled(false);
            }
            if (!asiento.isEnabled()) {
                ocu++;
            }
        }
        this.ocupados = ocu;
    }

    public void setAsignar(ArrayList<Integer> reservados) {
        if (reservados.size() > 0 && reservados.size() <= this.nAsientos && !this.asientos.isEmpty()) {
            for (JCheckBox asiento : this.asientos) {
                if (reservados.contains(Integer.valueOf(Integer.parseInt(asiento.getText())))) {
                    asiento.setEnabled(false);
                }
            }
            this.lugares.repaint();
            repaint();
        }
    }

    public void setDistribucion(String d) {
        this.asientos.clear();
        if (this.lugares.getComponentCount() > 0) {
            this.lugares.removeAll();
        }
        if (d.equalsIgnoreCase("VERTICAL") || d.toUpperCase().contains("V")) {
            this.distribucion = "VERTICAL";
            disVertical();

        } else if (d.equalsIgnoreCase("HORIZONTAL") || d.toUpperCase().contains("H")) {

            this.distribucion = "HORIZONTAL";
            disHorizontal();
        }
        this.lugares.repaint();
    }

    public ArrayList<Integer> getSeleccionados() {
        ArrayList<Integer> numAsiSelec = new ArrayList<>();
        for (JCheckBox asiento : this.asientos) {
            if (asiento.isSelected() && asiento.isEnabled()) {
                numAsiSelec.add(Integer.valueOf(Integer.parseInt(asiento.getText())));
            }
        }
        return numAsiSelec;
    }

    public int getOcupados() {
        return this.ocupados;
    }

    public ArrayList<Integer> getReservados() {
        ArrayList<Integer> numAsiReser = new ArrayList<>();
        for (JCheckBox asiento : this.asientos) {
            if (!asiento.isEnabled()) {
                numAsiReser.add(Integer.valueOf(Integer.parseInt(asiento.getText())));
            }
        }
        return numAsiReser;
    }

    public int getDisponibles() {
        return this.nAsientos - this.ocupados;
    }

    public void stateChanged(ChangeEvent ce) {
        JCheckBox asi = (JCheckBox) ce.getSource();
        if (((JCheckBox) ce.getSource()).isSelected()) {
            if (this.distribucion.equals("HORIZONTAL")) {
                asi.setText("Ocupado");
            } else {
                asi.setText("Ocupado");
            }
        } else if (this.distribucion.equals("HORIZONTAL")) {
            asi.setText("Disponible");
        } else {
            asi.setText("Disponible");
        }
    }

    @Override
    public void changed(ObservableValue ov, Object t, Object t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
