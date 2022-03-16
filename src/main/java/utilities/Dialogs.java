package utilities;

import java.util.Scanner;

public class Dialogs {

  private static Scanner scanner = new Scanner(System.in);

  public static void displayWelcomeMessage() {
    System.out.println("""
        Welcome to GroceryStore application
        ------------------------------------------------------------------------------
        This application simulates a simple shopping experience.
        You can create customers, write their shopping lists and buy desired products.
        Enjoy!
        ------------------------------------------------------------------------------""" + "\n" +
        Character.toString(169) + " 2022, Jan Beszterda");
  }

  public static int showDialog(String... text) {
    System.out.println("-".repeat(text[0].length()));
    System.out.println(text[0]);
    System.out.println("-".repeat(text[0].length()));
    for (int i = 1; i < text.length; i++) {
      System.out.println(i + ". " + text[i]);
    }
    System.out.println("-".repeat(text[0].length()));
    System.out.print(">> ");
    return readIntInput(1, text.length-1);
  }

  public static int readIntInput(int min, int max) {
    int answer;
    try {
      answer = Integer.parseInt(scanner.nextLine());
      if ( answer < min || answer > max) {
        System.out.println("Wrong input");
        answer = readIntInput(min, max);
      }
    } catch (Exception ignore) {
      System.out.println("Wrong input");
      answer = readIntInput(min, max);
    }
    return answer;
  }

  public static String readStringInput(String prompt) {
    String answer = "";
    while (answer.isEmpty()) {
      System.out.println("-".repeat(prompt.length()));
      System.out.println(prompt);
      System.out.print(">>: ");
      answer = scanner.nextLine();
    }
    return answer;
  }
}
