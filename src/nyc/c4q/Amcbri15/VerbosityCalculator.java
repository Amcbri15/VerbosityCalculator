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
        char punctuation;

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] word = line.split(" ");

                for (int i = 0; i < word.length; i++) {

                    allWords += 1;

                    if (word[i].length() > 0) {

                        punctuation = word[i].charAt(word[i].length() - 1);

                        if (punctuation == '.' || punctuation == '!' || punctuation == '?') {

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
        double dVerbosity = countText(twoCities);
        double mVerbosity = countText(mobyD);

        System.out.println("The verbosity of A Tale of Two Cities is " + dVerbosity + "\n");
        System.out.println("The verbosity of Moby Dick is " + mVerbosity + "\n");

        if (dVerbosity > mVerbosity)
            System.out.println("Charles Dickens is more verbose then Herman Melville here.");
        else
            System.out.println("Herman Melville is more verbose then Charles Dickens here.");

    }
}
