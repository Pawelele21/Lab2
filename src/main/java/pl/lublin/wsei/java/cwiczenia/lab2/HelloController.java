package pl.lublin.wsei.java.cwiczenia.lab2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    public Button btnWynik;
    public TextField promien, wysokosc, grubosc;
    public Text info, waga, koszt, Stal, Nierdz;
    public TextField StalWaga, StalKoszt, NierdzWaga, NierdzKoszt;
    float r, h, g;

    public void onBtnAction(ActionEvent actionEvent) {

        promien.setStyle("-fx-border-color: #000");
        wysokosc.setStyle("-fx-border-color: #000");
        grubosc.setStyle("-fx-border-color: #000");

        info.setText("");

        koszt.setVisible(false);
        waga.setVisible(false);
        Stal.setVisible(false);
        Nierdz.setVisible(false);
        StalWaga.setVisible(false);
        NierdzWaga.setVisible(false);
        StalKoszt.setVisible(false);
        NierdzKoszt.setVisible(false);


        if(promien.getText().length() > 0 && wysokosc.getText().length() > 0 && grubosc.getText().length() > 0) {

            try {
                r = Float.parseFloat(promien.getText());
                h = Float.parseFloat(wysokosc.getText());
                g = Float.parseFloat(grubosc.getText());


                if (r > 0 && h > 0 && g > 0) {
                    oblicz();
                } else {
                    info.setText("Wartości muszą być większe od 0!");
                }
            } catch (Exception ignore) {
                info.setText("Nieprawidłowe dane");
            }

        } else {

            if (promien.getText().length() <= 0) promien.setStyle("-fx-border-color: #F00");
            if (wysokosc.getText().length() <= 0) wysokosc.setStyle("-fx-border-color: #F00");
            if (grubosc.getText().length() <= 0) grubosc.setStyle("-fx-border-color: #F00");

            info.setText("Nieprawidłowe dane");
        }
    }

    private void oblicz() {
        koszt.setVisible(true);
        waga.setVisible(true);
        Stal.setVisible(true);
        Nierdz.setVisible(true);
        StalWaga.setVisible(true);
        NierdzWaga.setVisible(true);
        StalKoszt.setVisible(true);
        NierdzKoszt.setVisible(true);

        float pole_calkowite = (float) (2 * 3.14 * r * r + 2 * 3.14 * r * h);

//-----------------------------------------------------------------------------------------------------------

        float waga_blachy = roundResult(7.85F * pole_calkowite * g);
        float waga_blachy_nierdz = roundResult(8F * pole_calkowite * g);

//-----------------------------------------------------------------------------------------------------------

        float cena_blachy = roundResult(2.5F * waga_blachy);
        float cena_blachy_nierdz = roundResult(3F * waga_blachy_nierdz);

//-----------------------------------------------------------------------------------------------------------

        StalWaga.setText(waga_blachy + " kg");
        StalKoszt.setText(cena_blachy + " zł");

//-----------------------------------------------------------------------------------------------------------


        NierdzWaga.setText(waga_blachy_nierdz + " kg");
        NierdzKoszt.setText(cena_blachy_nierdz + " zł");
    }

    private float roundResult(float v) {
        return (float) (Math.round(v * 100.0) / 100.0);
    }
}