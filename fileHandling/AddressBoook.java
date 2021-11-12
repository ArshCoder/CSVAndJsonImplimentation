package com.fileHandling;


import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddressBoook {
    private static final int PERSON_FNAME = 0;
    private static final int PERSON_LNAME = 1;
    private static final int PERSON_ADDRESS = 2;
    private static final int PERSON_CITY = 3;
    private static final int PERSON_STATE = 4;
    private static final int PERSON_EMAIL = 5;
    private static final int PERSON_PHONE = 6;
    private static final int PERSON_ZIP = 7;
    private final static Scanner scanner = new Scanner(System.in);

    private List<Person> getDataInList() {
        BufferedReader br = null;
        FileReader fr = null;
        List<Person> person = new ArrayList<Person>();
        try {
            String line = "";
            fr = new FileReader("address_book.csv");
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    Person person1 = new Person(
                            tokens[PERSON_FNAME],
                            tokens[PERSON_LNAME],
                            tokens[PERSON_ADDRESS],
                            tokens[PERSON_CITY],
                            tokens[PERSON_STATE],
                            tokens[PERSON_EMAIL],
                            tokens[PERSON_PHONE],
                            tokens[PERSON_ZIP]
                    );
                    person.add(person1);
                }
            }
        } catch (IOException e) {
            System.out.println("Reading CSV Error!!!");
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                System.out.println("Closing File Reader error!!!");
                e.printStackTrace();
            }
        }
        return person;
    }


    public void addRecord() throws IOException {
        final String firstName, lastName, address, city, state, zip, phoneNumber, email;

        System.out.print("Enter First Name : ");
        firstName = scanner.next();
        System.out.print("Enter Last Name : ");
        lastName = scanner.next();
        System.out.print("Enter Address : ");
        address = scanner.next();
        System.out.print("Enter City : ");
        city = scanner.next();
        System.out.print("Enter State : ");
        state = scanner.next();
        System.out.print("Enter Email : ");
        phoneNumber = scanner.next();
        System.out.print("Enter PhoneNumber : ");
        email = scanner.next();
        System.out.print("Enter Zip : ");
        zip = scanner.next();

        List<Person> person = Arrays.asList(
                new Person(firstName, lastName, address, city, state, zip, phoneNumber, email)
        );
        WriteToCSV.writeAddCSV(person);
    }


    public void displayRecord() throws IOException {
        List<Person> person = getDataInList();
        for (Person p : person) {
            System.out.println(p);
        }

    }


    public void editRecord() throws IOException {
        final List<Person> person = getDataInList();
        int id, choice = 0, i = 0;
        String firstName, lastName, address, city, state, zip, phoneNumber, email;
        for (Person p : person) {
            System.out.println("ID: #" + person.indexOf(p) + " : " + p);
        }
        System.out.print("\nEnter #ID to Edit Contact : ");
        id = scanner.nextInt();
        System.out.println(person.get(id));
        while (i == 0) {
            System.out.println("What You Want to edit...\n"
                    + "\t1: First Name\n"
                    + "\t2: Last Name\n"
                    + "\t3: Street\n"
                    + "\t4: city\n"
                    + "\t5: State\n"
                    + "\t6: Country\n"
                    + "\t7: Phone\n"
                    + "\t8: Zip Code\n"
                    + "\t9. Save And Exit\n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter new First Name : ");
                    firstName = scanner.next();
                    person.get(id).setFirstName(firstName);
                    break;
                case 2:
                    System.out.print("Enter new Last Name : ");
                    lastName = scanner.next();
                    person.get(id).setLastName(lastName);
                    break;
                case 3:
                    System.out.print("Enter new Address : ");
                    address = scanner.next();
                    person.get(id).setAddress(address);
                    break;
                case 4:
                    System.out.print("Enter new City : ");
                    city = scanner.next();
                    person.get(id).setCity(city);
                    break;
                case 5:
                    System.out.print("Enter new State : ");
                    state = scanner.next();
                    person.get(id).setState(state);
                    break;
                case 6:
                    System.out.print("Enter new PhoneNumber : ");
                    phoneNumber = scanner.next();
                    person.get(id).setPhoneNumber(phoneNumber);
                    break;
                case 7:
                    System.out.print("Enter new Email : ");
                    email = scanner.next();
                    person.get(id).setEmail(email);
                    break;
                case 8:
                    System.out.print("Enter new Zip Code : ");
                    zip = scanner.next();
                    person.get(id).setZip(zip);
                    break;
                case 9:
                    WriteToCSV.writeFromEdit(person);
                    i = 1;
                    break;
                default:
                    System.out.println("Please Enter Valid Option");
            }
            System.out.println(person.get(id));
        }
    }


    public void deleteRecord() throws IOException {
        final List<Person> person = getDataInList();
        int id;
        for (Person p : person) {
            System.out.println("ID: #" + person.indexOf(p) + " : " + p);
        }
        System.out.print("\nEnter #ID to delete Contact : ");
        id = scanner.nextInt();
        person.remove(id);
        WriteToCSV.writeFromDelete(person);

    }
}
