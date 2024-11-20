module com.example.inventario {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens fes.ico.unam.mx.interfaz to javafx.fxml;
    exports fes.ico.unam.mx.interfaz;
    exports fes.ico.unam.mx.controladoresSec;
    opens fes.ico.unam.mx.controladoresSec to javafx.fxml;
}