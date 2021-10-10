import java.io.*

class ZDATM {
	private FileReader fr1;

	private BufferedReader br1;

	private FileWrite fw1;

	private PrintWriter pr1;

	private LinkedList <Maschine> dsliste;

	ZDatM (String dsn, int mod){
        this.dsliste = new LinkedList <Maschine>;
    	String h;

		if (mod == 1){
			fr1 = new FileReader(dsn);
			br1 = new BufferedReader (fr1);
			h = br1.readLine();

			while (h != null){
				Maschine ma = new Maschine(h);
				dsliste.add(ma);
				h = br.readLine();
			}
			br1.close();
		}

		if (mod == 2){
			fw1 = new FileWriter (dsn, true);
			pr1 = new PrintWriter (fw1);
			pr1.println(h);
		}
	}





	/*  Ich glaube ich brauche den driss gar nicht
	public Setfw1 (String datei) {
		fw1 = new FileWriter (datei,true)
	}

	public Setfr1 (String datei) {
		fr1 = new FileReader (datei);
	}

	public Setbr1 {
		br1 = new BufferedReader (fr1);
	}

	public Setpr1 {
		pr1  = new PrintWriter (fw1);
	}

	public Getfw1 {
		return fw1;
	}

	public Getfr1 {
		return fr1;
	}

	public Getbr1 {
		return br1;
	}

	public Getpr1 {
		return pr1;
	}
	*/
}
