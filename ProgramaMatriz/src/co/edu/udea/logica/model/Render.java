/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.logica.model;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author TOSHIBA
 */
public class Render extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column){
        if(value instanceof JTextField){        //si value es una instancia de un textfield lo agrega y lo muesra en la tabla
            JTextField txtField=(JTextField)value;
            return txtField;
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, row);
    }
}
