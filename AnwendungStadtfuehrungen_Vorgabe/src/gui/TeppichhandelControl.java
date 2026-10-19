package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Teppich;
import business.TeppichhandelModel;
import javafx.stage.Stage;

public class TeppichhandelControl {
	
	private TeppichhandelView view;
	private TeppichhandelModel model;
	
	 private Teppich teppich;
	
	
	public TeppichhandelControl(TeppichhandelView view,Stage primaryStage ,TeppichhandelModel model) {
		
		this.view = new TeppichhandelView(primaryStage,model,this) ;
		this.model = model;
	}
	

	 public void nehmeTeppichAuf(){
	    	try{ 
	    		this.teppich = new Teppich(
	    			view.txtArtikelnummer.getTxtArtikelnummer(), 
	   	            view.txtKategorie.getTxtKategorie(),
	   	            view.txtBreite.getTxtBreite(),
	   	        	view.txtLaenge.getTxtLaenge(),
	    		    view.txtFarben.getTxtFarben().split(";"));
	    		view.zeigeInformationsfensterAn("Der Teppich wurde aufgenommen!");
	       	}
	       	catch(Exception exc){
	       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
	     	}
	    }
	 public void leseAusDatei(String typ){
	    	try {
	      		if("csv".equals(typ)){
	      			BufferedReader ein = new BufferedReader(new FileReader("Teppich.csv"));
	      			String[] zeile = ein.readLine().split(";");
	      			this.teppich = new Teppich(zeile[0], 
	      				zeile[1], 
	      				Integer.parseInt(zeile[2]), 
	      				Integer.parseInt(zeile[3]), 
	      				zeile[4].split("_"));
	      				ein.close();
	      	  			view.zeigeInformationsfensterAn(
	      	  	   			"Der Teppich wurde gelesen!");
	      		}
	       		else{
		   			view.zeigeInformationsfensterAn(
		   				"Noch nicht implementiert!");
		   		}
			}
			catch(IOException exc){
				view.zeigeFehlermeldungsfensterAn(
					"IOException beim Lesen!");
			}
			catch(Exception exc){
				view.zeigeFehlermeldungsfensterAn(
					"Unbekannter Fehler beim Lesen!");
			}
		}


	
}
