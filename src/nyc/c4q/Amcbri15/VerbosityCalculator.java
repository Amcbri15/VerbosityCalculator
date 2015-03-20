package nyc.c4q.Amcbri15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Anthony McBride
 * Verbosity Calculator
 */
public class VerbosityCalculator {

    public static double countText(File file) {

        double allWords = 0;
        double allSentences = 0;
        double verbosity;
        char last;

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] words = line.split(" ");

                for (int i = 0; i < words.length; i++) {

                    allWords += 1;

                    if (words[i].length() > 0) {

                        last = words[i].charAt(words[i].length() - 1);

                        if (last == '.' || last == '!' || last == '?') {

                            allSentences += 1;

                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        verbosity = allWords / allSentences;
        return verbosity;
    }

    public static void main(String[] args) {

        File twoCities = new File("/Users/c4q-anthony-mcbride/Desktop/accesscode/VerbosityCalculator/resources/aTaleOfTwoCities.txt");
        File mobyD = new File("/Users/c4q-anthony-mcbride/Desktop/accesscode/VerbosityCalculator/resources/mobyDick.txt");
        double dickensVerbosity = countText(twoCities);
        double melvilleVerbosity = countText(mobyD);

        System.out.println("The verbosity of A Tale of Two Cities is " + dickensVerbosity + "\n");
        System.out.println("The verbosity of Moby Dick is " + melvilleVerbosity + "\n");

        if (dickensVerbosity > melvilleVerbosity)
            System.out.println("Charles Dickens is more verbose then Herman Melville here.");
        else
            System.out.println("Herman Melville is more verbose then Charles Dickens here.");

    }
}
