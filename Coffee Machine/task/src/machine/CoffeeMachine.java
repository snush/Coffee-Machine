package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] resources = {400, 540, 120, 9, 550};

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): \n");
            String actions = scanner.nextLine();
            if (actions.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                        "back - to main menu: ");
                String coffee = scanner.next();
                if (coffee.equals("back")) {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                            "back - to main menu: ");
                    coffee = scanner.next();
                }
                switch (coffee) {
                    case "1":
                        int[] espresso = {250, 0, 16, 1, 4};
                        resources = buy(resources, espresso);
                        break;
                    case "2":
                        int[] latte = {350, 75, 20, 1, 7};
                        resources = buy(resources, latte);
                        break;
                    case "3":
                        int[] cappuccino = {200, 100, 12, 1, 6};
                        resources = buy(resources, cappuccino);
                        break;
                    default:
                        break;
                }
            } else if (actions.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add: ");
                int addWater = scanner.nextInt();

                System.out.println("Write how many ml of milk do you want to add: ");
                int addMilk = scanner.nextInt();

                System.out.println("Write how many grams of coffee beans do you want to add: ");
                int addBeans = scanner.nextInt();

                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                int addCups = scanner.nextInt();

                int[] add = {addWater, addMilk, addBeans, addCups};
                resources = fill(resources, add);
            } else if (actions.equals("take")) {
                resources = take(resources);
            } else if (actions.equals("remaining")) {
                remaining(resources);
            } else if (actions.equals("exit")) {
                break;
            }
        }
    }
     static int[] buy(int[] resource, int[] varieties) {
        if(resource[0] < varieties[0]) {
            System.out.println("Sorry, not enough water!");
        } else if (resource[1] < varieties[1]) {
            System.out.println("Sorry, not enough milk!");
        } else if (resource[2] < varieties[2]) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (resource[3] < varieties[3]) {
            System.out.println("Sorry, not enough cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            resource[0] -= varieties[0];
            resource[1] -= varieties[1];
            resource[2] -= varieties[2];
            resource[3] -= varieties[3];
            resource[4] += varieties[4];
        }
        return resource;
    }
    static int[] fill(int[] resource, int[] add) {
        resource[0] += add[0];
        resource[1] += add[1];
        resource[2] += add[2];
        resource[3] += add[3];
        return resource;
    }
    static int[] take(int[] resources) {
        System.out.println("I gave you $" + resources[4]);
        resources[4] = 0;
        return resources;
    }
    static void remaining(int[] resources) {
        System.out.println("The coffee machine has:");
        System.out.println(resources[0] + " of water");
        System.out.println(resources[1] + " of milk");
        System.out.println(resources[2] + " of coffee beans");
        System.out.println(resources[3] + " of disposable cups");
        System.out.println("$" + resources[4] + " of money");
    }
}

