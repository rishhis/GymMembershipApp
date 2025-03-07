package com.gym.membership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymMembershipTest {
    private static final List<MemberDetails> membersList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter number of members: ");
            int numMembers = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            List<Thread> threads = new ArrayList<>();

            for (int i = 0; i < numMembers; i++) {
                System.out.println("Enter details for Member " + (i + 1) + ":");
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                System.out.print("Enter Duration (in days): ");
                int duration = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Membership Type (Normal/Premium): ");
                String type = scanner.nextLine();

                // Creating a new thread for each member
                Thread thread = new Thread(() -> processMembership(name, age, duration, type));
                threads.add(thread);
                thread.start();
            }

            // Wait for all threads to complete
            for (Thread t : threads) {
                t.join();
            }

            // Print all members' details
            System.out.println("\nAll Processed Memberships:");
            for (MemberDetails member : membersList) {
                member.display();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void processMembership(String name, int age, int duration, String type) {
        try {
            GymMembership membership;
            if (type.equalsIgnoreCase("Normal")) {
                membership = new NormalMembership(name, age, duration);
            } else if (type.equalsIgnoreCase("Premium")) {
                membership = new PremiumMembership(name, age, duration);
            } else {
                throw new IllegalArgumentException("Invalid Membership Type!");
            }

            double amount = membership.calculateMembershipPrice();

            // Store the details in the list
            synchronized (membersList) { // Synchronization to avoid thread conflicts
                membersList.add(new MemberDetails(name, age, amount));
            }

            System.out.println("Processed Membership for " + name);

        } catch (Exception e) {
            System.out.println("Error processing membership for " + name + ": " + e.getMessage());
        }
    }
}
