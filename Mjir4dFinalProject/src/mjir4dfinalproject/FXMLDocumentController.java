/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjir4dfinalproject;

import javafx.scene.control.Label;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;

/**
 *
 * @author Matthew
 */
public class FXMLDocumentController extends Switchable implements Initializable {
    
    int starwarsviews;
    
    @FXML
    Label label;
    
    @FXML
    WebView webView;
    
    MediaPlayer mediaPlayer;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    //Reads file, sets to var 
        BufferedReader br = null;
        try {

                String sCurrentLine;

                br = new BufferedReader(new FileReader(Mjir4dFinalProject.filepaths.get(0)));

                while ((sCurrentLine = br.readLine()) != null) {
                        starwarsviews = Integer.parseInt(sCurrentLine);
                        label.setText(sCurrentLine + " views");
                }

            } catch (IOException e) {
			e.printStackTrace();
            } finally {
                try {
                        if (br != null)br.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
            }
        
        
    //displays embed video in web view   
        webView.getEngine().loadContent("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sGbxmsDFVnE?rel=0&amp;controls=0\" frameborder=\"0\" allowfullscreen></iframe>");
        
    //+1 to view for video
        starwarsviews++;
        
    //Converts int to String      
        String fileinput = Integer.toString(starwarsviews);
        
       
            
    //Writes to file, write views
        try {

                String content = fileinput;

                File file = new File(Mjir4dFinalProject.filepaths.get(0));

                if (!file.exists()) {
                        file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

                System.out.println("Done");

            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    
    @FXML
    public void about() {
        JOptionPane.showMessageDialog(null,"This is a Java video application utilizing embedded Youtube videos; made \n" + "by Matthew Iskra an IT student at the University of Missouri-Columbia.");
    }
    
    @FXML
    public void handleGoTo2(ActionEvent event) {
        //reloads the webview, stops video from playing in background in different scene
        webView.getEngine().loadContent("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sGbxmsDFVnE?rel=0&amp;controls=0\" frameborder=\"0\" allowfullscreen></iframe>");
        
        Switchable.switchTo("FXMLDocument2");
    }
    
    @FXML
    public void handleGoTo3(ActionEvent event) {
        //reloads the webview, stops video from playing in background in different scene
        webView.getEngine().loadContent("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sGbxmsDFVnE?rel=0&amp;controls=0\" frameborder=\"0\" allowfullscreen></iframe>");
        
        Switchable.switchTo("FXMLDocument3");
    }
    
    @FXML
    public void handleGoTo4(ActionEvent event) {
        //reloads the webview, stops video from playing in background in different scene
        webView.getEngine().loadContent("<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/sGbxmsDFVnE?rel=0&amp;controls=0\" frameborder=\"0\" allowfullscreen></iframe>");
        
        Switchable.switchTo("FXMLDocument4");
    }
    
    
    
}
