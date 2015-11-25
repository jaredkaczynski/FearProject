package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            try
            {
                File inputFile = new File(args[0]);
                Scanner in = new Scanner(inputFile);
                PrintWriter out = new PrintWriter("ban.txt");
                int counter = 0;
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    Scanner lineScanner = new Scanner(line);
                    String word = lineScanner.next();
                    int i = 0;
                    while (Character.isDigit(line.charAt(i))) {
                        while (Character.isDigit(line.charAt(i+1))) {
                            while (Character.isDigit(line.charAt(i+2))) {
                                while (line.charAt(i+3) != '.') {
                                    i++;
                                }
                            }
                        }
                        String ipAddress = line.substring(i, i+13);
                        if (word.equals("Invalid")) {
                            counter++;
                        }
                        if (counter >= 3) {
                            out.println(ipAddress);
                        }
                    }
                    lineScanner.close();
                }
                in.close();
                out.close();
            }
            catch (FileNotFoundException exception) {
                System.out.println("File not found.");
            }


        }
    }
}
