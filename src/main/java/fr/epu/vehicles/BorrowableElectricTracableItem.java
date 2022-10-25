package fr.epu.vehicles;

public class BorrowableElectricTracableItem extends ElectricTracableItem implements Borrowable {
    private boolean borrowed = false;

    public BorrowableElectricTracableItem(Battery battery, GPS gps) {
        super(battery, gps);
    }

    @Override
    public boolean isBorrowable() {
        return !borrowed;
    }

    @Override
    public void borrow() {
        if (this.getChargePercent() < 20) {
            throw new IllegalStateException("The vehicle is not charged enough");
        }

        if (borrowed) {
            throw new IllegalStateException("Vehicle already borrowed");
        }
        borrowed = true;
    }


    @Override
    public void returnBorrowable() {
        if (!borrowed) {
            throw new IllegalStateException("Vehicle already returned");
        }
        borrowed = false;

    }
}

