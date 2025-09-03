package elevator;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import elevator.Elevator;
import elevator.Request;
import elevator.RequestQueue;
import elevator.BooleanSource;
import elevator.EmptyQueueException;
import elevator.Simulator;

/**
 * Contains the main method which prompts the user for the 4 parameters needed for the simulation.
 */
public class Analyzer {
    public static void main(String[] args) throws EmptyQueueException {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Welcome to the Elevator Simulator");
            System.out.print("\n\nPlease enter the probability of arrival for Requests: ");
            double probability = input.nextDouble();
            if (probability < 0.0 || probability > 1.0) {
                throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
            }
            System.out.print("Please enter the number of floors: ");
            int floors = input.nextInt();
            if (floors < 1) {
                throw new IllegalArgumentException("Number of floors must be greater than 1");
            }
            System.out.print("Please enter the number of elevators: ");
            int numberOfElevators = input.nextInt();
            if (numberOfElevators < 1) {
                throw new IllegalArgumentException("Number of elevators must be greater than 0");
            }
            System.out.print("Please enter the length of the simulator (int time units):  ");
            int length = input.nextInt();
            if (length < 1) {
                throw new IllegalArgumentException("Length must be greater than 0");
            }

            Simulator sim = new Simulator();

            sim.simulate(probability, floors, numberOfElevators, length);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }


}