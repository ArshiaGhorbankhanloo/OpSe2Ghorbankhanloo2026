package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gui.TeppichhandelControl;
import gui.TeppichhandelView;

public class TeppichhandelModel {
	
private TeppichhandelControl control;
private TeppichhandelView view;
private Teppich teppich;
	
	public void schreibeTeppicheInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("TeppicheAusgabe.csv", true));
			aus.write(teppich.gibTeppichZurueck(';'));
			aus.close();
   			view.zeigeInformationsfensterAn(
	   			"Die Teppiche wurden gespeichert!");
		}	
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			this.view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

	 
}
