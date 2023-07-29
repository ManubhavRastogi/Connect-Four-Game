package com.manubhavRastogi.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.print.PageLayout;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
        private MenuBar createMenu(){

        //File Menu

            Menu fileMenu = new Menu("File");

            MenuItem newGame = new MenuItem("New Game");
            newGame.setOnAction(event -> controller.resetGame());
            MenuItem resetGame = new MenuItem("Reset Game");
            resetGame.setOnAction(event -> controller.resetGame());
            SeparatorMenuItem seperatorMenuItem = new SeparatorMenuItem();
            MenuItem exitGame = new MenuItem("Exit Game");
            exitGame.setOnAction(event -> exitGame());

            fileMenu.getItems().addAll(newGame,resetGame,seperatorMenuItem,exitGame);

        //Help menu

            Menu helpMenu = new Menu("Help");

            MenuItem aboutGame = new MenuItem("About Game");
            aboutGame.setOnAction(event -> aboutConnect4());
            SeparatorMenuItem seperatorHelpItem = new SeparatorMenuItem();
            MenuItem aboutMe = new MenuItem("About Me");
            aboutMe.setOnAction(event -> aboutMe());


            helpMenu.getItems().addAll(aboutGame,seperatorHelpItem,aboutMe);

            MenuBar menuBar = new MenuBar();
            menuBar.getMenus().addAll(fileMenu,helpMenu);

            return menuBar;
        }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Manubhav Rastogi");
        alert.setContentText("I love to play around with code and create games." +
                "Connect 4 is one of them. I hope you will enjoy this game and if you want u can check out my other projects on my Github." +
                "Have a Nice Day ❤ ");
        alert.show();

    }

    private void aboutConnect4() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Connect Four");
            alert.setHeaderText("How to Play?");
            alert.setContentText("Connect Four is a two-player connection game in which the" +
                    "player first choose a color and then take turns dropping colored discs" +
                    "from the top into a seven-column, six-row vertically suspended grid. " +
                    "The pieces fall straight down, occupying the next available space within the column. " +
                    "The objective of the game is to be the first to form a horizontal, vertical, " +
                    "or diagonal line of four of one's own discs. Connect Four is a solved game. " +
                    "The first player can always win by playing the right moves." +
                    "ENJOY THE GAME");
            alert.show();
    }


    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
            //Todo

    }


    public static void main(String[] args) {
        launch(args);
    }
}
