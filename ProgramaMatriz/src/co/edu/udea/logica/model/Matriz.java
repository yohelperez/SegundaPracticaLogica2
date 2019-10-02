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
    
    public void Llenar(){
        Random numeroAleatorio= new Random();
        JTextField txt;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                txt=new JTextField(Integer.toString(numeroAleatorio.nextInt(1000)));
                this.matriz.setValueAt(txt, i, j);              //numeroAleatorio.nextInt(1000);
                System.out.println(i + "," + j+ ":"+ matriz.getValueAt(i, j));
            }
        }
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
}
