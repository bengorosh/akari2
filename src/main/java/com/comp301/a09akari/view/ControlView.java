package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import com.comp301.a09akari.controller.ControllerImpl;
import com.comp301.a09akari.model.Model;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlView implements FXComponent /*does it implement FXcomponrnt?*/{
  private Button nextButton;
  private Button prevButton;
  private Button randButton;
  private Button resetButton;
  private HBox buttonContainer;
  private AlternateMvcController controller;

  public ControlView(AlternateMvcController controller) {
    this.nextButton = new Button();
    this.prevButton = new Button();
    this.randButton = new Button();
    this.resetButton = new Button();
    this.buttonContainer = new HBox();
    this.controller = controller;
  }
  // display the puzzle controls, including buttons, to move through the puzzle library



  @Override
  public Parent render() {
    buttonContainer.getChildren().clear();
    return buttonContainer;
  }
}
