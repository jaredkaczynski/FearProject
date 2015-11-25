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
                    int i = 0;
                    String line = in.nextLine();
                    Scanner lineScanner = new Scanner(line);
                    String word;
                    //while(lineScanner.hasNext()){
                    //word = lineScanner.next();

                    while (!(Character.isDigit(line.charAt(i)) || Character.isSpaceChar(line.charAt(i)))) {
                        while (!Character.isDigit(line.charAt(i+1))) {
                            while (!Character.isDigit(line.charAt(i+2))) {
                                while (line.charAt(i+3) != '.') {
                                    i++;
                                }
                            }
                        }
                        String ipAddress = line.substring(i, i + 10);
                        if(line.length()>i+10) {
                            ipAddress = line.substring(i, i + 11);
                        }
                        if(line.length()>i+11) {
                            ipAddress = line.substring(i, i + 12);
                        }
                        if(line.length()>i+12) {
                            ipAddress = line.substring(i, i + 13);
                        }
                        while(lineScanner.hasNext()){
                            word = lineScanner.next();
                            if (word.equals("Invalid")) {
                                counter++;
                            }
                        }

                        if (counter >= 3) {
                            out.println(ipAddress);
                        }
                        //i++;
                    }

                    //}
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
