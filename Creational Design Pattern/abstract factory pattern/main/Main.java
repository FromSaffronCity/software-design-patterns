package main;

import java.util.Scanner;
import java.lang.Math;

import shapes.*;
import factories.ComputerFactory;
import components.Cpu;
import components.Mmu;
import components.Resolution;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String input = null;

    public static Shape getShape(String shapeName) {
        if(shapeName == null) {
            /* nothing here */
        } else if("Circle".equalsIgnoreCase(shapeName)) {
            System.out.print("enter radius: ");
            double radius = Math.abs(scanner.nextDouble());
            input = scanner.nextLine();  // NOTICE: for handling newline

            return new Circle(radius);
        } else if("Square".equalsIgnoreCase(shapeName)) {
            System.out.print("enter side: ");
            double side = Math.abs(scanner.nextDouble());
            input = scanner.nextLine();  // NOTICE: for handling newline

            return new Square(side);
        } else if("Rectangle".equalsIgnoreCase(shapeName)) {
            System.out.print("enter height: ");
            double height = Math.abs(scanner.nextDouble());
            System.out.print("enter width: ");
            double width = Math.abs(scanner.nextDouble());
            input = scanner.nextLine();  // NOTICE: for handling newline

            return new Rectangle(height, width);
        } else if("Triangle".equalsIgnoreCase(shapeName)) {
            System.out.print("enter a: ");
            double a = Math.abs(scanner.nextDouble());
            System.out.print("enter b: ");
            double b = Math.abs(scanner.nextDouble());
            System.out.print("enter c: ");
            double c = Math.abs(scanner.nextDouble());
            input = scanner.nextLine();  // NOTICE: for handling newline

            /* validity checking */
            if(a+b>c && b+c>a && c+a>b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("!!! invalid triangle !!!");
            }

        } else {
            /* nothing here */
        }

        return null;
    }

    public static boolean canBeDisplayed(Resolution resolution, Shape shape) {
        int max = Math.max(resolution.getX(), resolution.getY());
        int min = Math.min(resolution.getX(), resolution.getY());

        if("Circle".equalsIgnoreCase(shape.getName())) {
            Circle circle = (Circle) shape;

            if(circle.getRadius()*2 > (double) min) {
                return false;
            } else {
                return true;
            }

        } else if("Square".equalsIgnoreCase(shape.getName())) {
            Square square = (Square) shape;

            if(square.getSide() > (double) min) {
                return false;
            } else {
                return true;
            }

        } else if("Rectangle".equalsIgnoreCase(shape.getName())) {
            Rectangle rectangle = (Rectangle) shape;

            if(Math.max(rectangle.getHeight(), rectangle.getWidth())>(double)max || Math.min(rectangle.getHeight(), rectangle.getWidth())>(double)min) {
                return false;
            } else {
                return true;
            }

        } else if("Triangle".equalsIgnoreCase(shape.getName())) {
            Triangle triangle = (Triangle) shape;
            double height;

            /* base = a */
            height = (2*triangle.getArea())/triangle.getA();

            if(Math.max(height, triangle.getA())<=(double)max || Math.min(height, triangle.getA())<=(double)min) {
                return true;
            }

            /* base = b */
            height = (2*triangle.getArea())/triangle.getB();

            if(Math.max(height, triangle.getB())<=(double)max || Math.min(height, triangle.getB())<=(double)min) {
                return true;
            }

            /* base = c */
            height = (2*triangle.getArea())/triangle.getC();

            if(Math.max(height, triangle.getC())<=(double)max || Math.min(height, triangle.getC())<=(double)min) {
                return true;
            }

            return false;

        } else {
            return false;  // invalid case
        }
    }

    public static void main(String[] args) {
        ComputerFactory computerFactory = null;
        Cpu cpu = null;
        Mmu mmu = null;
        Resolution resolution = null;
        Shape shape = null;

        while(true) {
            /* input part */
            System.out.print("enter computer name (computerA/ computerB/ computerC): ");
            input = scanner.nextLine();
            computerFactory = FactoryProducer.getFactory(input);

            System.out.print("enter shape name (circle/ square/ rectangle/ triangle): ");
            input = scanner.nextLine();
            shape = getShape(input);

            /* input checking */
            if(computerFactory == null || shape == null) {
                System.out.println("\n" + "invalid input given, try again" + "\n");
                continue;
            }

            /* producing computer */
            cpu = computerFactory.getCpu();
            mmu = computerFactory.getMmu();
            resolution = computerFactory.getResolution();

            /* output part: print details */
            System.out.println("\n" + "details:");
            System.out.println("cpu name: " + cpu.getName());
            System.out.println("mmu name: " + mmu.getName());
            System.out.println(resolution.getName() + ": " + resolution);
            System.out.println("\n" + "shape name: " +shape.getName());
            System.out.println("surface area: " + shape.getArea());
            System.out.println("perimeter: " + shape.getPerimeter());

            /* output part: can be displayed? */
            if(canBeDisplayed(resolution, shape)) {
                System.out.println("\n" + "<this shape CAN be displayed on the given computer>");
            } else {
                System.out.println("\n" + "<this shape CAN NOT be displayed on the given computer>");
            }

            /* termination checking part */
            System.out.print("\n" + "continue? (yes/no): ");
            input = scanner.nextLine();

            if("no".equalsIgnoreCase(input)) {
                break;
            } else if("yes".equalsIgnoreCase(input)) {
                System.out.println("");
                continue;
            } else {
                System.out.println("invalid input given, terminating the program");
                break;
            }
        }

        return ;
    }
}

