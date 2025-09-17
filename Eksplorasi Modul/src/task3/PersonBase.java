package task3;

/**
 * PersonBase as a simple superclass reused by Employee and others.
 */
public class PersonBase {
    private final String name;

    public PersonBase(String name) {
        this.name = name == null ? "Unknown" : name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonBase[name=" + name + "]";
    }
}
