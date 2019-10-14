package main;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import subjects.ABCServer;
import observers.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Observer> detachedUsers = new ArrayList<>();

    private static ABCServer abcServer = new ABCServer();

    public static String getServerState(int state) {
        if(state == 1) {
            return "operational";
        } else if(state == 2) {
            return "partially down";
        } else if(state == 3) {
            return "fully down";
        } else {
            return "-";
        }
    }

    public static void main(String[] args) {
        String type, name;
        int choice;

        while(true) {
            System.out.println("<< menu >>");
            System.out.println("previous state: "+getServerState(abcServer.getPreviousState()));
            System.out.println("Current state: "+getServerState(abcServer.getCurrentState()));
            System.out.println("\n"+"options:-");
            System.out.println("1. add user");
            System.out.println("2. remove user");
            System.out.println("3. change server state");
            System.out.println("4. exit");

            System.out.print("\n"+"choice(1/2/3/4): ");
            choice = scanner.nextInt();
            type = scanner.nextLine();

            if(choice == 1) {
                if(abcServer.getCurrentState() != 1) {
                    System.out.println("\n"+"operation failed, server not operational"+"\n");
                    continue;
                }

                System.out.println("\n"+"options:-");
                System.out.println("1. add new user");
                System.out.println("2. add from previous user");

                System.out.print("\n"+"choice(1/2): ");
                choice = scanner.nextInt();
                type = scanner.nextLine();

                if(choice == 1) {
                    System.out.print("\n"+"enter name: ");
                    name = scanner.nextLine();
                    System.out.print("\n"+"enter type(premium/regular): ");
                    type = scanner.nextLine();

                    if(type.equalsIgnoreCase("premium")) {
                        new PremiumUser(abcServer, name);
                    } else if(type.equalsIgnoreCase("regular")) {
                        new RegularUser(abcServer, name);
                    } else {
                        System.out.println("\n"+"invalid type given, try again..."+"\n");
                    }

                } else if(choice == 2) {
                    if(detachedUsers.size() == 0) {
                        System.out.println("\n"+"no previous user"+"\n");
                        continue;
                    }

                    System.out.println("\n"+"previous users:- ");

                    for(int i=0; i<detachedUsers.size(); i++) {
                        System.out.println((i+1)+". "+detachedUsers.get(i));
                    }

                    System.out.print("\n"+"choice: ");
                    choice = scanner.nextInt();
                    type = scanner.nextLine();

                    if(choice<1 || choice>detachedUsers.size()) {
                        System.out.println("\n"+"invalid choice given, try again..."+"\n");
                    } else {
                        detachedUsers.get(choice-1).setSubject(abcServer);  // subscribe user
                        abcServer.attach(detachedUsers.get(choice-1));
                        detachedUsers.remove(choice-1);
                    }

                } else {
                    System.out.println("\n"+"invalid choice given, try again..."+"\n");
                }

            } else if(choice == 2) {
                if(abcServer.getCurrentState() != 1) {
                    System.out.println("\n"+"operation failed, server not operational"+"\n");
                    continue;
                }

                if(abcServer.getListSize() == 0) {
                    System.out.println("\n"+"no current user"+"\n");
                    continue;
                }

                System.out.println("\n"+"current users:- ");

                for(int i=0; i<abcServer.getListSize(); i++) {
                    System.out.println((i+1)+". "+abcServer.getUser(i));
                }

                System.out.print("\n"+"choice: ");
                choice = scanner.nextInt();
                type = scanner.nextLine();

                if(choice<1 || choice>abcServer.getListSize()) {
                    System.out.println("\n"+"invalid choice given, try again..."+"\n");
                } else {
                    abcServer.getUser(choice-1).setSubject(null);  // unsubscribe user
                    detachedUsers.add(abcServer.getUser(choice-1));
                    abcServer.detach(abcServer.getUser(choice-1).getName());
                }

            } else if(choice == 3) {
                System.out.println("\n"+"options:-");
                System.out.println("1. operational");
                System.out.println("2. partially down");
                System.out.println("3. fully down");

                System.out.print("\n"+"choice(1/2/3): ");
                choice = scanner.nextInt();
                type = scanner.nextLine();

                if(choice == abcServer.getCurrentState()) {
                    System.out.println("\n"+"same state chosen, try again..."+"\n");
                    continue;
                }

                if(choice==1 || choice==2 ||choice==3) {
                    abcServer.setCurrentState(choice);
                    System.out.println("");
                } else {
                    System.out.println("\n"+"invalid state given, try again..."+"\n");
                }

            } else if(choice == 4) {
                System.out.println("\n"+"exiting...");
                break;

            } else {
                System.out.println("\n"+"invalid choice given, try again..."+"\n");
            }
        }

        return ;
    }
}
