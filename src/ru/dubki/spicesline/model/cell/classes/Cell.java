package ru.dubki.spicesline.model.cell.classes;

import ru.dubki.spicesline.model.box.interfaces.BoxInterface;
import ru.dubki.spicesline.model.cell.interfaces.CellInterface;
import ru.dubki.spicesline.model.conveyor.interfaces.ConveyorBeltInterface;

public class Cell implements CellInterface {
    int id;
    int number;
    ConveyorBeltInterface conveyor;
    BoxInterface box;

    public Cell(int id, ConveyorBeltInterface conveyor, BoxInterface box) {
        checkConveyor(conveyor);
        init(id, conveyor, box);
    }

    public Cell(int id, ConveyorBeltInterface conveyor) {
        checkConveyor(conveyor);
        init(id, conveyor,null);
    }

    private void init(int id, ConveyorBeltInterface conveyor, BoxInterface box) {
        this.number = id+1;
        this.id = id;
        this.conveyor = conveyor;
        this.box = box;
    }

    private void checkConveyor(ConveyorBeltInterface conveyor) {
        if (conveyor==null) {
            throw new IllegalArgumentException("conveyor must not be null");
        }
    }

    @Override
    public void insertBox(BoxInterface box) {
        if (box==null) {
            throw new IllegalArgumentException("box must not be null");
        }
        this.box = box;
    }

    @Override
    public void removeBox() {
        this.box = null;
    }

    @Override
    public BoxInterface getBox() {
        return box;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getID() {
        return id;
    }
}
