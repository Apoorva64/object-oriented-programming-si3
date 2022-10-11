package fr.epu.bicycle;

public class BorrowableElectricVehicle extends ElectricVehicle implements Borrowable {
    private boolean borrowed = false;

    public BorrowableElectricVehicle(Battery battery, GPS gps) {
        super(battery, gps);
    }


    @Override
    public void borrow() {
        if (this.getChargePercent() < 20) {
            throw new IllegalStateException("The vehicle is not charged enough");
        }

        if (borrowed) {
            throw new IllegalStateException("Bike already borrowed");
        }
        borrowed = true;
    }


    @Override
    public void returnBorrowable() {
        if (!borrowed) {
            throw new IllegalStateException("Bike already returned");
        }
        borrowed = false;

    }
}

