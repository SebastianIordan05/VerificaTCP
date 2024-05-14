/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iordansebastianverifica;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author iordan.sebastian
 */
public class Server {

    private static final int PORT = 8888;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (final ServerSocket ss = new ServerSocket(PORT);) {
            System.out.println("Listening on port " + PORT + "...");
            while (true) {
                final Socket cs = ss.accept();
                System.out.println("Connection started with " + cs);
                final ObjectInputStream in = new ObjectInputStream(cs.getInputStream());
                final DataOutputStream out = new DataOutputStream(cs.getOutputStream());
                final ObjectOutputStream oos = new ObjectOutputStream(cs.getOutputStream());

                try {
                    Trasporto trs;
                    double costo;
                    double costoTot = 0;
                    double costoMax = 0;
                    double costoxPersona;
                    Trasporto tMax = null;
                    
                    while ((trs = (Trasporto) in.readObject()).getKm() != 0) {
                        System.out.println(trs.toString());
                        
                        costo = trs.getKm() * trs.getPxkm();
                        costoxPersona = costo / (int) trs.getnPersone();
                        costoTot += costo;
                        if (costo > costoMax) {
                            costoMax = costo;
                            tMax = trs;
                        }
                        
                        out.writeDouble(costo);
                        System.out.println("costo: " + costo);
                        out.writeDouble(costoxPersona);
                        System.out.println("Costo x persona: " + costoxPersona);
                    }
                    out.writeDouble(costoTot);
                    System.out.println("Costo tot: " + costoTot);
                    
                    out.writeDouble(costoMax);
                    System.out.println("Costo max: " + costoMax);
                    
                    oos.writeObject(tMax);
                    
                    ss.close();
                    cs.close();
                } catch (IOException | ClassNotFoundException ex) {
                }
            }
        } catch (IOException ex) {
        }
    }

}
