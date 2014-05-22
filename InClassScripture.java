/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inclassscripture;

import java.util.Comparator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Tim
 */
public class InClassScripture extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Favorite Scriptures Apllication");
        GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 700, 275);
		primaryStage.setScene(scene);


                Label scr = new Label("Scripture");
                grid.add(scr, 0, 0);
                
                Label scrs = new Label("Scriptures");
                grid.add(scrs, 3, 0);

                    
                ListView<String> list = new ListView<>();
                ObservableList<String> items =FXCollections.observableArrayList ();
                //list.setItems(items);
                grid.add(list, 3,1,1,10);
                
                TextField userTextField = new TextField();
                grid.add(userTextField, 0, 1); //name, column, row
                
                
                
                Button btn = new Button();
                btn.setText("Add to list");
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        //System.out.println("Hi");
                        items.add(userTextField.getText());
                        list.setItems(items);
                        userTextField.clear();
                        userTextField.requestFocus();
                    }
                });
                grid.add(btn, 1,1);
                
                
                Button btn2 = new Button();
                btn2.setText(""
                        + "Remove from list");
                btn2.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
              
                        items.remove(list.getSelectionModel().getSelectedItem());
                        userTextField.requestFocus();
                        ;
                                
                    }
                });
                grid.add(btn2, 4,1);
                
                Button btn3 = new Button();
                btn3.setText(""
                        + "Sort");
                btn3.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        //sort
                                
                    }
                });
                grid.add(btn3, 4,2);
        primaryStage.show();
    }
}