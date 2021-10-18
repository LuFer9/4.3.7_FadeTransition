/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.pkg3.pkg7_fadetransition;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Luis
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //elegimos el layout y instanciamos la escena
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Fade Transtion");
        primaryStage.setScene(scene);
        
        //Creamos el objeto elipse
        Ellipse elipse = new Ellipse(150, 125, 50, 25);
        elipse.setFill(Color.RED);
        
        //Añadimos la elipse al pane
        root.getChildren().add(elipse);
        
        //efecto de fade
        FadeTransition fadeT = new FadeTransition(Duration.seconds(3), elipse);
        fadeT.setFromValue(1.0);
        fadeT.setToValue(0.2);
        
        fadeT.play();
        
        //mientras mantegamos pulsado el raton se pausara la animacion
        elipse.setOnMousePressed(e ->{
            
            fadeT.pause();
        });
        
        //cuando soltemos el raton se iniciara desde el principio
        elipse.setOnMouseReleased(e ->{
            
            fadeT.playFromStart();
        });
        
  
        
        
        //mostramos la ventana
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
