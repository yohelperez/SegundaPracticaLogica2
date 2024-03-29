package co.edu.udea.logica.model;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author TOSHIBA
 */
//todo: generar numeros hasta 1000 y poner restricciones para tamaño de matriz
public class Matriz extends JTable {

    private JTable matriz;
    private int n;

    public Matriz(int n, JTable matriz) {
        matriz.setDefaultRenderer(Object.class, new Render()); // renderiza la tabla  con la clase creada que permite agregar textfield

        this.n = n;
        this.matriz = matriz;
        DefaultTableModel model = (DefaultTableModel) matriz.getModel();
        model.setRowCount(n);       //numero de filas
        model.setColumnCount(n);    //numero de columnas
        matriz.setRowHeight(22);    //cambia la altura de las filas

        JTableHeader header = matriz.getTableHeader();
        TableColumnModel colMod = header.getColumnModel();
        for (int i = 0; i < n; i++) {
            TableColumn tabCol = colMod.getColumn(i);
            tabCol.setHeaderValue(i + 1);
            //header.repaint();
        }

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
    JTextField txt;
    int datoTxt;

    public void limpiar() {
        //JTextField txt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                txt.setBackground(Color.white);
                matriz.setValueAt(txt, i, j);

            }
        }
    }

    //1
    public void Llenar() {
        Random numeroAleatorio = new Random();
        //JTextField txt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = new JTextField(Integer.toString(numeroAleatorio.nextInt(1000)));
                this.matriz.setValueAt(txt, i, j);              //numeroAleatorio.nextInt(1000);
                //System.out.println(i + "," + j+ ":"+ matriz.getValueAt(i, j));
            }
        }
        limpiar();
    }

    //2
    public int sumarDatos() {
        int suma = 0;
        //JTextField txt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                suma += Integer.parseInt(txt.getText());
            }
        }
        return suma;
    }

    //3
    public void pintarMayor() {
        //JTextField txt;
        int mayor = 0;
        //int datoTxt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (datoTxt > mayor) {
                    mayor = datoTxt;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (datoTxt == mayor) {
                    txt.setBackground(Color.red);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }

    }

    //4
    public void pintarMenor() {
        //JTextField txt;
        int menor = 1000;
        //int datoTxt;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (datoTxt < menor) {
                    menor = datoTxt;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (datoTxt == menor) {
                    txt.setBackground(Color.red);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }

    }

    //5
    public void pintaMenorFila() {
        //JTextField txt;
        int menor;
        //int datoTxt;
        for (int i = 0; i < n; i++) {
            menor = 1000;
            int j = 0;
            while (j < n) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (datoTxt < menor) {
                    menor = datoTxt;
                }
                j++;
                if (j == n) {
                    for (int k = 0; k < n; k++) {
                        txt = (JTextField) matriz.getValueAt(i, k);
                        datoTxt = Integer.parseInt(txt.getText());
                        if (datoTxt == menor) {
                            txt.setBackground(Color.red);
                            matriz.setValueAt(txt, i, k);
                        }
                    }
                }
            }
        }
    }

    //6
    public void pintaMenorColumna() {
        //JTextField txt;
        int menor;
        //int datoTxt;
        for (int j = 0; j < n; j++) {
            menor = 1000;
            int i = 0;
            while (i < n) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (datoTxt < menor) {
                    menor = datoTxt;
                }
                i++;
                if (i == n) {
                    for (int k = 0; k < n; k++) {
                        txt = (JTextField) matriz.getValueAt(k, j);
                        datoTxt = Integer.parseInt(txt.getText());
                        if (datoTxt == menor) {
                            txt.setBackground(Color.red);
                            matriz.setValueAt(txt, k, j);
                        }
                    }
                }
            }
        }
    }

    //7
    public void pintaDatoConMayorSumaDigitosPorColumna() {
        //JTextField txt;
        int mayor;
        //int datoTxt;
        for (int j = 0; j < n; j++) {
            mayor = 0;
            int i = 0;
            while (i < n) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (sumarDigitos(datoTxt) > mayor) {
                    mayor = sumarDigitos(datoTxt);
                }
                i++;
                if (i == n) {
                    for (int k = 0; k < n; k++) {
                        txt = (JTextField) matriz.getValueAt(k, j);
                        datoTxt = Integer.parseInt(txt.getText());
                        if (sumarDigitos(datoTxt) == mayor) {
                            txt.setBackground(Color.red);
                            matriz.setValueAt(txt, k, j);
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> obtenerDigitos(int numero) {
        ArrayList<Integer> digitos = new ArrayList<>();

        while (numero != 0) {
            digitos.add(numero % 10);
            numero = numero / 10;
        }
        return digitos;

    }

    private int sumarDigitos(int numero) {
        ArrayList<Integer> digitos = this.obtenerDigitos(numero);
        int suma = 0;
        for (int i = 0; i < digitos.size(); i++) {
            suma += digitos.get(i);
        }

        return suma;
    }

    //8
    public void pintaDatosConSumaDigitos5o13() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (sumarDigitos(datoTxt) == 5 || sumarDigitos(datoTxt) == 13) {
                    txt.setBackground(Color.red);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }

    }

    //9
    public void ordenaCadaColumnaAscendentemente() {
        ArrayList<Integer> columna = new ArrayList();
        for (int j = 0; j < n; j++) {
            int i = 0;
            columna.clear();
            while (i < n) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                columna.add(datoTxt);
                i++;
                if (i == n) {
                    Collections.sort(columna);
                    for (int k = 0; k < n; k++) {
                        txt = (JTextField) matriz.getValueAt(k, j);
                        txt.setText(columna.get(k).toString());
                        matriz.setValueAt(txt, k, j);
                    }
                }
            }
        }
    }

    //10
    public void pintaN() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j == 0 || i == j || j == (n - 1)) {
                    txt = (JTextField) matriz.getValueAt(i, j);
                    txt.setBackground(Color.red);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }
    }

    //11
    public int promedioDiagonalSecundaria() {
        int promedio = 0;
        for (int i = 0; i < n; i++) {
            txt = (JTextField) matriz.getValueAt(i, n - (i + 1));

            //pintar
            txt.setBackground(Color.red);
            matriz.setValueAt(txt, i, n - (i + 1));
            //calcular promedio
            datoTxt = Integer.parseInt(txt.getText());
            promedio += datoTxt;
        }
        promedio = promedio / n;
        return promedio;
    }

    //12
    public void numeroVecesCadaDato() {
        ArrayList<Integer> datos = new ArrayList<>();
        ArrayList<Integer> numeroRepeticiones = new ArrayList();
        int posicion;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                posicion = datos.indexOf(datoTxt);
                if (posicion == -1) {
                    datos.add(datoTxt);
                    numeroRepeticiones.add(1);
                } else {
                    numeroRepeticiones.set(posicion, numeroRepeticiones.get(posicion) + 1);
                }

            }
        }
        String conteo = "Conteo de apariciones de cada dato:\n";
        for (int i = 0; i < datos.size(); i++) {
            conteo += datos.get(i).toString() + ": " + numeroRepeticiones.get(i).toString() + "\n";
        }

        JTextArea textArea = new JTextArea(conteo);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(500, 500));        
        JOptionPane.showMessageDialog(null, scrollPane);
    }

    //13
    public void pintaTriangularSuperiorDerecha() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j >= i) {
                    txt = (JTextField) matriz.getValueAt(i, j);
                    txt.setBackground(Color.red);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }
    }

    //14
    public void ordenarAscendentementePorColumnas() {
        ArrayList<Integer> sumasPorColumnas = new ArrayList();
        ArrayList<Integer> columnasOrdenadas = new ArrayList();
        int posicionY;
        int[][] copiaMatriz = new int[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());

                copiaMatriz[i][j] = datoTxt;
                if (i == 0) {
                    sumasPorColumnas.add(datoTxt);
                } else {
                    sumasPorColumnas.set(j, sumasPorColumnas.get(j) + datoTxt);
                }
            }

        }
        for (int i = 0; i < n; i++) {
            columnasOrdenadas.add(sumasPorColumnas.get(i));
        }
        Collections.sort(columnasOrdenadas);

        //intercambio de columnas
        for (int j = 0; j < n; j++) {
            posicionY = sumasPorColumnas.indexOf(columnasOrdenadas.get(j)); //obtiene la posicion en el arraylist de las sumas, correspondiente al arraylist ordenado
            for (int i = 0; i < n; i++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                txt.setText(Integer.toString(copiaMatriz[i][posicionY]));
                matriz.setValueAt(txt, i, j);
            }

            sumasPorColumnas.set(posicionY, -1);
        }
    }

    //15
    public void intercambiarColumnas() {
        int i = recibirDato(0);
        int j = recibirDato(1);
        int[] columna1 = new int[n];
        int[] columna2 = new int[n];

        columna1 = llenarColumna(columna1, i);
        columna2 = llenarColumna(columna2, j);

        for (int k = 0; k < n; k++) {
            //se pasa a la fila k de la columna i el dato de la misma fila en la columna j
            txt = (JTextField) matriz.getValueAt(k, i - 1);
            txt.setText(Integer.toString(columna2[k]));
            matriz.setValueAt(txt, k, i - 1);

            //se pasa a la fila k de la columna j el dato de la misma fila en la columna i
            txt = (JTextField) matriz.getValueAt(k, j - 1);
            txt.setText(Integer.toString(columna1[k]));
            matriz.setValueAt(txt, k, j - 1);
        }
    }

    private int recibirDato(int num) {
        int i = 0;
        String[] numeracion = {"primera", "segunda"};
        boolean validado = false;
        boolean ban = false;
        while (!validado) {
            try {
                i = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la " + numeracion[num] + " columna a intercambiar: "));
                ban = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El dato debe ser un entero");
                ban = false;
            }

            if (ban && Integer.class.isInstance(i)) {
                if (i < 1 || i > n) {
                    JOptionPane.showMessageDialog(null, "El numero ingresado no corresponde a ninguna columna de la matriz");
                } else {
                    validado = true;
                }
            }
        }
        return i;
    }

    private int[] llenarColumna(int[] columna, int numColumna) {
        for (int i = 0; i < n; i++) {
            txt = (JTextField) matriz.getValueAt(i, numColumna - 1);
            datoTxt = Integer.parseInt(txt.getText());
            columna[i] = datoTxt;
        }
        return columna;
    }

    //16
    public void pintarFibonacci() {
        ArrayList<Integer> fibonacci = new ArrayList();
        fibonacci.add(0);
        fibonacci.add(1);
        int num = 1;
        int posicion = 1;

        //creacion de la lista fibonacci
        while (num < 1000) {
            num = (fibonacci.get(posicion) + fibonacci.get(posicion - 1));
            fibonacci.add(num);
            posicion++;
        }

        System.out.println("Numeros serie fibonacci: ");
        for (int i = 0; i < fibonacci.size(); i++) {
            System.out.print(fibonacci.get(i) + ", ");
        }
        //pintar datos en la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                if (fibonacci.contains(datoTxt)) {
                    txt.setBackground(Color.red);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }
    }

    //17
    public void pintaComoTableroAjedrez() {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j < n; j += 2) {
                    txt = (JTextField) matriz.getValueAt(i, j);
                    txt.setBackground(Color.gray);
                    matriz.setValueAt(txt, i, j);
                }
            } else {
                for (int j = 0; j < n; j += 2) {
                    txt = (JTextField) matriz.getValueAt(i, j);
                    txt.setBackground(Color.gray);
                    matriz.setValueAt(txt, i, j);
                }
            }
        }
    }

    //18
    public void ordenaDigitosDescendentemente() {
        ArrayList<Integer> lista = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                txt = (JTextField) matriz.getValueAt(i, j);
                datoTxt = Integer.parseInt(txt.getText());
                lista = obtenerDigitos(datoTxt);
                Collections.sort(lista, Collections.reverseOrder());
                txt.setText("");
                for (int k = 0; k < lista.size(); k++) {
                    txt.setText(txt.getText() + lista.get(k).toString());
                }

                if (lista.isEmpty()) {
                    txt.setText("0");
                }
                matriz.setValueAt(txt, i, j);

            }
        }

    }

    //19
    public void sumaDatosCasillasNegras() {
        int suma = 0;
        this.pintaComoTableroAjedrez();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 1; j < n; j += 2) {
                    txt = (JTextField) matriz.getValueAt(i, j);
                    datoTxt = Integer.parseInt(txt.getText());
                    suma += datoTxt;
                }
            } else {
                for (int j = 0; j < n; j += 2) {
                    txt = (JTextField) matriz.getValueAt(i, j);
                    datoTxt = Integer.parseInt(txt.getText());
                    suma += datoTxt;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "La suma de los datos de las casillas negras es: " + suma);
    }
}
