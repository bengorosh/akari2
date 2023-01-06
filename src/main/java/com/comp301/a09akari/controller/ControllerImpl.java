package com.comp301.a09akari.controller;

import com.comp301.a09akari.model.Model;
import com.comp301.a09akari.model.Puzzle;

import java.util.concurrent.ThreadLocalRandom;

public class ControllerImpl implements AlternateMvcController {
  private final Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  /*Most of the Controller methods will simply be delegated/forwarded
  directly to the encapsulated Model instance. However, a few methods
  like clickNextPuzzle(), clickPrevPuzzle(), and clickRandPuzzle() may
  require a few lines of code to correctly control the model.*/

  @Override
  public void clickNextPuzzle() {
    int i = this.model.getActivePuzzleIndex() + 1;
    if (i < this.model.getPuzzleLibrarySize()) {
      this.model.setActivePuzzleIndex(i);
    }
  }

  @Override
  public void clickPrevPuzzle() {
    int i = this.model.getActivePuzzleIndex() - 1;
    if (i >= 0) {
      this.model.setActivePuzzleIndex(i);
    }
  }

  @Override
  public void clickRandPuzzle() {
    int Min = 0;
    int Max = this.model.getPuzzleLibrarySize();
    int i = ThreadLocalRandom.current().nextInt(Min, Max);
    this.model.setActivePuzzleIndex(i);
  }

  @Override
  public void clickResetPuzzle() {
    this.model.resetPuzzle();
  }

  @Override
  public void clickCell(int r, int c) {
    // maybe make a click variable for each cell to see how many times it's been clicked?
    // add 1 for each click; for each even click & 0 remove lamp; for each odd click ass lamp
    if(model.isLamp(r,c)){
      model.removeLamp(r,c);
    }else{
      model.addLamp(r,c);
    }
    // if clicked again, remove the lamp
  }

  @Override
  public boolean isLit(int r, int c) {
    return this.model.isLit(r, c);
  }

  @Override
  public boolean isLamp(int r, int c) {
    return this.model.isLamp(r, c);
  }

  @Override
  public boolean isClueSatisfied(int r, int c) {
    return this.model.isClueSatisfied(r, c);
  }

  @Override
  public boolean isSolved() {
    return this.model.isSolved();
  }

  @Override
  public Puzzle getActivePuzzle() {
    return this.model.getActivePuzzle();
  }
}
