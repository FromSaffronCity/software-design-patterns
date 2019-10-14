package entities;

public class LeafEntity extends BaseEntity {
    /* files */
    public LeafEntity(String name, String type, BaseEntity parent) {
        super(name, type, parent);
    }

    @Override
    public String getDirectory() {
        return getParent().getDirectory()+"\\"+getName();
    }

    @Override
    public int getComponentCount() {
        return 0;  // there is no leaf entity under a particular leaf entity
    }

    @Override
    public String getList(int spaceCount) {
        String temp = "";

        for(int i=0; i<spaceCount; i++) {
            temp += " ";
        }

        return temp+">> "+getName()+"\n";
    }

    @Override
    public int getChildCount() {
        return 0;  // leaf has no child
    }
}
