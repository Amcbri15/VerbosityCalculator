package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Calculate the verbosity of a text
 */
public class VerbosityCalculator {
    public static void main(String[] args){

        // An abstract representation of a File
        File file = new File("PATH to text file");

        try{
            Scanner sc = new Scanner(file);
            /**
             *  Your CODE goes here
             *
             *
             *
             *
             */

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
