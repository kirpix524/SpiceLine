package ru.dubki.spicesline.controller.interfaces;

public interface ControlCenterGUIInterface {
    void addConveyor(int size);
    void makeConveyorStep(int conveyorNumber);
    void moveAllConveyors();
    void fillAllCells();
}
