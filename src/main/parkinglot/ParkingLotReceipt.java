package parkinglot;
import java.util.UUID;

public class ParkingLotReceipt {
    private final String receipt;
    public ParkingLotReceipt() {
        receipt = UUID.randomUUID().toString();
    }
}
