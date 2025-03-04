package com.gym.membership;

import java.util.Scanner;

public class GymMembershipTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Duration: ");
            int duration = scanner.nextInt();

            System.out.print("Enter Membership Type (Normal/Premium): ");
            String type = scanner.next();

            GymMembership membership;
            if (type.equalsIgnoreCase("Normal")) {
                membership = new NormalMembership(name, age, duration);
            } else if (type.equalsIgnoreCase("Premium")) {
                membership = new PremiumMembership(name, age, duration);
            } else {
                throw new IllegalArgumentException("Invalid Membership Type!");
            }

            membership.displayDetails();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
