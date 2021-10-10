public class Padding {
  public static void main(String args[]) {
    int l, n, k, gl, p;
    double x;
    
    l = IO1.einint();
    n = IO1.einint();
    
    x = l / Math.pow(2, n);
    
    k = (int) Math.ceil(x);
    
    gl = k * (int) Math.pow(2, n);
    
    p = gl - l;
    
    System.out.println("x: " + x + ", k: " + k + ", gl: " + gl + ", p: " + p);
    
         
  }
} 