package parkinglot;

public class ParkingLot {

    private int freeSpace;
    public ParkingLot(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public ParkingLotReceipt park(Car car) throws NoAvailiableParkinglotException {
        if (freeSpace > 0){
            freeSpace --;
            return new ParkingLotReceipt();
        }
        throw new NoAvailiableParkinglotException();
    }
}
