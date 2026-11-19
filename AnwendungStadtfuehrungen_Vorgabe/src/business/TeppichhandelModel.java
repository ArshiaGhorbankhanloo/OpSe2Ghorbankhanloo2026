package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsGhorbankhanloo.ConcreteCreator;
import fileCreatorsGhorbankhanloo.ConcreteTXTcreator;
import fileCreatorsGhorbankhanloo.ReaderCreatorGhorbankhanloo;
import fileCreatorsGhorbankhanloo.ReaderProductGhorbankhanloo;

public class TeppichhandelModel {

    private Teppich teppich;

    public Teppich getTeppich() {
        return this.teppich;
    }

    public void setTeppich(Teppich teppich) {
        this.teppich = teppich;
    }
  

    public void leseAusCsvDatei(String typ) throws IOException {
    	ReaderCreatorGhorbankhanloo creator ;
    
    	if("csv".equals(typ)) {
    		creator=new ConcreteCreator();
    	}else {
    		creator=new ConcreteTXTcreator();
    	}
    	ReaderProductGhorbankhanloo reader=creator.factoryMethod();
    	String zeile []=reader.leseAusDatei();
    	
        this.teppich = new Teppich(
            zeile[0],
            zeile[1],
            Integer.parseInt(zeile[2]),
            Integer.parseInt(zeile[3]),
            zeile[4].split("_")
        );
       reader.schliesseDatei();
    }

    public void schreibeTeppicheInCsvDatei() throws IOException {
        BufferedWriter aus = new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
        aus.write(this.teppich.gibTeppichZurueck(';'));
        aus.close();
    }
}