package shakeshack;

import java.util.List;
import java.util.ArrayList;

import items.*;

public class Order {
    private List<Item> itemList;

    public Order() {
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
        return ;
    }

    public int getCost() {
        int cost = 0;

        for(Item item: itemList) {
            cost += item.getPrice();
        }

        return cost;
    }

    public String getOrderInfo() {
        return itemList.get(0).getName() + "(total price: " + getCost() + " taka)";  // returning milkshake info
    }

    public void printOrder() {
        /* NOTICE: print() function (pdf) */
        Item temp = null;

        int candyCount = 0;
        int cookieCount = 0;

        for(Item item: itemList) {
            if(item.getName().equals("candy")) {
                candyCount++;
            } else if(item.getName().equals("cookie")) {
                cookieCount++;
            } else {
                /* milkshake */
                System.out.println(item.getName() + " (" + item.getIngredient() + ")");
                System.out.print("<price> " + item.getPrice() + " taka");

                Milkshake milkshake = (Milkshake) item;  // NOTICE

                if(milkshake.getIsLactoseFree() == true) {
                    System.out.println(" (increased price for almond milk)");
                } else {
                    System.out.println("");
                }
            }
        }

        if(candyCount != 0) {
            temp = new Candy();  // NOTICE

            System.out.println(temp.getName() + " x " + candyCount);
            System.out.println("<price> (" + temp.getPrice() + "x" + candyCount + ") " + temp.getPrice()*candyCount + " taka");
        }

        if(cookieCount != 0) {
            temp = new Cookie();  // NOTICE

            System.out.println(temp.getName() + " x " + cookieCount);
            System.out.println("<price> (" + temp.getPrice() + "x" + cookieCount + ") " + temp.getPrice()*cookieCount + " taka");
        }

        System.out.println("\n" + "<<total price>> " + getCost() + " taka");

        return ;
    }
}
