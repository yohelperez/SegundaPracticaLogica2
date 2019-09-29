package co.edu.udea.logica.model;

import java.util.Random;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TOSHIBA
 */
public class Matriz extends JTable{
    private JTable matriz;
    private int n;

    public Matriz(int n, JTable matriz) {
        this.n=n;
        this.matriz = matriz;
        DefaultTableModel model= (DefaultTableModel)matriz.getModel();
        model.setRowCount(n);       //numero de filas
        model.setColumnCount(n);    //numero de columnas
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
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                this.matriz.setValueAt(numeroAleatorio.nextInt(1000), i, j);              //numeroAleatorio.nextInt(1000);
                System.out.println(i + "," + j+ ":"+ matriz.getValueAt(i, j));
            }
        }
    }
}
