package utilities;

import java.util.Scanner;

public class Dialogs {

  private static Scanner scanner = new Scanner(System.in);

  public static void displayWelcomeMessage() {
    System.out.println("""
        Welcome to Livsmedelsbutik application
        --------------------------------------
        What do you want to do?
        1. Create a customer
        2. Quit""");
  }
}
