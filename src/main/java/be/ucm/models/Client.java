package be.ucm.models;

public class Client {
    private double budget;

    public Client() {
    }

    public Client(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
