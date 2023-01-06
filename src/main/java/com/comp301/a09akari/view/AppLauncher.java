package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

import static com.comp301.a09akari.SamplePuzzles.*;

public class AppLauncher extends Application {
  @Override
  public void start(Stage stage) {
    Puzzle p1 = new PuzzleImpl(PUZZLE_01);
    Puzzle p2 = new PuzzleImpl(PUZZLE_02);
    Puzzle p3 = new PuzzleImpl(PUZZLE_03);
    Puzzle p4 = new PuzzleImpl(PUZZLE_04);
    Puzzle p5 = new PuzzleImpl(PUZZLE_05);
    ArrayList<Puzzle> puzzles = new ArrayList<Puzzle>(Arrays.asList(p1, p2, p3, p4, p5));
    PuzzleLibrary puzzleLibrary = new PuzzleLibraryImpl();
    for (Puzzle p : puzzles) {
      puzzleLibrary.addPuzzle(p);
    }
    Model model = new ModelImpl(puzzleLibrary); // create model instance
    model.setActivePuzzleIndex(0);
    AlternateMvcController controller = new ControllerImpl(model); // create controller instance
    // private final AlternateMvcController controller;
    //
    //  public View(AlternateMvcController controller) {
    //    this.controller = controller;
    //  }
    PuzzleView pView = new PuzzleView(controller);
    ControlView cView = new ControlView(controller);
    MessageView mView = new MessageView(controller);
    Pane layout = new VBox();
    layout.getStyleClass().add("layout");
    layout.getChildren().addAll(pView.render(), cView.render(), mView.render());
    Scene scene = new Scene(layout, 350, 450);
    scene.getStylesheets().add("style/main.css");
    stage.setScene(scene);
    stage.show();

    // TODO All three of these FXComponent objects could then be instantiated and composed together
    // in the start() method
    // TODO: Create the 3 view instances


    stage.setTitle("Akari Light Up");
  }
}
