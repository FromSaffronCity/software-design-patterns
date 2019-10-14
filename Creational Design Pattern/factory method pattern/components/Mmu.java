package components;

public abstract class Mmu {
    private String name;

    public Mmu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
