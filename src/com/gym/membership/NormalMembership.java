package com.gym.membership;

public class NormalMembership extends BaseMembership {
    public NormalMembership(String name, int age, int duration) {
        super(name, age, duration);
    }

    @Override
    public String getMembershipType() {
        return "Normal";
    }

    @Override
    public double calculateMembershipPrice() {
        return basePrice + 80 * duration;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Membership Type: " + getMembershipType());
        System.out.println("Total Cost: Rs. " + calculateMembershipPrice());
    }
}
