/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjir4dfinalproject;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Matthew
 */
public class Mjir4dFinalProject extends Application {

    static ArrayList<String> filepaths = new ArrayList<>();
   
    @Override
    public void start(Stage stage) throws Exception {
        
        //Local relative Filepaths, change if needed for testing purposes
        filepaths.add("..\\Mjir4dFinalProject\\src\\starwarsviews.txt");
        filepaths.add("..\\Mjir4dFinalProject\\src\\doctorstrangeviews.txt");
        filepaths.add("..\\Mjir4dFinalProject\\src\\civilwarviews.txt");
        filepaths.add("..\\Mjir4dFinalProject\\src\\suicidesquadviews.txt");
        
        // UI if SceneManager can't switch to a Scene
        HBox root = new HBox();
        root.setPrefSize(600, 400);
        root.setAlignment(Pos.CENTER);
        Text message = new Text("Sorry, there was an issue loading.");
        message.setFont(Font.font(STYLESHEET_MODENA, 32));
        root.getChildren().add(message);
        
        // create Scene and init UI to show failure in case switch fails
        Scene scene = new Scene(root);
        
        Switchable.scene = scene;
        Switchable.switchTo("FXMLDocument");
        
        stage.setScene(scene);
        stage.show();
    }
    
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
