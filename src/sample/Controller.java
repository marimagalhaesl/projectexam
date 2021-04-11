package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField taskTextField;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private TextField filterTextField;

    @FXML
    private Button searchBtn;

    @FXML
    private Button loadBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Button deleteAllBtn;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> columnOne;

    @FXML
    private TableColumn<?, ?> columnTwo;

    @FXML
    void HandleAddBtn(ActionEvent event) {

    }

    @FXML
    void HandleDeleteAllBtn(ActionEvent event) {

    }

    @FXML
    void HandleDeleteBtn(ActionEvent event) {

    }

    @FXML
    void HandleFilterTextF(ActionEvent event) {

    }

    @FXML
    void HandleLoadBtn(ActionEvent event) {

    }

    @FXML
    void HandleSaveBtn(ActionEvent event) {

    }

    @FXML
    void HandleSearchBtn(ActionEvent event) {

    }

    @FXML
    void HandleTaskTextF(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
