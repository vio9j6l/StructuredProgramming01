import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Main
{
  private static final Scanner keyboard = new Scanner(System.in);
  private static final Random randomGenerator = new Random();


  public static String readNonBlankString(Scanner keyboard, String prompt) {
    String userInput;
    do {
      System.out.println(prompt);
      userInput = keyboard.nextLine();
    } while (userInput.trim().equals(""));
    return userInput;
  }
  public static String readMultipleChoice(Scanner keyboard, String prompt, String[] validAnswers) {
    String userInput = "";
    boolean isValid = false;
    while (!isValid) {
      userInput = keyboard.nextLine();

      for (String validAnswer : validAnswers) {
        if (userInput.equals(validAnswer)) {
          // you know what they typed in is valid
          isValid = true;
          break;

        }
        else {
          System.out.println();
          System.out.println("You must enter Y or N");
          System.out.print(prompt);
          userInput = keyboard.nextLine();
        }
      }

    }
    return userInput;
  }



    public static void main (String[]args){

      // TODO 00 - replace XX with your breakout room, and list each student in the breakout room, and which one shared their screen to type the code
      System.out.println("Breakout Room #3"); // Replace 'X' with the room number
      System.out.println("Name: JiaJia Liu (jpl5840@psu.edu)");
      System.out.println("Name: Hasna Naz");
      System.out.println("Name: Rushi Patel");
      System.out.println("");
      System.out.println("Student in charge of typing code and submitting .zip:");
      System.out.println("Name: JiaJia Liu (jpl5840@psu.edu)");


      // TODO 01 - Too much duplication.  Create ONE, which will be called once for the first name, then again for the last name
      // That one method should not handle both first and last name at the same time
      // Hint:
      // String firstName = readNonBlankString(keyboard, "What is your first name?");
      // String lastName = readNonBlankString(keyboard, "What is your last name?");
      String firstName;
      do {
        System.out.print("What is your first name? ");
        firstName = keyboard.nextLine();
      } while (firstName.trim().equals(""));

      String lastName;
      do {
        System.out.print("What is your last name? ");
        lastName = keyboard.nextLine();
      } while (lastName.trim().equals(""));
      System.out.printf("Hello, %s %s!%n", firstName, lastName);


      int correct = 0;
      int incorrect = 0;

      List<Integer> randomInts = new ArrayList<>();

      int count = 0;
      String userInput = "Y";
      while (userInput.equals("Y")) {
        count++;
        /*
         * To get a random integer between 2 and 10, we get a random int
         * between 1 and 5 (inclusive), then double it.
         *
         * Since Random.nextInt(5) returns a random integer between 0 and 4
         * (inclusive), we add 1 to it.  That gets us between 1 and 5.
         *
         * Doubling that result will give us the random integer between 2 and 10.
         */
        int randomInt = 2 * (randomGenerator.nextInt(5) + 1);
        randomInts.add(randomInt);

        /*
         * Ensure the user's guess is positive, with no decimals
         */
        // TODO 02 - This uses too much room here.  Create one method to handle reading and validating the input
        // Hint:
        // userIntAnswer = readUserIntAnswer(keyboard, "What is half of " + randomInt + "? ");
        int userIntAnswer = 0;
        boolean validInt;
        do {
          validInt = true;

          System.out.print("What is half of " + randomInt + "? ");
          userInput = keyboard.nextLine();
          System.out.println("You answered: " + userInput);

          try {
            userIntAnswer = Integer.parseInt(userInput);
            if (userIntAnswer <= 0) {
              validInt = false;
            }
          } catch (Exception e) {
            System.out.println();
            validInt = false;
          }
          if (!validInt) {
            System.out.println("You must enter a positive number with no decimals");
          }
        } while (!validInt);


        if (userIntAnswer == (randomInt / 2)) {
          System.out.println("Correct!");
          correct++;
        }
        else {
          System.out.println("Wrong!");
          incorrect++;
        }


        // TODO 03 - Move this prompting, reading, validation of Y/N to its own method
        // Make it generic enough to handle any list of inputs.
        // Hint:
        String[] validAnswers = {"Y", "N"};
        System.out.print("Another number? ");
        Scanner keyboard = new Scanner(System.in);
        userInput = readMultipleChoice(keyboard, "Another number? ", validAnswers);
        //System.out.print("Another number? ");
/*
      while(true) {
        userInput = keyboard.nextLine();
        if ((userInput.equals("N") || userInput.equals("Y"))) {
          break;
        } else {
          System.out.println();
          System.out.println("You must enter Y or N");
          System.out.print("Another number? ");
        }
      }
      System.out.println("");
    }

 */


        // TODO 04 - Move this game-summary code to its own method
        // Hint:  You will need parameters
        System.out.println("Game over");
        System.out.println("You answered " + count + " questions");
        System.out.println(correct + " were right");
        System.out.println(incorrect + " were wrong");
        System.out.println("You got " + (100 * correct / count) + "% right");
        System.out.println("The highest random number you were given:  " + Collections.max(randomInts));
        System.out.println("The lowest random number you were given:  " + Collections.min(randomInts));
        System.out.println("The list of numbers you were given:");
        for (int randomInteger : randomInts) {
          System.out.println(randomInteger);
        }
      }

    }

  }
