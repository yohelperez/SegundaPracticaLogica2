package co.edu.udea.logica.model;

import java.awt.Color;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TOSHIBA
 */
public class Matriz extends JTable{
    private JTable matriz;
    private int n;

    public Matriz(int n, JTable matriz) {
        matriz.setDefaultRenderer(Object.class, new Render()); // renderiza la tabla  con la clase creada que permite agregar textfield
        
        this.n=n;
        this.matriz = matriz;
        DefaultTableModel model= (DefaultTableModel)matriz.getModel();
        model.setRowCount(n);       //numero de filas
        model.setColumnCount(n);    //numero de columnas
        matriz.setRowHeight(22);    //cambia la altura de las filas
        
    }
    
 

    public JTable getMatriz() {
        return matriz;
    }

    public void setMatriz(JTable matriz) {
        this.matriz = matriz;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    /*public int getValue(int i, int j){
        return this.matriz[i][j];
    }*/
    
    public void limpiar(){
        JTextField txt;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                txt=(JTextField)matriz.getValueAt(i, j);
                txt.setBackground(Color.white);
                matriz.setValueAt(txt, i, j);
                
            }
        }
    }
    
    public void Llenar(){
        Random numeroAleatorio= new Random();
        JTextField txt;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                txt=new JTextField(Integer.toString(numeroAleatorio.nextInt(20)));
                this.matriz.setValueAt(txt, i, j);              //numeroAleatorio.nextInt(1000);
                System.out.println(i + "," + j+ ":"+ matriz.getValueAt(i, j));
            }
        }
        limpiar();
    }
    public int sumarDatos(){
        int suma=0;
        JTextField txt;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                txt=(JTextField)matriz.getValueAt(i, j);
                suma+=Integer.parseInt(txt.getText());
            }
        }
        return suma;
    }
    
    public void pintarMayor(){
        JTextField txt;
        int mayor=0;
        int datoTxt;
        for(int i=0;i<n; i++){
            for(int j=0; j<n; j++){
                txt=(JTextField)matriz.getValueAt(i, j);
                datoTxt=Integer.parseInt(txt.getText());
                if(datoTxt>mayor){
                    mayor=datoTxt;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                txt=(JTextField)matriz.getValueAt(i, j);
                datoTxt=Integer.parseInt(txt.getText());
                if(datoTxt==mayor){
                    txt.setBackground(Color.red);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }
        
    }
    
    public void pintarMenor(){
        JTextField txt;
        int menor=1000;
        int datoTxt;
        for(int i=0;i<n; i++){
            for(int j=0; j<n; j++){
                txt=(JTextField)matriz.getValueAt(i, j);
                datoTxt=Integer.parseInt(txt.getText());
                if(datoTxt<menor){
                    menor=datoTxt;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                txt=(JTextField)matriz.getValueAt(i, j);
                datoTxt=Integer.parseInt(txt.getText());
                if(datoTxt==menor){
                    txt.setBackground(Color.red);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }
        
    }
    
    public void pintaMenorFila(){
        JTextField txt;
        int menor;
        int datoTxt;
        for(int i=0;i<n; i++){
            menor=1000;
            int j=0;
            while(j<n){
                txt=(JTextField)matriz.getValueAt(i, j);
                datoTxt=Integer.parseInt(txt.getText());
                if(datoTxt<menor){
                    menor=datoTxt;
                }
                j++;
                if(j==n){
                    for(int k=0; k<n ; k++){
                        txt=(JTextField)matriz.getValueAt(i, k);
                        datoTxt=Integer.parseInt(txt.getText());
                        if(datoTxt==menor){
                            txt.setBackground(Color.red);
                            matriz.setValueAt(txt, i, k);
                        }
                    }
                }
            }
        }
    }
    
    public void pintaMenorColumna(){
        JTextField txt;
        int menor;
        int datoTxt;
        for(int j=0;j<n; j++){
            menor=1000;
            int i=0;
            while(i<n){
                txt=(JTextField)matriz.getValueAt(i, j);
                datoTxt=Integer.parseInt(txt.getText());
                if(datoTxt<menor){
                    menor=datoTxt;
                }
                i++;
                if(i==n){
                    for(int k=0; k<n ; k++){
                        txt=(JTextField)matriz.getValueAt(k, j);
                        datoTxt=Integer.parseInt(txt.getText());
                        if(datoTxt==menor){
                            txt.setBackground(Color.red);
                            matriz.setValueAt(txt, k, j);
                        }
                    }
                }
            }
        }
    }
}
