/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boldness;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Comparator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Tim
 */
public class Boldness extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        
        BorderPane borderPane = new BorderPane();
        HBox title = new HBox();
        title.setPadding(new Insets(15, 12, 15, 12));
        title.setSpacing(10);
        title.setAlignment(Pos.CENTER);
        borderPane.setTop(title);
        
        Label rbl = new Label("Enter Runnable:");     
        TextField runnableText = new TextField();
        runnableText.setPrefWidth(250);
        
        title.getChildren().addAll(rbl, runnableText);
      

        
        
        GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(50);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
                
                borderPane.setCenter(grid);

		Scene scene = new Scene(borderPane, 375, 400);
		primaryStage.setScene(scene);

                primaryStage.setTitle("Glory");

                Label rbl2 = new Label("Runnables");
                grid.add(rbl2,0,0);
                GridPane.setHalignment(rbl2, HPos.CENTER);

                Label thrLbl = new Label("Running Threads");
                grid.add(thrLbl, 1, 0);   
                GridPane.setHalignment(thrLbl, HPos.CENTER);
                    
                ListView<String> runnable = new ListView<>();
                ObservableList<String> items =FXCollections.observableArrayList ();
                runnable.setMaxWidth(175.0);
                //list.setItems(items);
                grid.add(runnable, 0,1,1,10);
                
                
                ListView<String> running = new ListView<>();
                ObservableList<String> runItems =FXCollections.observableArrayList ();
                running.setMaxWidth(175.0);
                //list.setItems(items);
                grid.add(running, 1,1,1,10);
                
                
                
                
                
                Button btn = new Button();
                btn.setText("Start");
                btn.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        //System.out.println("Hi");
                        //items.add(userTextField.getText());
                        //list.setItems(items);
                        //userTextField.clear();
                        //userTextField.requestFocus();
                    }
                });
                grid.add(btn, 0,12);
                GridPane.setHalignment(btn, HPos.CENTER);
                
                
                
                Button btn3 = new Button();
                btn3.setText(""
                        + "Stop");
                btn3.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        BufferedWriter   out = null;

                         try {
                            out = new BufferedWriter(new FileWriter("run.txt"));
                            String c;
                            int i = 0;
                            Object[] temp = items.toArray();
                            while (i < temp.length) {
                              out.write(temp[i].toString());
                              out.newLine();
                              i++;
                            }
                             }catch(Exception ex) {
                               System.out.println("Error: " + ex);
                             }finally {
                               try {
                             if (out != null) {
                               out.close();
                             }
                                   }catch(Exception ex) {
                               System.out.println("Error: " + ex);
                               }
                         }
                                
                    }
                });
                grid.add(btn3, 1,12);
                GridPane.setHalignment(btn3, HPos.CENTER);
        primaryStage.show();
    }
}