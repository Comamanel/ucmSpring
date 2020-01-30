package be.ucm.DAL.entities;

public enum State {
    IN_PROGRESS("in_progress"),
    VALIDATED("validated");

    private String name;

    public String getName() {
        return name;
    }

    State(String name) {
        this.name = name;
    }
}
