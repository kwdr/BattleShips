package battleShips;

public abstract class Warship implements Ship {

    enum Orientation {
        HORIZONTAL, VERTICAL
    }

    private Orientation orientation;
    private int hits;
    private Field[] occupied;

    public Warship(Orientation orientation) {
        this.orientation = orientation;
        occupied = new Field[getDecksCount()];
    }

    @Override
    public boolean isSunk() {
        return hits == getDecksCount();
    }

    public void setOnField(Field field, int deckNo) {

        field.setShip(this);
        field.setState(State.SHIP);
        occupied[deckNo] = field;
    }

    @Override
    public void hit() {
        hits++;
        if(isSunk()) {
            for (int i = 0; i < occupied.length; i++) {
                occupied[i].setState(State.SUNK);
            }
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }
}

class Submarine extends Warship {

    public Submarine(Orientation orientation) {
        super(orientation);
    }

    public Submarine() {
        this(Orientation.HORIZONTAL);
    }

    @Override
    public int getDecksCount() {
        return 1;
    }
}

class Destoyer extends Warship {

    public Destoyer(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 2;
    }
}

class Cruiser extends Warship {

    public Cruiser(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 3;
    }
}

class BattleShip extends Warship {

    public BattleShip(Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getDecksCount() {
        return 4;
    }
}