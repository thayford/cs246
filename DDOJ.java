/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ddoj;

/**
 *
 * @author Tim
 */
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
 
public class DDOJ extends Application {    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("Color Picker");
        Scene scene = new Scene(new HBox(20), 400, 100);
        HBox box = (HBox) scene.getRoot();
        box.setPadding(new Insets(5, 5, 5, 5));          
        final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.CORAL);
        
        final Text text = new Text("Color Picker Example");
        text.setFont(Font.font ("Verdana", 20));
        text.setFill(colorPicker.getValue());
        

        colorPicker.setOnAction((ActionEvent t) -> {
            text.setFill(colorPicker.getValue());
        });
 
        box.getChildren().addAll(colorPicker, text);
 
        stage.setScene(scene);
        stage.show();
    }
}