/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iordansebastianverifica;

import java.io.Serializable;

/**
 *
 * @author iordan.sebastian
 */
public class Trasporto implements Serializable{
    private final String cTaxi; // codice taxi
    private final int km; // km
    private final byte nPersone; // numero di persone
    private final double pxkm; // prezzo per kilometro

    public Trasporto(String cTaxi, int km, byte nPersone, double pxkm) {
        this.cTaxi = cTaxi;
        this.km = km;
        this.nPersone = nPersone;
        this.pxkm = pxkm;
    }

    public String getcTaxi() {
        return cTaxi;
    }

    public int getKm() {
        return km;
    }

    public byte getnPersone() {
        return nPersone;
    }

    public double getPxkm() {
        return pxkm;
    }

    @Override
    public String toString() {
        return "Trasporto{" + "cTaxi=" + cTaxi + ", km=" + km + ", nPersone=" + nPersone + ", pxkm=" + pxkm + '}';
    }
}
