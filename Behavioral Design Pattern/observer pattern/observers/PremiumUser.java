package observers;

import java.util.Scanner;

import subjects.ABCServer;

public class PremiumUser extends Observer {
    /* state = 1(operational), 2(partially using ABC and DEF), 3(fully using DEF) */

    public PremiumUser(ABCServer abcServer, String name) {
        super(abcServer, name);
    }

    @Override
    public void notifyObserver() {
        if(getSubject() == null) {
            return ;  // observer is not subscribed currently
        }

        int previous = getSubject().getPreviousState();
        int current = getSubject().getCurrentState();

        Scanner scanner = new Scanner(System.in);
        String input;  // NOTICE
        int choice;

        System.out.println("\n\t"+">> "+this+" notified");

        if(previous==1 && current==2) {
            System.out.println("\n\t"+"options:-");
            System.out.println("\t"+"1. use service from two servers(ABC, DEF)");
            System.out.println("\t"+"2. use service from one server(DEF)");

            System.out.print("\n\t"+"choice(1/2): ");
            choice = scanner.nextInt();
            input = scanner.nextLine();

            if(choice == 1) {
                setState(2);
            } else if(choice == 2) {
                setState(3);
            } else {
                System.out.println("\n\t"+"invalid choice given, choosing option(2)");  // NOTICE
                setState(3);
            }

        } else if(previous==1 && current==3) {
            setState(3);

        } else if(previous==2 && current==3) {
            if(getState() == 2) {
                setState(3);
            }

        } else if((previous==2 || previous==3) && current==1) {
            setState(1);

        } else if(previous==3 && current==2) {
            /* do nothing */
        } else {
            /* do nothing, unlikely case */
        }

        update();

        return ;
    }

    @Override
    public void update() {
        if(getState() == 1) {
            System.out.println("\n\t"+">> using ABC server"+"\n");

        } else if(getState() == 2) {
            System.out.println("\n\t"+">> using both ABC and DEF servers"+"\n");

        } else if(getState() == 3) {
            System.out.println("\n\t"+">> using DEF server"+"\n");

        } else {
            /* do nothing, unlikely case */
        }

        return ;
    }

    /* additional */
    @Override
    public String toString() {
        return getName()+"(premium user)";
    }
}
