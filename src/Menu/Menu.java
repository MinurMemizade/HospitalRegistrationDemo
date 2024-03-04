package Menu;

import Admin.Admin;
import Admin.Config;
import Admin.Doctors;
import Admin.Utilities;
import User.Appointment;

import javax.print.Doc;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Admin.Config.doctorList;
import static Admin.Config.doctors;

public class Menu {
    public static void showAdminMenu()
    {
        Scanner sc=new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    Utilities.registerDoctors();
                    break;
                case 2:
                    Utilities.printAllRegistered();
                    break;
                case 3:
                    Utilities.showSearched();
                    break;
                case 4:
                    Utilities.update();
                    break;
                case 5:
                    Utilities.remove();
                    break;
                case 6:
                    Utilities.readDoctorsFromFile("Doctors.ser");
                case 7:
                        for(int i = 0; i< doctorList.size(); i++)
                        {
                            Utilities.saveDoctorsToFile("Doctors.ser");
                        }
                        break;
                case 8:
                        Utilities.removeDoctorsFromFile("Doctors.ser");
                    break;
                case 9:
                    MainMenu.mainMenu();
                case 10:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }catch (InputMismatchException e)
        {
            System.out.println("Invalid option.");
        }

    }

    public static void showUserMenu()
    {
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        switch (choice)
        {
            case 1:
                Utilities.readDoctorsFromFile("Doctors.ser");
                break;
            case 2:
                Utilities.printAllRegistered();
                break;
            case 3:
                Appointment.getAppointment();
                break;
            case 4:
                Utilities.showSearched();
                break;
            case 5:
                MainMenu.mainMenu();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option.");
        }
    }

    public static void showMainMenu()
    {
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter username:");
                String username=sc.next();
                System.out.println("Enter password:");
                String password=sc.next();
                if (username.equals(Admin.getUsername()) && password.equals(Admin.getPassword())) MainMenu.adminMenu();
                else System.out.println("The username or password is incorrect.");
                break;
            case 2:
                MainMenu.userMenu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option.");
        }
    }
}
