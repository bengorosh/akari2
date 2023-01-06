package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.model.CellType;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PuzzleView
    implements FXComponent { // display the clues and the game board inside a GridPanel; CORRECT
  private AlternateMvcController controller;
  private GridPane gameBoard;
  public PuzzleView(AlternateMvcController controller) {
    this.controller = controller;
    this.gameBoard = new GridPane();
    }

    //this.gameBoard.getStyleClass().add("layout");
  @Override
  public Parent render() {
    gameBoard.getChildren().clear();
    for (int h = 0; h < controller.getActivePuzzle().getHeight(); h++) {
      for (int w = 0; w < controller.getActivePuzzle().getWidth(); w++) {
        if (controller.getActivePuzzle().getCellType(h, w) == CellType.CORRIDOR) {
          gameBoard.add(makeTile(0), h, w);
        } else if (controller.getActivePuzzle().getCellType(h, w) == CellType.CLUE) {
          gameBoard.add(makeTile(controller.getActivePuzzle().getClue(h, w)), h, w);
        } else { // if cell is a wall
          gameBoard.add(makeTile(5), h, w);
        }
      }
    }
    return gameBoard;
  }

  private static Label makeTile(int num) {
    Label tile;
    if (num == 0) {
      tile = new Label();
    } else if (num >= 0 && num <= 4) {
      tile = new Label(String.valueOf(num));
    } else {
      tile = new Label("/U+25A0");
    }
    // use lambda functions to set actions on the click - turn lamps on or off
    // set sizes of the labels
    // tile.getStyleClass().add("tile");
    // tile.getStyleClass().add("tile-" + num);
    return tile;
  }

  /*@Override
    //set gaps, styleclass,
    int i;
    int j;
    for(i=0; i < controller.getActivePuzzle().getHeight(); i++){
      for(j = 0; j < controller.getActivePuzzle().getWidth(); j++){
        gameBoard.add(makeTile(j,i), j, i);
      }
    }
    //add gameboard to a pane, add button
  }*/
  //render makes a board depending on the state of the controller.
  // When the model changes, it calls render, which remakes it.

}
