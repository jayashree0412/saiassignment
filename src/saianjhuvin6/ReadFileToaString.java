package saianjhuvin6;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileToaString {
    private String readFile(String pathname) throws IOException {
//        String filePath="C:\\Users\\jayas\\Desktop\\CSCI 3901 Assignment6 -converted.docx";

        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int)file.length());
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }

            return fileContents.toString();
        }
    }

    public static void main(String[] args) throws  java.io.IOException{
        String strFile;
        ReadFileToaString readFileToaString=new ReadFileToaString();
//        System.out.println(readFileToaString.readFile("C:\\Users\\jayas\\Desktop\\CSCI 3901 Assignment6 -converted.txt"));
    }
}
