package TD6;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * A class to arrange train configuration
 */
public class TrainManagement {

    private int[] from; // the initial ordering
    private int[] to;   // the final ordering

    private ArrayStack<Integer> fromStack;
    private ArrayStack<Integer> toStack;

    /**
     * Build a TrainManagement object
     * Preconditions:
     * 'from' and 'to' have the same size N and are
     * both permutations of [ 0, 1, 2,..., N-1 ]
     */
    public TrainManagement(int[] from, int[] to) {
        this.from = from;
        this.to = to;
        this.fromStack = new ArrayStack<>();
        this.toStack = new ArrayStack<>();

        for (int i = from.length - 1; i >= 0; i--) {
            fromStack.push(from[i]);
            toStack.push(to[i]);
        }
    }

    /**
     * Output the basic move commands to transfer
     * the cars from the 'from' order on track U
     * to the 'to' order on track S
     */
    public void arrange() throws java.util.EmptyStackException, TD6.EmptyStackException {
		List<Integer> toList = new LinkedList<>();
		for (int j : to) {
			toList.add(j);
		}

		while (!fromStack.isEmpty()) {
			int car = fromStack.pop();
			if (car == toStack.peek()) {
				toStack.pop();
				toList.remove(0);
			} else {
				int index = toList.indexOf(car);
				if (index == 0) {
					System.out.println("Move car " + car + " from U to S");
					toStack.pop();
					toList.remove(0);
				} else {
					System.out.println("Move car " + car + " from U to T");
					fromStack.push(toStack.pop());
					toList.remove(0);
				}
			}
		}

    }

    /**
     * Display the basic command (message) for moving
     * the car 'car' from tack 'from' to track 'to'
     */
    private void display(int car, String from, String to) {
        System.out.println("move car " + car + " from " + from + " to " + to);
    }

    ////////////////////////////////////

    /**
     * Checks if the array 'track' is a legal track
     * i.e. is a permutation of [ 0, 1, 2,..., N-1 ]
     * where N = track.length
     */
    private static boolean notApermutation(int[] track) {
        boolean[] check = new boolean[track.length];

        for (int j : track)
            if (j < 0 || j >= track.length || check[j])
                return true;
            else
                check[j] = true;
        return false;
    }


    @SuppressWarnings("resource")
    private static int[] readTrack(Scanner input, String prompt) {
        List<Integer> list = new LinkedList<>();
        System.out.print(prompt);
        Scanner scan = new Scanner(input.nextLine());
        while (scan.hasNextInt())
            list.add(scan.nextInt());
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * An interactive main for testing.
     */
    public static void main(String[] args) throws TD6.EmptyStackException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to the Train arrangement program\n");
        while (true) {
            int[] from = readTrack(keyboard, "\nEnter the 'from' track (just enter to exit): ");
            if (from.length == 0)
                break;
            if (notApermutation(from)) {
                System.out.println("bad track!");
                continue;
            }
            int[] to = readTrack(keyboard, "Enter the 'to' track: ");
            if (notApermutation(to)) {
                System.out.println("bad track!");
                continue;
            }
            if (from.length != to.length) {
                System.out.println("the 'from' and 'to' tracks don't have the same size!");
                continue;
            }
            try {
                (new TrainManagement(from, to)).arrange();
            } catch (EmptyStackException ese) {
                System.out.println("oops! EmptyStackException");
            }
        }
        System.out.println("\nThank you for using the Train arrangement program");
    }
}
