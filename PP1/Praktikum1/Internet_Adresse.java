import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Internet_Adresse {
    public static void main(String args[]) {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
      int IP[] = new int[4];
      int PORT;
      StringBuffer Address;
      int i;
        
      for (i = 0; i < 4; i ++) {
        IP[i] = IO1.einint();
      }
      
      PORT = IO1.einint();
      try {
        Address = new StringBuffer(br.readLine());   
      } catch(Exception e) {
        return;
      } 
       
      System.out.println("Adresse: " + IP[0] + "." + IP[1] + "." + IP[2] + "." + IP[3] + ":" + PORT + ", " + Address);
  
      System.out.println(Address.length());
      
      System.out.println(Address.indexOf("www.") == 0);
      
      Address.delete(0, 4);
      
      System.out.println(Address);
    }
} 