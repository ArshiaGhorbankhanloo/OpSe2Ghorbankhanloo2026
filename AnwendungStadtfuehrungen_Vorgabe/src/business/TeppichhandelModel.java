package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TeppichhandelModel {

    private Teppich teppich;

    public Teppich getTeppich() {
        return this.teppich;
    }

    public void setTeppich(Teppich teppich) {
        this.teppich = teppich;
    }

    public void leseAusCsvDatei() throws IOException {
        BufferedReader ein = new BufferedReader(new FileReader("Teppich.csv"));
        String[] zeile = ein.readLine().split(";");
        this.teppich = new Teppich(
            zeile[0],
            zeile[1],
            Integer.parseInt(zeile[2]),
            Integer.parseInt(zeile[3]),
            zeile[4].split("_")
        );
        ein.close();
    }

    public void schreibeTeppicheInCsvDatei() throws IOException {
        BufferedWriter aus = new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
        aus.write(this.teppich.gibTeppichZurueck(';'));
        aus.close();
    }
}