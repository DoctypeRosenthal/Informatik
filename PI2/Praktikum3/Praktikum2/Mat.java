package Praktikum2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Mat {
    private double[][] a = null; // unsere Matrix
    private int crt; // Kontrollwert, ob die Matrix fehlerhaft ist; 1 = ok, -1 = Fehler

    /**
     * Erzeugt in zwei Schritten eine Matrix:
     * 1. Einlesen einer CSV-Datei und Speichern der Werte in eine zweidimensionale Float-Liste
     * 2. Speichern dieser Liste in das zweidimensionale Array-Attribut a
     *
     * Anmerkung:
     * es wäre effizienter, sofort die zweidimensionale Liste im Attribut a zu speichern, aber die Aufgabe verlangt stattdessen ein Array...
     *
     * @param br1 Ein Reader zum Lesen der CSV-Datei
     */
    public Mat(BufferedReader br1) {
        LinkedList<LinkedList<Float>> matrix = getMatrixFromCSV(br1);
        if (a == null) {
            // Matrix Dimensionen wurden noch nicht gesezt -> Spaltenzahl aus erster eingelesener Zeile nehmen
            a = new double[matrix.size()][matrix.get(0).size()];
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                // für jede Zeile und darin jede Spalte, Elemente aus matrix nach a schreiben
                a[i][j] = matrix.get(i).get(j);
            }
        }
    }

    public Mat(double[][] a) {
        this.a = a;
    }

    /**
     * Liest eine CSV-Datei ein und bildet daraus eine Matrix
     * @param br	Ein BufferedReader zum Lesen der Datei
     * @return		Eine Matrix
     */
    private LinkedList<LinkedList<Float>> getMatrixFromCSV(BufferedReader br) {
        LinkedList<LinkedList<Float>> matrix = new LinkedList<LinkedList<Float>>();
        try {
            String csvLine = br.readLine();

            while(csvLine != null) {
                // für jede eingelesene Zeile, eine neue Matrixzeile erzeugen
                LinkedList<Float> matrixRow = new LinkedList<Float>();
                String[] components = csvLine.split(",");
                for (String el: components) {
                    // jedes Element der aktuellen Zeile einlesen, in Float umwandeln und speichern
                    matrixRow.add(new Float(el));
                }
                matrix.add(matrixRow);
                csvLine = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.print("Fehler: " + e);
            this.setCrt(-1);
        }

        return matrix;
    }

    /**
     * Schreibt die Matrix in eine CSV-Datei
     * @param fx			Ein FileWriter, der zum Schreiben in eine Datei benutzt wird
     * @return				true, wenn alles gut ging
     * @throws IOException	falls beim Schreiben ein Fehler auftritt
     */
    public boolean matAus(FileWriter fx) throws IOException {
        PrintWriter pw = new PrintWriter(fx);
        for (double[] line: this.a) {
            pw.println(lineToCSV(line));
        }

        pw.close();

        return true;
    }

    /**
     * Formt eine übergebenes float-Array in ein CSV-String um
     * @param line	Das float-Array
     * @return		Der CSV-String
     */
    private String lineToCSV(double[] line) {
        String[] tmp = new String[line.length];
        for (int i = 0; i < line.length; i++) {
            tmp[i] = String.valueOf(line[i]);
        }

        return String.join(",", tmp); // forme Array in CSV-Zeichenkette um
    }

    public Mat mulMat(Mat b) throws Error {
        Mat c;
        if (this.getCols() != b.getRows()) {
            // Matrizenmultiplikation nicht definiert
            c = new Mat(new double[0][0]);
            c.setCrt(-3);
            throw new Error("Matrizenmultiplikation nicht definiert! Ungleiche Anzahl von Spalten in A (" + this.getCols() + ") und Zeilen in B (" + b.getRows() + ")");
        }
        else {
            // Matrizen multiplizieren und das Ergebnis in c speichern
            double[][] matrix = new double[this.getRows()][b.getCols()];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) { // geht das? ansonsten muss man this.getRows(), b.getCols()
                    matrix[i][j] = productSum(this.getRow(i), b.getCol(j));
                }
            }

            c = new Mat(matrix);
        }
        return c;
    }

    public int getCrt() {
        return crt;
    }

    public void setCrt(int crt) {
        this.crt = crt;
    }

    public double[] getRow(int rowID) {
        return this.a[rowID];
    }

    public double[] getCol(int colID) {
        double[] col = new double[this.a.length];
        int i = 0;
        for (double[] row: this.a) {
            // lese in jeder Zeile das Element mit dem index colID
            col[i] = row[colID];
            i ++;
        }

        return col;
    }


    /**
     * FÜhre die Matrizenmultiplikation für eine Zeile mit einer Spalte aus
     * @param row 	Die Matrixzeile
     * @param col 	Die Matrixspalte
     * @return 		Die Produktsumme
     */
    private double productSum(double[] row, double[] col) {
        double out = 0;
        for (int i = 0; i < row.length; i++) {
            out += row[i]*col[i];
        }
        return out;
    }

    /**
     * @return Die Zeilenanzahl der Matrix
     */
    public int getRows() {
        return this.a.length;
    }

    /**
     * @return Die Spaltenanzahl der Matrix
     */
    public int getCols() {
        return this.a[0].length;
    }
}
