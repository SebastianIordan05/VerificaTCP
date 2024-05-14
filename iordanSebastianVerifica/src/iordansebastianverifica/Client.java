/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iordansebastianverifica;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author iordan.sebastian
 */
public class Client {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (final Socket cs = new Socket("localhost", 8888); ) {
            final ObjectOutputStream out = new ObjectOutputStream(cs.getOutputStream());
            final DataInputStream in = new DataInputStream(cs.getInputStream());
            final ObjectInputStream ois = new ObjectInputStream(cs.getInputStream());
            
            out.writeObject(new Trasporto("K5SSD7Z", 27, (byte) 4, 1.5));
            System.out.println("Costo: " + in.readDouble());
            System.out.println("Costo a persona: " + in.readDouble());
            out.writeObject(new Trasporto("HDVH6GD", 12, (byte) 4, 1.5));
            System.out.println("Costo: " + in.readDouble());
            System.out.println("Costo a persona: " + in.readDouble());
            out.writeObject(new Trasporto("BSG68HS", 100, (byte) 4, 1.5));
            System.out.println("Costo: " + in.readDouble());
            System.out.println("Costo a persona: " + in.readDouble());
            out.writeObject(new Trasporto("MS09GS5", 3, (byte) 4, 1.5));
            System.out.println("Costo: " + in.readDouble());
            System.out.println("Costo a persona: " + in.readDouble());
            
            out.writeObject(new Trasporto("endOfProgram", 0, (byte) 0, 0)); // se ricevuto dal server termina il processo
            
            System.out.println("\nCosto totale di tutti i trasporti: " + in.readDouble());
            System.out.println("Trasporto col costo maggiore: " + in.readDouble());
            
            Trasporto trs = (Trasporto) ois.readObject();
            System.out.println(" - Codice taxi: " + trs.getcTaxi() + ", numero di persone: " + trs.getnPersone() +
                    ", KM: " + trs.getKm() + ", prezzo x km: " + trs.getPxkm());
                        
            
        } catch (IOException | ClassNotFoundException ex) {
        }
    }
}
