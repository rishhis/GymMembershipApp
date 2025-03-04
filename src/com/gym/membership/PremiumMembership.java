package com.gym.membership;

public class PremiumMembership extends BaseMembership {
    public PremiumMembership(String name, int age, int duration) {
        super(name, age, duration);
    }

    @Override
    public String getMembershipType() {
        return "Premium";
    }

    @Override
    public double calculateMembershipPrice() {
        int first15Days = Math.min(duration, 15);
        int remainingDays = Math.max(duration - 15, 0);
        return basePrice + (120 * first15Days) + (70 * remainingDays);
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Membership Type: " + getMembershipType());
        System.out.println("Total Cost: Rs. " + calculateMembershipPrice());
    }
}
