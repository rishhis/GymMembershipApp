package com.gym.membership;

public abstract class BaseMembership implements GymMembership {
    protected String name;
    protected int age;
    protected int duration;
    protected final double basePrice = 500;

    public BaseMembership(String name, int age, int duration) {
        if (age <= 0 || duration <= 0) {
            throw new IllegalArgumentException("Age and duration must be positive values.");
        }
        this.name = name;
        this.age = age;
        this.duration = duration;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public abstract String getMembershipType();
}
