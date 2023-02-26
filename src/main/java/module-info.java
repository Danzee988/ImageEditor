module project.imageeditor {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.imageeditor to javafx.fxml;
    exports project.imageeditor;
    exports Calculations;
    opens Calculations to javafx.fxml;
}