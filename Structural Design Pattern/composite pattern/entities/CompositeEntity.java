package entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class CompositeEntity extends BaseEntity {
    /* root, drives, folders */
    private List<BaseEntity> childList;

    public CompositeEntity(String name, String type, BaseEntity parent) {
        super(name, type, parent);
        childList = new ArrayList<>();
    }

    @Override
    public String getDirectory() {
        if(getParent() == null) {
            return getName();
        } else {
            return getParent().getDirectory()+"\\"+getName();
        }
    }

    @Override
    public int getComponentCount() {
        Iterator iterator = childList.iterator();  // NOTICE
        int componentCount = 0;

        while(iterator.hasNext()) {
            BaseEntity targetEntity = (BaseEntity) iterator.next();

            if(targetEntity.getType().equalsIgnoreCase("file")) {
                componentCount++;
            } else {
                componentCount += targetEntity.getComponentCount();
            }
        }

        return componentCount;
    }

    @Override
    public String getList(int spaceCount) {
        Iterator iterator = childList.iterator();  // NOTICE
        String temp = "";

        for(int i=0; i<spaceCount; i++) {
            temp += " ";
        }

        temp += ">> "+getName()+"\n";

        while(iterator.hasNext()) {
            BaseEntity targetEntity = (BaseEntity) iterator.next();

            temp += targetEntity.getList(spaceCount+2);  // NOTICE
        }

        return temp;
    }

    @Override
    public void addEntity(BaseEntity targetEntity) {
        childList.add(targetEntity);
        return ;
    }

    @Override
    public void removeEntity(BaseEntity targetEntity) {
        childList.remove(targetEntity);
        return ;
    }

    @Override
    public BaseEntity getChild(int index) {
        return childList.get(index);
    }

    @Override
    public int getChildCount() {
        return childList.size();
    }
}
