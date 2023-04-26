module com.astu.bustransportsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens com.astu.bustransportsystem to javafx.fxml;
    exports com.astu.bustransportsystem;
    exports com.astu.bustransportsystem.controllers;
    opens com.astu.bustransportsystem.controllers to javafx.fxml;
    exports com.astu.bustransportsystem.Utilities;
    opens com.astu.bustransportsystem.Utilities to javafx.fxml;
}