package fr.epu.bicycle;

import java.util.Locale;
import java.util.Scanner;

/**
 * EBike implements the computer part of an EBike that would have a battery and a location.
 *
 * @author M. Blay-Fornarino
 */
public class EBike extends ElectricVehicle {
    static final int INITIAL_DISTANCE = 1;

    /**
     * Default constructor
     * The distance covered by an Ebike at its creation is INITIAL_DISTANCE.
     */
    public EBike() {
        super();
        km = INITIAL_DISTANCE;
    }

    public static void main(String[] args) {
        EBike e1 = new EBike();
        final String STOP = "s";
        String stop = "f";
        Scanner keyboard = new Scanner(System.in);
        keyboard.useLocale(Locale.US);//To read the doubles with . and not ,

        while (!STOP.equals(stop)) {
            System.out.print("\t What distance did you travel in km or miles ? ");
            if (keyboard.hasNextDouble()) {
                double newDistance = keyboard.nextDouble();//reading a double
                // check if the distance is in km or in miles
                if (keyboard.hasNext("mi")) {
                    newDistance = milesToKm(newDistance);
                }

                e1.addKm(newDistance);
                keyboard.nextLine();
                System.out.printf("\t Your bike has therefore travelled %f km or %f mi%n", e1.getKm(), kmToMiles(e1.getKm()));
            } else {
                System.out.println("\t a number is expected for example  1 or 1.5 ");
            }
            System.out.print("Do you want to continue or stop (" + STOP + ") ? ");
            stop = keyboard.nextLine();
        }

    }

}