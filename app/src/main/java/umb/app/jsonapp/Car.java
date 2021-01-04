package umb.app.jsonapp;

public class Car {

    private String Name;
    private String Color;
    private String value;


    public Car(String name, String value, String color) {
        Name = name;
        Color = color;
        this.value = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
