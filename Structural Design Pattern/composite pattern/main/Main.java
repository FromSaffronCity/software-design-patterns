package main;

import java.util.Scanner;
import entities.*;

public class Main {
    private static BaseEntity root;
    private static BaseEntity current;

    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    private static int choice;

    public static void createEntity() {
        System.out.print("\n"+"enter name: ");
        input = scanner.nextLine();

        if(choice == 1) {
            current = new CompositeEntity(input, "drive", current);
            current.getParent().addEntity(current);
        } else if(choice == 2) {
            current = new CompositeEntity(input, "folder", current);
            current.getParent().addEntity(current);
        } else if(choice == 3) {
            current = new LeafEntity(input, "file", current);
            current.getParent().addEntity(current);
        } else {
            /* do nothing */
        }

        return ;
    }

    public static void main(String[] args) {
        root = new CompositeEntity("my_storage", "root", null);
        current = root;

        while(true) {
            System.out.println("current directory: "+current.getName()+" ("+current.getType()+")"+"\n");

            System.out.println("options:-");
            System.out.println("1. create drive");
            System.out.println("2. create folder");
            System.out.println("3. create file");
            System.out.println("4. show list");
            System.out.println("5. show details");
            System.out.println("6. remove current");
            System.out.println("7. goto");
            System.out.println("8. back");
            System.out.println("9. exit");

            System.out.print("\n"+"choice(1/2/3/4/5/6/7/8/9): ");
            choice = scanner.nextInt();
            input = scanner.nextLine();  // to catch newline

            if(choice == 1) {
                if(current.getType().equalsIgnoreCase("root")) {
                    createEntity();
                    System.out.println("\n"+"-- new drive created --"+"\n");
                } else {
                    System.out.println("\n"+"-- new drive can not be created --"+"\n");
                }

            } else if(choice == 2) {
                if(current.getType().equalsIgnoreCase("drive") || current.getType().equalsIgnoreCase("folder")) {
                    createEntity();
                    System.out.println("\n"+"-- new folder created --"+"\n");
                } else {
                    System.out.println("\n"+"-- new folder can not be created --"+"\n");
                }

            } else if(choice == 3) {
                if(current.getType().equalsIgnoreCase("drive") || current.getType().equalsIgnoreCase("folder")) {
                    createEntity();
                    // current = current.getParent();
                    System.out.println("\n"+"-- new file created --"+"\n");
                } else {
                    System.out.println("\n"+"-- new file can not be created --"+"\n");
                }

            } else if(choice == 4) {
                System.out.println("\n"+current.getList(0)+"\n");

            } else if(choice == 5) {
                System.out.println("\n"+current.getDetails()+"\n");

            } else if(choice == 6) {
                BaseEntity temp = current.getParent();

                if(temp != null) {
                    temp.removeEntity(current);
                    current = temp;

                    System.out.println("");
                } else {
                    System.out.println("\n"+"-- root can not be removed --"+"\n");
                }

            } else if(choice == 7) {
                if(current.getChildCount() == 0) {
                    System.out.println("\n"+"-- goto operation failed --"+"\n");
                } else {
                    int i, childCount = current.getChildCount();  // NOTICE

                    System.out.println("\n"+"goto:-");

                    for(i=0; i<childCount; i++) {
                        System.out.println(">> "+current.getChild(i).getName()+" ("+current.getChild(i).getType()+")");
                    }

                    System.out.print("\n"+"destination(type name): ");
                    input = scanner.nextLine();

                    for(i=0; i<childCount; i++) {
                        if(current.getChild(i).getName().equalsIgnoreCase(input)) {
                            current = current.getChild(i);
                            break;
                        }
                    }

                    if(i == childCount) {
                        System.out.println("\n"+"no such directory found, try again..."+"\n");
                    } else {
                        System.out.println("");
                    }
                }

            } else if(choice == 8) {
                if(!current.getType().equalsIgnoreCase("root")) {
                    current = current.getParent();
                }

                System.out.println("");

            } else if(choice == 9) {
                System.out.println("\n"+"exiting...");
                break;

            } else {
                System.out.println("\n"+"invalid choice made, try again..."+"\n");
            }
        }

        return ;
    }
}
