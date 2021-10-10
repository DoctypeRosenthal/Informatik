package Praktikum3;
import Praktikum2.Maschine;
import java.io.Serializable;

/**
 * Created by lorenz on 12.06.17.
 */
public class MaschineSer extends Maschine implements Serializable {

    MaschineSer(String csv) {
        super(csv);
    }

}
