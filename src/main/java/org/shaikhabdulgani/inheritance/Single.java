package org.shaikhabdulgani.inheritance;

class Vehicle {
    private String brand;
    private String model;

    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    void start(){
        System.out.println("Starting...");
        System.out.println("Started");
    }
}

class Car extends Vehicle{

    private int numberOfTires;

    public Car(String brand, String model, int numberOfTires) {
        super(brand, model);
        this.numberOfTires = numberOfTires;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    @Override
    void start() {
        System.out.println("Car is starting.");
    }
}

public class Single {
    public static void main(String[] args) {
        Car car = new Car("Audi","A4",4);
        car.start();
        System.out.println("Car has "+car.getNumberOfTires()+" tires");
        System.out.printf("Car brand is %s and model is %s\n",car.getBrand(),car.getModel());
    }
}
