package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {

   private SimpleStringProperty task;
   private SimpleStringProperty responsible;


    public StringProperty taskProperty() {
        return task;
    }

    public StringProperty responsibleProperty() {
        return responsible;
    }

    public Task(String task, String responsible) {
        this.task = new SimpleStringProperty(task);
        this.responsible = new SimpleStringProperty(responsible);
    }
}


