package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    private TextField taskTextField;

    @FXML
    private TextField filterTextField;

    @FXML
    private TableView<Task> tableView;

    @FXML
    private TableColumn<Task, String> columnOne;

    @FXML
    private TableColumn<Task, String> columnTwo;

    @FXML
    void HandleAddBtn() {
        if (taskTextField.getText().equals("")) {

        } else {
            Task t = new Task(taskTextField.getText(), "Lola");
            tableView.getItems().add(t);
        }
    }

    @FXML
    void HandleDeleteAllBtn() {
        tableView.getItems().clear();
    }

    @FXML
    void HandleDeleteBtn() {
        int index = tableView.getSelectionModel().getSelectedIndex();
        tableView.getItems().remove(index);
    }

    @FXML
    void HandleLoadBtn() {
        tableView.getItems().clear();

        try {
            //open connection
            File file = new File("/Users/marianamagalhaes/Desktop/FinalExam/Practice/src/sample/Lola.txt");
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine())
            {
                String temp = scanner.nextLine();
                String[] newtask = temp.split(",");

                Task t = new Task(newtask[0], newtask[1]);
                tableView.getItems().add(t);

            }

            //closing connection
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void HandleSaveBtn() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Hello");
        alert.setHeaderText(null);

        try {
            //open connection
            FileWriter fileWriter = new FileWriter("/Users/marianamagalhaes/Desktop/FinalExam/Practice/src/sample/SaveLola.txt");

            for(int i=0; i < tableView.getItems().size(); i++) {

                String task1 = tableView.getItems().get(i).taskProperty().getValue();
                String responsible1 = tableView.getItems().get(i).responsibleProperty().getValue();
                String line = task1 + "," + responsible1;
                fileWriter.write(line);
                fileWriter.write("\n");

            }
            fileWriter.close();
            alert.setContentText("Lola salva!");
            alert.showAndWait();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }


    }

    @FXML
    void HandleSearchBtn() {
        TableView.TableViewSelectionModel<Task> selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);


        if(tableView.getItems().size() == 0) {
            alert.setContentText("Sem Lola sem lista.");
            alert.showAndWait();
        } else {
            for (int i = 0; i < tableView.getItems().size(); i++) {
                if (tableView.getItems().get(i).taskProperty().getValue().equals(filterTextField.getText())) {
                    // tableView.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                    selectionModel.select(i);
                } else {
                    alert.setContentText("Lola não encontrada. Procure no Lolapalozza");
                    alert.showAndWait();
                    break;
                }
            }
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        //STEP 01: Create a person class that will represent data
        // = Task.java

        //STEP 02: Define data in an Observable list and add data as you want to show inside table
        //ObservableList<Task> data = FXCollections.observableArrayList("o que for iniciar dentro da lista");

        //STEP 03: Associate data with columns
        columnOne.setCellValueFactory(new PropertyValueFactory<Task, String>("task"));
        columnTwo.setCellValueFactory(new PropertyValueFactory<Task, String>("responsible"));

        //STEP 04: add data inside table
        //tableView.setItems(data);


    }
}
