package gui;

import java.io.IOException;
import business.Teppich;
import business.TeppichhandelModel;
import javafx.stage.Stage;

public class TeppichhandelControl {

    private TeppichhandelView view;
    private TeppichhandelModel model;

    public TeppichhandelControl(Stage primaryStage) {
        this.model = new TeppichhandelModel();
        this.view = new TeppichhandelView(this, primaryStage);
    }

    public void nehmeTeppichAuf() {
        try {
            Teppich teppich = new Teppich(
                view.getTxtArtikelnummer(),
                view.getTxtKategorie(),
                Integer.parseInt(view.getTxtBreite()),
                Integer.parseInt(view.getTxtLaenge()),
                view.getTxtFarben().split(";")
            );
            this.model.setTeppich(teppich);
            view.zeigeInformationsfensterAn("Der Teppich wurde aufgenommen!");
           
        } catch (Exception exc) {
            view.zeigeFehlermeldungsfensterAn("Fehler bei der Eingabe: " + exc.getMessage());
        }
    }

    public void zeigeTeppicheAn() {
        if (this.model.getTeppich() != null) {
            view.setTxtAnzeige(this.model.getTeppich().gibTeppichZurueck(' '));
        } else {
            view.zeigeInformationsfensterAn("Bisher wurde kein Teppich aufgenommen!");
        }
    }

    public void leseAusDatei(String typ) {
        try {
            if ("csv".equals(typ)) {
                this.model.leseAusCsvDatei();
                view.zeigeInformationsfensterAn("Der Teppich wurde gelesen!");
            } else {
                view.zeigeInformationsfensterAn("Noch nicht implementiert!");
            }
        } catch (IOException exc) {
            view.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
        } catch (Exception exc) {
            view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
        }
    }

    public void schreibeTeppicheInDatei(String typ) {
        try {
            if ("csv".equals(typ)) {
                this.model.schreibeTeppicheInCsvDatei();
                view.zeigeInformationsfensterAn("Die Teppiche wurden gespeichert!");
            } else {
                view.zeigeInformationsfensterAn("Noch nicht implementiert!");
            }
        } catch (IOException exc) {
            view.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
        } catch (Exception exc) {
            view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
        }
    }
}