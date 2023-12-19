module com.example.libraryapp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.libraryappcontroller to javafx.base;
    opens com.example.libraryappinterface to javafx.fxml;
    exports com.example.libraryappinterface;
}