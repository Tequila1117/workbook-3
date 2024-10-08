import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) { // Main method: entry point of the application

        // The array to store 10 famous quotes (Variable: quotes)
        String[] quotes = {
                "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela",
                "The way to get started is to quit talking and begin doing. - Walt Disney",
                "Life is what happens when you're busy making other plans. - John Lennon",
                "You have within you right now, everything you need to deal with whatever the world can throw at you. - Brian Tracy",
                "Believe you can and you're halfway there. - Theodore Roosevelt",
                "The only impossible journey is the one you never begin. - Tony Robbins",
                "It does not matter how slowly you go as long as you do not stop. - Confucius",
                "Success is not how high you have climbed, but how you make a positive difference to the world. - Roy T. Bennett",
                "You are never too old to set another goal or to dream a new dream. - C.S. Lewis",
                "Your time is limited, don't waste it living someone else's life. - Steve Jobs",

        };

        // Create a Scanner object for user input (Variable: scanner)
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true; // Loop control variable (Variable: continueProgram)

        // The loop to allow multiple requests for quotes (while loop)
        while (continueProgram) {
            try {
                // Tell user to enter a number between 1 and 10
                System.out.print("Select a number between 1 and 10 for a quote (or type 'random' for a random quote): ");
                String input = scanner.nextLine(); // Read user input (Variable: input)

                // See if user wants a random quote (not case sensitive)
                if (input.equalsIgnoreCase("random")) {
                    Random random = new Random(); // Create a Random object (Variable: random)
                    int randomIndex = random.nextInt(quotes.length); // Get a random index (Variable: randomIndex)
                    System.out.println("Random Quote: " + quotes[randomIndex]); // Shows the random quote (Output)
                } else {
                    // Change user input to an integer (Parsing Input)
                    int index = Integer.parseInt(input); // Try to parse the input to an integer (Variable: index)
                    index--; // Adjust for zero-based indexing (Control Structure: Adjustment)

                    // Display the selected quote if response is valid (Control Structure: if statement)
                    if (index >= 0 && index < quotes.length) {
                        System.out.println("Quote #" + (index + 1) + ": " + quotes[index]); // Display quote (Output)
                    } else {
                        // If the index is out of range (Error Handling)
                        System.out.println("Your number was out of range! Please select a number between 1 and 10.");
                    }
                }
            } catch (NumberFormatException e) {
                // Handles the case where the input isn't a number (Error Handling)
                System.out.println("Invalid input! Please enter a number between 1 and 10 or type 'random'.");
            } catch (Exception e) {
                // Handles any other unexpected exceptions (Error Handling)
                System.out.println("Sorry, An unexpected error occurred.");
            }

            // See if user want to see another quote (User Interaction)
            System.out.print("Do you want to see another quote? (yes/no): ");
            String response = scanner.nextLine(); // Read user response (Variable: response)

            // See if user wants to continue or exit (using if statement for control structure)
            if (response.equalsIgnoreCase("no")) {
                continueProgram = false; // Exit the loop if user responds "no"
            }
            // If input from user isn't yes or no, use method to respond with "invalid response"
            else if (!response.equalsIgnoreCase("yes")) {
                System.out.println("Invalid response! Please enter 'yes' or 'no'."); // Handles non-related input
            }
        }

        // Close the scanner
        scanner.close();
        System.out.println("Thank you for reviewing the Famous Quotes!!!!"); // Goodbye message (Output)
    }
}