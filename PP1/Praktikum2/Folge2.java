class Folge2 {
  public static void main(String[] args) {  
    int n,m,i;
    for (n = 0; n <= 9; n ++) {
      for (m = 0; m <= 9; m ++) {
       i = n*10+m;
        if (i != 0 &&  i%7 == 0  || i/10 == 7 || i-i/10*10 == 7 ) {
           System.out.println("Bumm");
        } // end of if
        else {
             System.out.println(i);
        } // end of if-else
      
      }
    }
    }
  }
