module com.example.libraryint {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.library_gui_controller to javafx.fxml;
    exports com.library_gui_controller;
}