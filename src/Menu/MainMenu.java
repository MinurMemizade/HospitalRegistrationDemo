package Menu;

import Admin.Config;
import Admin.Doctors;
import Admin.Utilities;

import java.util.Scanner;

public class MainMenu {
    public static void adminMenu()
    {
        System.out.println("\t Welcome.");
        while(true)
        {
            System.out.println("Enter your selection:");
            System.out.println("1.Add new doctor.");
            System.out.println("2.Show all doctor.");
            System.out.println("3.Find doctor.");
            System.out.println("4.Update doctor information.");
            System.out.println("5.Remove doctor.");
            System.out.println("6.Save doctors to file.");
            System.out.println("7.Read doctors from file.");
            System.out.println("8.Remove doctors from file");
            System.out.println("9.Quit to Main Menu.");
            System.out.println("10.Exit");
            Menu.showAdminMenu();
        }
    }

    public static void userMenu()
    {
        while(true) {
            System.out.println("Enter your selection:");
            System.out.println("1.Read doctors from file.");
            System.out.println("2.Show all doctor.");
            System.out.println("3.Get a doctor appointment.");
            System.out.println("4.Find doctor.");
            System.out.println("5.Quit to Main Menu.");
            System.out.println("6.Exit");
            Menu.showUserMenu();
        }
    }

    public static void mainMenu()
    {
        System.out.println("\tWelcome.");
        while (true)
        {
            System.out.println("Please enter your selection:");
            System.out.println("1.Admin.");
            System.out.println("2.User.");
            System.out.println("3.Exit.");
            Menu.showMainMenu();
        }
    }
}
