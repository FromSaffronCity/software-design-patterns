package components;

public abstract class Cpu {
    private String name;

    public Cpu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
