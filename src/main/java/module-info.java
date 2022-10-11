module fr.eseo.bachelor.starfox {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.eseo.bachelor.starfox to javafx.fxml;
    exports fr.eseo.bachelor.starfox;
}