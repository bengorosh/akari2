package com.comp301.a09akari.view;

import com.comp301.a09akari.controller.AlternateMvcController;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;


public class MessageView implements FXComponent {
  private AlternateMvcController controller;
  private AnchorPane aPane;
  public MessageView(AlternateMvcController controller) {
    this.controller=controller;
    this.aPane = new AnchorPane();
  }
  public void callRender(){
    if(controller.isSolved()){
      render();
    }
  }

  // show the "success" message when the user successfully finishes the puzzle

  @Override
  public Parent render() {
    aPane.getChildren().clear();
    return aPane;
  }
}
