package ru.dubki.spicesline.model.cell.interfaces;

import ru.dubki.spicesline.model.box.interfaces.BoxInterface;

public interface CellInterface {
    int getNumber();
    int getID();
    void insertBox(BoxInterface newBox);
    void removeBox();
    BoxInterface getBox();
}
