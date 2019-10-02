/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.logica.forms;

import co.edu.udea.logica.model.Matriz;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TOSHIBA
 */
public class frmMatriz extends javax.swing.JFrame {

    /**
     * Creates new form frmMatriz
     */
    public frmMatriz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        txtN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatriz = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnListaOperaciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNActionPerformed(evt);
            }
        });

        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblMatriz);

        jLabel1.setText("Tamaño Matriz");

        btnListaOperaciones.setText("Lista de operaciones");
        btnListaOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaOperacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListaOperaciones)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(txtN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAceptar)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnListaOperaciones)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNActionPerformed
    
    Matriz matriz;
    Matriz matrizAux;
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        int n;
        try{
            n=Integer.parseInt(txtN.getText());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "El dato ingresado debe ser un entero");
            txtN.setText("");
            return;
        }
        if(n<8 || n>16){
            JOptionPane.showMessageDialog(null, "El dato debe estar entre 8 y 16");
            txtN.setText("");
            return;
        }
        matriz= new Matriz(n, tblMatriz);
        matriz.Llenar();
        
        tblMatriz=matriz.getMatriz();
        matrizAux=matriz;
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnListaOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaOperacionesActionPerformed
        /*if("".equals(txtN.getText())){
            JOptionPane.showMessageDialog(null, "Debe generar una matriz primero");
            return;
        }*/
        tblMatriz=matriz.getMatriz();
        if(matriz==null){
            JOptionPane.showMessageDialog(null, "Debe generar una matriz primero");
            return;
        }
        String opcion=JOptionPane.showInputDialog(null, "Ingrese el numero correspondiente a la operacion que quiere realizar\n" 
                + "\n1. Llenar matriz"
                + "\n2. Sumar matriz"
                + "\n3. Pintar mayor"
                + "\n4. Pintar menor"
                + "\n5. Pintar menor mila" 
                + "\n6. Pintar menor columna"
                + "\n7. Pintar dato con mayor suma de digitos por columna "
                + "\n8. Pintar datos con suma de digitos 5 o 13"
                + "\n9. Ordenar cada columna ascendentemente"
                + "\n10. Pintar letra N"
                + "\n11. Promedio diagonal secundaria"
                + "\n12. Numero de veces por cada dato"
                + "\n13. Pintar triangular superior derecha"
                + "\n14. Ordenar ascendentemente por columnas"
                + "\n15. Intercambiar columnas"
                + "\n16. Pintar datos que pertenezcan a la serie de fibonacci"
                + "\n17. Pintar como tablero de ajedrez"
                + "\n18. Ordenar digitos de cada dato ascendentemente"
                + "\n19. Sumar datos de casillas negras");
        
        switch(opcion){
            case "1":
                matriz.Llenar();
                tblMatriz=matriz.getMatriz();
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "La suma es: "+matriz.sumarDatos());
                break;
            
            case "3":
                matrizAux.pintarMayor();
                tblMatriz=matrizAux.getMatriz();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Option invalida");
        }
        
        tblMatriz=matriz.getMatriz();
        
    }//GEN-LAST:event_btnListaOperacionesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMatriz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMatriz().setVisible(true);
            }
        });
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnListaOperaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMatriz;
    private javax.swing.JTextField txtN;
    // End of variables declaration//GEN-END:variables
}
