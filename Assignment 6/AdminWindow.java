// Jack Palmstrom       ccc username: jnpalmstrom
// Haiau Duong          ccc username: hkduong

// -------------------------------------------- Imports ------------------------------------------------------------- //

import java.util.Scanner;

// ------------------------------------------------------------------------------------------------------------------ //

class AdminWindow {
    SearchEngine s;
    Scanner keyboard = new Scanner(System.in);

    AdminWindow(SearchEngine s) {
        this.s = s;
    }

    public void adminScreen() throws InvalidRateException, LowerRateException {
        System.out.println("-------------------------------------");
        System.out.println("Enter a sponsor name (or done to exit)");
        String choice = keyboard.next();
        // eat up the rest of the line
        keyboard.nextLine();

        // Problem 2.4.1 - Step 4: Catching Exceptions

        try {
            if (choice.equals("done"))
                System.out.println("Existing admin operations");
            else {
                System.out.println("Enter sponsor's price per page hit (as a double)");
                String rateString = keyboard.next();
                Double rate = Double.parseDouble(rateString);
                s.updateSponsor(choice, rate);
                adminScreen();
            }
        } catch (InvalidRateException e) {
            System.out.println("Login Failed. Try Again");
            adminScreen();
        } catch (LowerRateException e) {
            System.out.println("Login Failed. Try Again");
            adminScreen();
        }
    }
}