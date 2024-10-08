package com.example.carbonpersonne;

import com.example.carbonpersonne.model.UserEntry;
import com.example.carbonpersonne.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserService userManager = new UserService();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("1. Create User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. Add Consumption");
            System.out.println("5. Display Consumption");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            String id;
            String name;
            int age;
            UserEntry user;
            switch (option) {
                case 1:
                    System.out.print("Enter ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                        if (age <= 0) {
                            System.out.println("Age must be greater than 0.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age. Please enter a number.");
                        continue;
                    }
                    userManager.createUser(id, name, age);
                    System.out.println("User created successfully.");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                        if (age <= 0) {
                            System.out.println("Age must be greater than 0.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age. Please enter a number.");
                        continue;
                    }
                    userManager.updateUser(id, name, age);
                    System.out.println("User updated successfully.");
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    id = scanner.nextLine();
                    userManager.deleteUser(id);
                    System.out.println("User deleted successfully.");
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    id = scanner.nextLine();
                    user = userManager.getUser(id);
                    if (user != null) {
                        System.out.print("Enter Start Date (yyyy-MM-dd): ");
                        String startDateStr = scanner.nextLine();
                        System.out.print("Enter End Date (yyyy-MM-dd): ");
                        String endDateStr = scanner.nextLine();
                        System.out.print("Enter Amount: ");
                        double amount;
                        try {
                            amount = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount. Please enter a number.");
                            continue;
                        }

                        try {
                            Date startDate = sdf.parse(startDateStr);
                            Date endDate = sdf.parse(endDateStr);
                            if (startDate.after(endDate)) {
                                System.out.println("Start date must be before end date.");
                                continue;
                            }
                            user.addConsumptionEntry(startDate, endDate, amount);
                            System.out.println("Consumption added successfully.");
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Use yyyy-MM-dd.");
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    id = scanner.nextLine();
                    user = userManager.getUser(id);
                    if (user != null) {
                        user.displayFootprint();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter User ID: ");
                    id = scanner.nextLine();
                    user = userManager.getUser(id);
                    if (user != null) {
                        System.out.println("Generating report for user: " + user.getName());
                        user.displayConsumptionReport();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 7:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
