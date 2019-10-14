package components;

public abstract class Resolution {
    private String name;
    private int x;
    private int y;

    public Resolution(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x+"x"+y;
    }
}
