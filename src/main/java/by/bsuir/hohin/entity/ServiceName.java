package by.bsuir.hohin.entity;

public enum ServiceName {
    GROTTY("Grotty"),
    POSH("Posh");

    private final String name;

    private ServiceName(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
