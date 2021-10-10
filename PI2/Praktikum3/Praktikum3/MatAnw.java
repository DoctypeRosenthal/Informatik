package Praktikum3;
import java.io.*;

/**
 * Created by lorenz on 12.06.17.
 */
public class MatAnw {
    public static void main(){
        Mat a = new Mat(new double[][] {{1, 2}, {3, 4}, {-2, -1}});

        try {
            FileWriter fw1 = new FileWriter("Praktikum3_matrix.txt");
            a.matAus(fw1);
            Mat b = new Mat(a.skalMult(5));
            FileWriter fw2 = new FileWriter("Praktikum3_skmat.dat");
            b.matAus(fw2);
            fw1.close();
            fw2.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
