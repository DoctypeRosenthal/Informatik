import java.io.*;

public class MatAnw {

  public static void main(String[] args) throws IOException {
    Mat a = new Mat(new double[][] {{1, 2}, {3, 4}, {-2, -1}});
    Mat b = new Mat(new double[][] {{1, 0, 3}, {0, 1, 4}});
    Mat c = a.mulMat(b);

    try {
      FileWriter fw1 = new FileWriter("Matrix.txt");
      c.matAus(fw1);

      FileReader fr = new FileReader("Matrix.txt");
      BufferedReader br = new BufferedReader(fr);
      Mat d = new Mat(br);
      Mat e = d.mulMat(a);
      FileWriter fw2 = new FileWriter("Matrix.txt");
      e.matAus(fw2);
      fw1.close();
      fw2.close();
      br.close();
    }
    catch (IOException e) {
      System.out.println("Fehler: "+ e);
      throw e;
    }
  }
}
