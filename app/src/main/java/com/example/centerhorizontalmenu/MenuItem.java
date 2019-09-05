package com.example.centerhorizontalmenu;

/**
 * Created by Rayaane Abdessmad on 03/09/19.
 */
public class MenuItem {

    private String name;
    private Boolean isSelected;

    public MenuItem(String name, Boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}
