module com.example.libraryint {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.libraryint to javafx.fxml;
    exports com.example.libraryint;
}