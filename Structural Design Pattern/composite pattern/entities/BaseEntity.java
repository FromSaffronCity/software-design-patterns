package entities;

public abstract class BaseEntity {
    private String name;
    private String type;
    private BaseEntity parent;

    public BaseEntity(String name, String type, BaseEntity parent) {
        this.name = name;
        this.type = type;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public BaseEntity getParent() {
        return parent;
    }

    public abstract String getDirectory();
    public abstract int getComponentCount();
    public abstract String getList(int spaceCount);

    public String getDetails() {
        return "Name: "+name+"\n"+"Type: "+type+"\n"+"Directory: "+getDirectory()+"\n"+"Component Count: "+getComponentCount()+"\n";
    }

    public void addEntity(BaseEntity targetEntity) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public void removeEntity(BaseEntity targetEntity) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public BaseEntity getChild(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /* additional */
    public abstract int getChildCount();
}
