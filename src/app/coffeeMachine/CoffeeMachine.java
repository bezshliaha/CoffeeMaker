package app.coffeeMachine;

import java.util.Scanner;
import app.drinks.*;

public class CoffeeMachine {
    private static final String MENU = "Choose a drink:\n1 - Espresso\n2 - Capuccino\n3 - Latte";

    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println(MENU);

        Coffee coffee = null;

        while (coffee == null) {
            String choiceStr = getUserChoice(sc);
            coffee = createCoffee(choiceStr);
        }

        coffee.makeCoffee();
    }

    private static String getUserChoice(Scanner sc) {
        System.out.print("Enter choice: ");
        return sc.nextLine();
    }

    private static Coffee createCoffee(String choiceStr) {
        switch (choiceStr) {
            case "1" -> {
                return new Espresso();
            }
            case "2" -> {
                return new Cappuccino();
            }
            case "3" -> {
                return new Latte();
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                return null;
            }
        }
    }
}