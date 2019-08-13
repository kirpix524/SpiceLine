package ru.dubki.spicesline.model.conveyor.clases;

import ru.dubki.spicesline.exceptions.CellNotFoundException;
import ru.dubki.spicesline.exceptions.IllegalInitialiseParameters;
import ru.dubki.spicesline.model.box.interfaces.BoxInterface;
import ru.dubki.spicesline.model.cell.interfaces.CellInterface;
import ru.dubki.spicesline.model.conveyor.interfaces.ConveyorBeltInterface;

public class ConveyorBelt implements ConveyorBeltInterface {
    private final int id;
    private final int number;
    private final int size;
    private CellInterface[] cells;

    public ConveyorBelt(int id, int size) {
        if (id < 0) {
            throw new IllegalInitialiseParameters("id must be>=0");
        }
        if (size < 1) {
            throw new IllegalInitialiseParameters("size must be >=1");
        }
        this.id=id;
        this.size = size;
        this.number = id+1;
        init(new CellInterface[size]);
    }

    private void init(CellInterface[] cells) {
        this.cells = cells;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public BoxInterface pushBox(BoxInterface insertedBox) {
        return null;
    }

    @Override
    public CellInterface getCellByNumber(int cellNumber) throws CellNotFoundException {
        if (cellNumber<0) {
            throw new IllegalArgumentException("cellNumber must be >0");
        }
        for (int i=0; i<size; i++) {
            if (cells[i].getNumber()==cellNumber) {
                return cells[i];
            }
        }
        throw new CellNotFoundException("cell "+cellNumber+" not found in conveyor "+getId());
    }

    @Override
    public CellInterface[] getCells() {
        return cells;
    }
}
