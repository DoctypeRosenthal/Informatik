class Folge {
  public static void main(String[] args) {  
    int i = 0;
    for (i = 0; i <= 99; i ++) {
      if (i != 0 && i%7 == 0  || i/10 == 7 || i-i/10*10 == 7 ) {
        System.out.println("Bumm");
      } // end of if
      else {
        System.out.println(i);
      } // end of if-else
    
    
    }
  }
}