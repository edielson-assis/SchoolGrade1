package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.SchoolGrade;
import model.enums.DaysOfTheWeek;
import model.exceptions.DomainException;

public class Program {

    private static String daysOfTheWeek;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        try {                
            System.out.print("How many classes will be registered? ");
            int M = sc.nextInt();

            SchoolGrade[] vector = new SchoolGrade[M];

            for (int i = 0; i < M; i++) {
                do {
                    System.out.print("Enter days of the week: ");
                    daysOfTheWeek = sc.next().toUpperCase();
                    if (daysOfTheWeek.equals("SUNDAY")) {
                        System.out.println("This day is not available. Try again\n");
                    }
                    else {
                        System.out.print("Enter classes to register: ");
                        sc.nextLine();
                        String classes = sc.nextLine();
                        System.out.print("Enter initial hour(HH:mm): ");
                        Date initialHour = sdf.parse(sc.next());
                        System.out.print("Enter last hour(HH:mm): ");
                        Date lastHour = sdf.parse(sc.next());
                        System.out.println();
                        
                        vector[i] = new SchoolGrade(classes, initialHour, lastHour, DaysOfTheWeek.valueOf(daysOfTheWeek));
                    }
                } while (daysOfTheWeek.equals("SUNDAY"));
            }

            System.out.println("Grade:\n");
            Arrays.sort(vector);
            for (int i = 0; i < vector.length; i++) {
                System.out.println(vector[i]);
            }
            
            System.out.print("\nWould you like to remove any class(y/n)? ");
            char type = sc.next().charAt(0);

            if (type == 'y') {
                System.out.print("Which class will be remove? ");
                sc.nextLine();
                String classes = sc.nextLine();

                SchoolGrade updatedVector[] = null;
                for (int i = 0; i < vector.length; i++) {
                    if (vector[i].getClasses().equalsIgnoreCase(classes)) {
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
        catch (ParseException e) {
            System.out.println("Invalid hour format");
        }
        catch (DomainException e) {
            System.out.println(e.getMessage());
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
            System.out.println("\nEnd of program");
        }

        sc.close();
    }
}