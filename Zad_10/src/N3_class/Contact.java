package N3_class;

public abstract class Contact {
    protected final String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void sendMessage();
    public abstract void print();
}
