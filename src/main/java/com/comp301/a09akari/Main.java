package com.comp301.a09akari;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.*;
import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) {
    Model model = new ModelImpl(PuzzleLibrary);
    AlternateMvcController controller = new ControllerImpl();


  }
}