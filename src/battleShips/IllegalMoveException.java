package battleShips;

public class IllegalMoveException extends Exception {

    public IllegalMoveException(String message) {
        super(message);
    }
}