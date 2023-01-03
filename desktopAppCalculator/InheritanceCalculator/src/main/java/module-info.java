module com.example.Inheritance {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.Inheritance to javafx.fxml;
    exports com.example.Inheritance;
}