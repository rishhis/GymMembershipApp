package com.gym.membership;

public class MemberDetails {
    private String name;
    private int age;
    private double membershipAmount;

    public MemberDetails(String name, int age, double membershipAmount) {
        this.name = name;
        this.age = age;
        this.membershipAmount = membershipAmount;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMembershipAmount() {
        return membershipAmount;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Membership Amount: Rs. " + membershipAmount);
        System.out.println("--------------------------");
    }
}
