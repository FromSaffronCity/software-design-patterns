package shakeshack;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import builders.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Order> orderList = new ArrayList<>();

    private static String choice = null;

    public static void produceShake() {
        Director director = null;
        MilkshakeBuilder milkshakeBuilder = null;

        String shakeName = null;
        boolean isLactoseFree;
        int candyCount, cookieCount;

        System.out.print("\n" + "choose among (chocolate/ coffee/ strawberry/ vanilla/ zero) shakes: ");
        shakeName = scanner.nextLine();
        shakeName = shakeName.toLowerCase();

        System.out.print("lactose-free milkshake ? (yes/ no): ");
        choice = scanner.nextLine();
        choice = choice.toLowerCase();

        System.out.print("enter number of candy: ");
        candyCount = scanner.nextInt();
        System.out.print("enter number of cookie: ");
        cookieCount = scanner.nextInt();
        scanner.nextLine(); // NOTICE: for catching extra carraige return

        /* input checking and isLactoseFree setting */
        if(candyCount < 0 || cookieCount < 0) {
            System.out.println("\n" + "invalid number given" + "\n");
            return ;
        }

        if(choice.equals("yes") == true) {
            isLactoseFree = true;
        } else if(choice.equals("no") == true) {
            isLactoseFree = false;
        } else {
            System.out.println("\n" + "invalid choice made" + "\n");
            return ;
        }

        /* placing order */
        if(shakeName.equals("chocolate") == true) {
            milkshakeBuilder = new ChocolateShakeBuilder();
        } else if(shakeName.equals("coffee") == true) {
            milkshakeBuilder = new CoffeeShakeBuilder();
        } else if(shakeName.equals("strawberry") == true) {
            milkshakeBuilder = new StrawberryShakeBuilder();
        } else if(shakeName.equals("vanilla") == true) {
            milkshakeBuilder = new VanillaShakeBuilder();
        } else if(shakeName.equals("zero") == true) {
            milkshakeBuilder = new ZeroShakeBuilder();
        } else {
            System.out.println("\n" + "invalid choice made" + "\n");
            return ;
        }

        director = new Director(milkshakeBuilder);
        director.makeOrder(isLactoseFree, candyCount, cookieCount);
        orderList.add(director.getOrder());

        return ;
    }

    public static void main(String[] args) {
        int orderNo, totalCost = 0;

        while(true) {
            System.out.println("\n" + "press 'O' to open an order");
            System.out.println("press 'C' to cancel order");
            System.out.println("press 'E' to close order");
            System.out.print("your choice: ");

            choice = scanner.nextLine();
            choice = choice.toUpperCase();

            if(choice.equals("O") == true) {
                produceShake();
            } else if(choice.equals("C") == true) {
                System.out.println("");

                if(orderList.size() == 0) {
                    System.out.println("no order placed to be removed");
                    continue;
                }

                for(int i=0; i<orderList.size(); i++) {
                    System.out.println("order #" + (i+1) + ": " + orderList.get(i).getOrderInfo());
                }

                System.out.print("\n" + "no. of order to cancel: ");
                orderNo = scanner.nextInt();
                scanner.nextLine(); // NOTICE: for catching extra carraige return

                if(orderNo<1 || orderNo>orderList.size()) {
                    System.out.println("\n" + "invalid number given" + "\n");
                    continue;
                }

                orderList.remove(--orderNo);
                System.out.println("order removed successfully");
            } else if(choice.equals("E") == true) {
                if(orderList.size() == 0) {
                    System.out.println("\n" + "at least 1 order must be made" + "\n");
                    continue;
                }

                break;
            } else {
                System.out.println("\n" + "wrong button pressed" + "\n");
            }
        }

        /* printing orders */
        System.out.println("\n" + "orders placed:" + "\n");

        for(int i=0; i<orderList.size(); i++) {
            System.out.println("order #" + (i+1));
            orderList.get(i).printOrder();
            System.out.println("");

            totalCost += orderList.get(i).getCost();
        }

        System.out.println("\n" + "<<total cost>> " + totalCost + " taka");

        return ;
    }
}
