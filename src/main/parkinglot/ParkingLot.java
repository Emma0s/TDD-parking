package parkinglot;

import exception.NoAvailableReceiptException;
import exception.NoAvailableParkingLotException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    protected int totalSpace;
    protected final Map<ParkingLotReceipt,Car> parkingLotReceipts = new HashMap<>();

    public ParkingLot(int totalSpace) {
        this.totalSpace = totalSpace;
    }

    public ParkingLotReceipt park(Car car) {
        if (hasAvailableParkingLot()){
            return giveReceipt(car);
        } else {
            throw new NoAvailableParkingLotException("当前可用车位为0！");
        }

    }
    public Car get(ParkingLotReceipt receipt) {
        if (receipt == null || !isValidReceipt(receipt)){
            throw new NoAvailableReceiptException("票据验证失败！");
        }
        return parkingLotReceipts.remove(receipt);
    }

    private ParkingLotReceipt giveReceipt(Car car){
        ParkingLotReceipt receipt = new ParkingLotReceipt();
        parkingLotReceipts.put(receipt,car);
        return receipt;
    }

    public boolean hasAvailableParkingLot(){
        if (totalSpace - parkingLotReceipts.size() > 0) return true;
        return false;
    }

    public boolean isValidReceipt(ParkingLotReceipt receipt){
        return parkingLotReceipts.containsKey(receipt);
    }
}
