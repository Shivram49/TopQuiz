module ooad.assign.topquiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens ooad.assign.topquiz to javafx.fxml;
    exports ooad.assign.topquiz;
    exports ooad.assign.topquiz.controllers;
    opens ooad.assign.topquiz.controllers to javafx.fxml;
}