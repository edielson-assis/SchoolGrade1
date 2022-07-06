package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.SchoolGrade;
import model.enums.DaysOfTheWeek;

public class Program {

    private static String daysOfTheWeek;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        try {                
            System.out.print("How many classes will be registered? ");
            int M = sc.nextInt();

            SchoolGrade[] vector = new SchoolGrade[M];

            for (int i = 0; i < M; i++) {
                do {
                    System.out.print("Enter days of the week: ");
                    daysOfTheWeek = sc.next();
                    if (daysOfTheWeek.equals("SUNDAY")) {
                        System.out.println("This day is not available. Try again\n");
                    }
                    else {
                        System.out.print("Enter classes to register: ");
                        sc.nextLine();
                        String classes = sc.nextLine();
                        System.out.print("Enter initial hour(HH:mm): ");
                        String initialHour = sc.next();
                        System.out.print("Enter last hour(HH:mm): ");
                        String lastHour = sc.next();
                        System.out.println();

                        vector[i] = new SchoolGrade(classes, initialHour, lastHour, DaysOfTheWeek.valueOf(daysOfTheWeek));
                    }
                } while (daysOfTheWeek.equals("SUNDAY"));
            }

            System.out.println("Grade:\n");
            for (int i = 0; i < vector.length; i++) {
                System.out.println(vector[i]);
            }
            
            System.out.print("\nWould you like to remove any class(y/n)? ");
            char type = sc.next().charAt(0);

            if (type == 'y') {
                System.out.print("Which class will be remove? ");
                String classes = sc.next();

                SchoolGrade updatedVector[] = null;
                for (int i = 0; i < vector.length; i++) {
                    if (vector[i].getClasses().equals(classes)) {
                        vector[i].removeInform();
                        updatedVector = new SchoolGrade[vector.length-1];
                        for (int j = 0; j < i; j++) {
                            updatedVector[j] = vector[j];   
                        } 
                        for (int j = i; j < vector.length-1; j++) {
                            updatedVector[j] = vector[j+1];
                        }
                        break;
                    }
                } 

                System.out.println("\nupdatedGrade:\n");
                for (int j = 0; j < updatedVector.length; j++) {
                    System.out.println(updatedVector[j]);
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Input error");
        }
        catch (NumberFormatException e) {
            System.out.println("Error: invalid format");
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
            e.printStackTrace();
        }
        finally {
            System.out.println("End of program");
        }

        sc.close();
        
    }
}