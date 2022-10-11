package fr.epu.bicycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BorrowableElectricVehicleTest {

    @Test
    void borrow() {
        BorrowableElectricVehicle vehicle = new BorrowableElectricVehicle(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
    }

    @Test
    void returnBorrowable() {
        BorrowableElectricVehicle vehicle = new BorrowableElectricVehicle(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
        vehicle.returnBorrowable();
    }

    @Test
    void borrowNotEnoughCharge() {
        BorrowableElectricVehicle vehicle = new BorrowableElectricVehicle(new Battery(10), new GPS());
        assertThrows(IllegalStateException.class, vehicle::borrow);
    }

    @Test
    void borrowAlreadyBorrowed() {
        BorrowableElectricVehicle vehicle = new BorrowableElectricVehicle(new Battery(50), new GPS());
        vehicle.charge(50);
        vehicle.borrow();
        assertThrows(IllegalStateException.class, vehicle::borrow);
    }

    @Test
    void returnAlreadyReturned() {
        BorrowableElectricVehicle vehicle = new BorrowableElectricVehicle(new Battery(50), new GPS());
        assertThrows(IllegalStateException.class, vehicle::returnBorrowable);
    }

}