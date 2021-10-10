package Praktikum3;

import java.io.BufferedReader;

/**
 * Created by lorenz on 12.06.17.
 */
public class Mat extends Praktikum2.Mat implements Scalable {
    Mat(BufferedReader br1) {
        super(br1);
    }

    Mat(double[][] a) {
        super(a);
    }

    public double[][] skalMult(double x) {
        double[][] out = new double[this.getRows()][this.getCols()];

        for (int i = 0; i < out.length; i++) {
            double[] row = this.getRow(i);
            for (int j = 0; j < out[0].length; j++) {
                out[i][j] = row[j] * x;
            }
        }
        return out;
    }
}
