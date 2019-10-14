package observers;

import java.util.Scanner;

import subjects.ABCServer;

public class RegularUser extends Observer {
    /* state = 1(operational), 2(partially using ABC), 3(fully using DEF), 4(no service) */

    public RegularUser(ABCServer abcServer, String name) {
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
            System.out.println("\t"+"1. continue using limited functionality from ABC server");
            System.out.println("\t"+"2. use service from DEF server with $20/hour payment");

            System.out.print("\n\t"+"choice(1/2): ");
            choice = scanner.nextInt();
            input = scanner.nextLine();

            if(choice == 1) {
                setState(2);
            } else if(choice == 2) {
                setState(3);
            } else {
                System.out.println("\n\t"+"invalid choice given, choosing option(1)");  // NOTICE
                setState(2);
            }

        } else if(previous==1 && current==3) {
            System.out.println("\n\t"+"would you like to use service from DEF server with $20/hour payment?");
            System.out.println("\t"+"1. yes");
            System.out.println("\t"+"2. no");

            System.out.print("\n\t"+"choice(1/2): ");
            choice = scanner.nextInt();
            input = scanner.nextLine();

            if(choice == 1) {
                setState(3);
            } else if(choice == 2) {
                setState(4);
            } else {
                System.out.println("\n\t"+"invalid choice given, choosing option(2)");  // NOTICE
                setState(4);
            }

        } else if(previous==2 && current==3) {
            if(getState() == 2) {
                System.out.println("\n\t"+"would you like to use service from DEF server with $20/hour payment?");
                System.out.println("\t"+"1. yes");
                System.out.println("\t"+"2. no");

                System.out.print("\n\t"+"choice(1/2): ");
                choice = scanner.nextInt();
                input = scanner.nextLine();

                if(choice == 1) {
                    setState(3);
                } else if(choice == 2) {
                    setState(4);
                } else {
                    System.out.println("\n\t"+"invalid choice given, choosing option(2)");  // NOTICE
                    setState(4);
                }
            }

        } else if((previous==2 || previous==3) && current==1) {
            if(getState() == 3) {
                System.out.println("\n\t"+">> total bill for using DEF server sent");
            }

            setState(1);

        } else if(previous==3 && current==2) {
            if(getState() == 4) {
                System.out.println("\n\t"+"would you like to use limited functionality from ABC server?");
                System.out.println("\t"+"1. yes");
                System.out.println("\t"+"2. no");

                System.out.print("\n\t"+"choice(1/2): ");
                choice = scanner.nextInt();
                input = scanner.nextLine();

                if(choice == 1) {
                    setState(2);
                } else if(choice == 2) {
                    // do nothing
                } else {
                    System.out.println("\n\t"+"invalid choice given, choosing option(2)");  // NOTICE
                    // do nothing
                }
            }

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
            System.out.println("\n\t"+">> using limited functionality from ABC server"+"\n");

        } else if(getState() == 3) {
            System.out.println("\n\t"+">> data copied to DEF server, DEF server running"+"\n");

        } else if(getState() == 4) {
            System.out.println("\n\t"+">> no service currently, will be notified later"+"\n");

        } else {
            /* do nothing, unlikely case */
        }

        return ;
    }

    /* additional */
    @Override
    public String toString() {
        return getName()+"(regular user)";
    }
}
