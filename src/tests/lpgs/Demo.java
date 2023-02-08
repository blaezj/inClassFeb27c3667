package lpgs;

import java.util.Scanner;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        LPGS lpgs = new LPGS();
        Scanner kb = new Scanner(System.in);
        System.out.print("Welcome to the License Plate Game Solver\n");
        System.out.print("Would you like to require the words to not begin with the first letter of the plate? (y/N)");
        if (kb.nextLine().toLowerCase().equals("y")) lpgs.setNoStart(true);
        System.out.print("Would you like to require the words to not end with the last letter of the plate? (y/N)");
        if (kb.nextLine().toLowerCase().equals("y")) lpgs.setNoEnd(true);
        System.out.print("Would you like to require the words to have spaces between each letter of the plate? (y/N)");
        if (kb.nextLine().toLowerCase().equals("y")) lpgs.setSpaceBetween(true);
        System.out.print("Enter the license plate letters: ");
        String letters = kb.nextLine();
        ArrayList<String> answers = lpgs.solve(letters);
        System.out.printf("Valid words for letters: %s\n", letters);
        System.out.printf("No Start: %s\n", lpgs.getNoStart() ? "Yes" : "No");
        System.out.printf("No Start: %s\n", lpgs.getNoEnd() ? "Yes" : "No");
        System.out.printf("No Start: %s\n", lpgs.getSpaceBetween() ? "Yes" : "No");
        for (String w : answers) System.out.println(w);
    }
}
