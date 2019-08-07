package exception;

public class NoAvailableParkingLotException extends RuntimeException {
    public NoAvailableParkingLotException(String s) {
        super(s);
    }
}
