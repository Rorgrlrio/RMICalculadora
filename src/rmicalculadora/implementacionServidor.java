package rmicalculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implementacionServidor extends UnicastRemoteObject implements interfaceServidor{
    public int a, b;
    
    public implementacionServidor() throws RemoteException{
        this.a = 0;
        this.b = 0;
    }
    
    @Override
    public int suma(int a, int b) throws RemoteException{
        int r = a + b;
        return r;
    }
    
    @Override
    public int resta(int a, int b) throws RemoteException{
        int r = a - b;
        return r;
    }
    
    @Override
    public int mult(int a, int b) throws RemoteException{
        int r = a * b;
        return r;
    }
    
    @Override
    public int div(int a, int b) throws RemoteException{
        int r = a / b;
        return r;
    }
    
    @Override
    public int pot(int a, int b) throws RemoteException{
        int r = a;
        
        for(int i=1;i<b;i++){
            r = r*a;
        }
        
        return r;
    }
    
    @Override
    public int mod(int a, int b) throws RemoteException{
        int r = a % b;
        return r;
    }
    
    @Override
    public void agregarNum(int n) throws RemoteException{
        if(this.a != 0 && this.b != 0){ //Si ambos estan llenos y se agrega otro numero
            this.a = n;
            this.b = 0; //Que dicho numero remplace al primero, y se borre el segundo
            return;
        }
        
        if(this.a != 0){ //Si el primer numero ya esta lleno, que se llene el segundo
            this.b = n;
            return;
        }
        
        this.a = n; //Si no se cumple ninguno de los casos anteriores (se agrega un num por primera vez, que se llene el primero
    }
    
    @Override
    public boolean check() throws RemoteException{
        return !(this.a == 0 || this.b == 0); //Hacemos un if de una sola linea
    }
    
    @Override
    public int getA() throws RemoteException{
        return this.a;
    }
    
    @Override
        public int getB() throws RemoteException{
        return this.b;
    }
    
}
