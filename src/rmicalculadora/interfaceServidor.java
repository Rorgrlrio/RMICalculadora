/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rmicalculadora;

import java.rmi.RemoteException;
import java.rmi.Remote;

public interface interfaceServidor extends Remote{
    public int suma(int a, int b) throws RemoteException;
    public int resta(int a, int b) throws RemoteException;
    public int mult(int a, int b) throws RemoteException;
    public int div(int a, int b) throws RemoteException;
    public int pot(int a, int b) throws RemoteException;
    public int mod(int a, int b) throws RemoteException;
    public void agregarNum(int n) throws RemoteException;
    public boolean check() throws RemoteException;
    public int getA() throws RemoteException;
    public int getB() throws RemoteException;
}
