module pl.lublin.wsei.java.cwiczenia.lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.lublin.wsei.java.cwiczenia.lab2 to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia.lab2;
}