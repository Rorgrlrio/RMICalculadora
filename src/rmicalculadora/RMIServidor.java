/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmicalculadora;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServidor {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Registry rmi = LocateRegistry.createRegistry(1005); //Abrimos puerto
            
            rmi.rebind("Calculadora", (Remote) new implementacionServidor()); //Creamos objeto remoto
            System.out.println("Servidor Calculadora Activo");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
