package com.example.stateflagquiz;

public class StateItem {
    String name;
    String capitals;
    int image;

    public StateItem(String name, int image,String capitals ){
        this.name = name;
        this.image = image;
        this.capitals = capitals;

    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getCapitals() {
        return capitals;
    }
}
