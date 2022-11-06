/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmicalculadora;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ElFrame extends JFrame implements ActionListener{
    JTextField txtNumero;
    JLabel lblInserte, lblResultado;
    JButton btnEnviar, btnSuma, btnResta, btnMult, btnDiv, btnPot, btnMod;
    
    interfaceServidor servidor;
    
    
    public ElFrame(interfaceServidor servidor){
        this.servidor = servidor;
        
        setLayout(new FlowLayout());
        
        lblInserte = new JLabel("Inserte el numero a enviar:", SwingConstants.CENTER);
        lblInserte.setPreferredSize(new Dimension(240,30));
        add(lblInserte);
        
        txtNumero = new JTextField();
        txtNumero.setBounds(100,100,100,50);
        txtNumero.setColumns(10);
        add(txtNumero);
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(this);
        btnEnviar.setBounds(100,100,100,100);
        add(btnEnviar);
        
        btnSuma = new JButton("Sumar");
        btnSuma.addActionListener(this);
        btnSuma.setBounds(100,100,100,50);
        btnSuma.setPreferredSize(new Dimension(160,30));
        add(btnSuma);
        
        btnResta = new JButton("Restar");
        btnResta.addActionListener(this);
        btnResta.setBounds(100,100,100,50);
        btnResta.setPreferredSize(new Dimension(160,30));
        add(btnResta);
        
        btnMult = new JButton("Multiplicar");
        btnMult.addActionListener(this);
        btnMult.setBounds(100,100,100,50);
        btnMult.setPreferredSize(new Dimension(160,30));
        add(btnMult);
        
        btnDiv = new JButton("Dividir");
        btnDiv.addActionListener(this);
        btnDiv.setBounds(100,100,100,50);
        btnDiv.setPreferredSize(new Dimension(160,30));
        add(btnDiv);
        
        btnPot = new JButton("Potencia");
        btnPot.addActionListener(this);
        btnPot.setBounds(100,100,100,50);
        btnPot.setPreferredSize(new Dimension(160,30));
        add(btnPot);
        
        btnMod = new JButton("Modulo");
        btnMod.addActionListener(this);
        btnMod.setBounds(100,100,100,50);
        btnMod.setPreferredSize(new Dimension(160,30));
        add(btnMod);
        
        lblResultado = new JLabel("Resultado:", SwingConstants.CENTER);
        lblResultado.setPreferredSize(new Dimension(240,30));
        add(lblResultado);
        
        setTitle("Cliente Calculadora");
        setSize(300,360);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(btnEnviar == e.getSource()){
            
            try {
                String txt = txtNumero.getText();
                
                if(txt.equals("")){
                    JOptionPane.showMessageDialog(null, "Por favor, escriba un numero para mandar al servidor");
                    return;
                }
                this.servidor.agregarNum(Integer.parseInt(txtNumero.getText()));
                
                JOptionPane.showMessageDialog(null, "Numero " + txt + " enviado al servidor!");
                txtNumero.setText("");
            } catch (RemoteException ex) {
                Logger.getLogger(ElFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(btnSuma == e.getSource()){
            
            try {
                if(this.servidor.check()){
                    int r = this.servidor.suma(this.servidor.getA(), this.servidor.getB());
                    String res = Integer.toString(r);
                    lblResultado.setText("Resultado (suma): " + this.servidor.getA() + " + " + this.servidor.getB() + " = " + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Falta enviar 1 o mas numeros al servidor");
            } catch (RemoteException ex) {
                Logger.getLogger(ElFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(btnResta == e.getSource()){
            
            try {
                if(this.servidor.check()){
                    int r = this.servidor.resta(this.servidor.getA(), this.servidor.getB());
                    String res = Integer.toString(r);
                    lblResultado.setText("Resultado (resta): " + this.servidor.getA() + " - " + this.servidor.getB() + " = "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Falta enviar 1 o mas numeros al servidor");
            } catch (RemoteException ex) {
                Logger.getLogger(ElFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(btnMult == e.getSource()){
            
            try {
                if(this.servidor.check()){
                    int r = this.servidor.mult(this.servidor.getA(), this.servidor.getB());
                    String res = Integer.toString(r);
                    lblResultado.setText("Resultado (multiplicacion): " + this.servidor.getA() + " * " + this.servidor.getB() + " = "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Falta enviar 1 o mas numeros al servidor");
            } catch (RemoteException ex) {
                Logger.getLogger(ElFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(btnDiv == e.getSource()){
            
            try {
                if(this.servidor.check()){
                    int r = this.servidor.div(this.servidor.getA(), this.servidor.getB());
                    String res = Integer.toString(r);
                    lblResultado.setText("Resultado (division): " + this.servidor.getA() + " / " + this.servidor.getB() + " = "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Falta enviar 1 o mas numeros al servidor");
            } catch (RemoteException ex) {
                Logger.getLogger(ElFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(btnPot == e.getSource()){
            
            try {
                if(this.servidor.check()){
                    int r = this.servidor.pot(this.servidor.getA(), this.servidor.getB());
                    String res = Integer.toString(r);
                    lblResultado.setText("Resultado (potencia): " + this.servidor.getA() + " ^ " + this.servidor.getB() + " = "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Falta enviar 1 o mas numeros al servidor");
            } catch (RemoteException ex) {
                Logger.getLogger(ElFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(btnMod == e.getSource()){
            
            try {
                if(this.servidor.check()){
                    int r = this.servidor.mod(this.servidor.getA(), this.servidor.getB());
                    String res = Integer.toString(r);
                    lblResultado.setText("Resultado (modulo): " + this.servidor.getA() + " % " + this.servidor.getB() + " = "  + res);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Falta enviar 1 o mas numeros al servidor");
            } catch (RemoteException ex) {
                Logger.getLogger(ElFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//actionPerformed
    
}
