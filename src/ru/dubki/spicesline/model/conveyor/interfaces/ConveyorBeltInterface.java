package ru.dubki.spicesline.model.conveyor.interfaces;

import ru.dubki.spicesline.exceptions.CellNotFoundException;
import ru.dubki.spicesline.model.box.interfaces.BoxInterface;
import ru.dubki.spicesline.model.cell.interfaces.CellInterface;

public interface ConveyorBeltInterface {
    int getNumber();
    int getID();
    BoxInterface pushBox(BoxInterface insertedBox); //inserts box from the beginning of conveyor, returns box, that went off the conveyor at the end
    CellInterface getCellByNumber(int cellNumber) throws CellNotFoundException;
    CellInterface[] getCells();
}
