package ru.spbstu.appmath.bykov;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final File file1 = new File("matrix-dir","matrix1.txt");
        final File file2 = new File("matrix-dir","matrix2.txt");
            if (file1.exists() && file2.exists()) {
                System.out.print("OK!");
            }
    }
    private static String ReadFile(final File file) {
        final StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return result.toString();
    }
}
