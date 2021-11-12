package com.fileHandling;

import java.io.IOException;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice, i = 0;
        final AddressBoook add = new AddressBoook();
        while (i == 0) {
            System.out.println("--- Address Book Management ---\n");
            System.out.println("\t--MENU--");
            System.out.println("1: Add New Person      ");
            System.out.println("2: Display Records     ");
            System.out.println("3: Edit Person Record  ");
            System.out.println("4: Delete Person Record");
            System.out.println("7: Exit		       \n");
            System.out.println(" -----------------------");
            System.out.println("--- Enter Your Choice ---");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    add.addRecord();
                    break;
                case 2:
                    add.displayRecord();
                    break;
                case 3:
                    add.editRecord();
                    break;
                case 4:
                    add.deleteRecord();
                    break;
                case 5:
                    i = 1;
                    break;
                default:
                    System.out.println("Please Enter Valid Option!!!");
            }
        }

    }
}
