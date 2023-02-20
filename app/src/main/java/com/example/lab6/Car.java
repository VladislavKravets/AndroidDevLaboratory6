package com.example.lab6;

public class Car {
    private final String brand;
    private final String model;
    private final String country; // страна производитель
    private final String drive; // привод
    private final int horsepower; // лошадиные силы
    private final float engine; // двигатель

    public Car(String brand, String model, String country, String drive, int horsepower, float engine) {
        this.brand = brand;
        this.model = model;
        this.country = country;
        this.drive = drive;
        this.horsepower = horsepower;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    public String getDrive() {
        return drive;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public float getEngine() {
        return engine;
    }
}
