/* This project based on page 109 Java book
    Quan Dang - 12/12/2021
    This project is asking the number of guest for an event of  Carlys Catering.
    And show number of guest, price per guest and total price
    Using the border from class CarlysMotto2

 */
import java.util.Scanner;
import java.text.DecimalFormat; // using Decimal Format
import java.util.*;
import java.text.*;

public class CarlysEventPrice {
    //global varibles
    static Scanner dataInput;
    static DecimalFormat moneyFormat, numFormat;

    //main module
    public static void main(String[] args) {
        CarlysMotto2.output(); // call CarlysMotto2 class in the same project
        init();
        int iGuest = input();
        double cTotal = calcs(iGuest);
        output(iGuest, cTotal);
    }
    // show the ouput to user
    private static void output(int iGuest, double cTotal) {
        final double RATE_PER_PERSON = 35;
        System.out.println("");
        CarlysMotto2.output();

        // Using boolean variable to define the index for event
        boolean eventIndex = (iGuest>49);

        // format output using Decinal Format
        moneyFormat = new DecimalFormat("$ ##,###.00");
        numFormat = new DecimalFormat("#,###");
        String oGuest = numFormat.format(iGuest);
        String oTotal = moneyFormat.format(cTotal);
        String oPricePerPerson = moneyFormat.format(RATE_PER_PERSON);

        //Using printf to show the ourput
        System.out.printf("%-25s%5s%-25s%5s%-15s%5s%-15s\n",
                "Number of Guests", " ", "Price per Person", " ", "Total Cost", " ", "Large Event");
        System.out.printf("%-25s%7s%-24s%5s%-15s%5s%-15s\n",
                oGuest, " ", oPricePerPerson, " ", oTotal, " ", eventIndex);
    }

    // Calcalate the cost of event
    private static double calcs(int iGuest) {
        final double RATE_PER_PERSON = 35;
        double cTotal = iGuest * RATE_PER_PERSON;
        return cTotal;
    }

    private static int input() {
        int iGuest;
        System.out.println("Enter the number of guest for your event: ");
        String iData = dataInput.nextLine();
        //Get the number of guest from users
        try {
            iGuest = Integer.parseInt(iData);
        }
        catch (Exception e){
            System.out.println("Number of guest must be a valid integer");
            System.out.println("Using a zero instead");
            iGuest = 0;
        }
        return iGuest;
    }
    private static void init() {
        dataInput = new Scanner(System.in);
    }

}
