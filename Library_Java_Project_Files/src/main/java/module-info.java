module com.example.libraryint {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.library_gui_controller to javafx.fxml;
    exports com.library_gui_controller;
    exports com.library_database_controller;
    opens com.library_database_controller to javafx.fxml;
}