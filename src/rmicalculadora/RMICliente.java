/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmicalculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class RMICliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            
            Registry rmii = LocateRegistry.getRegistry("Localhost", 1005);
            
            interfaceServidor servidor = (interfaceServidor) rmii.lookup("Calculadora");
            //new Thread(new implementacionChatCliente(nom, servidor)).start();
            
            ElFrame frame = new ElFrame(servidor);
            frame.setVisible(true);
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
    }
    
}
