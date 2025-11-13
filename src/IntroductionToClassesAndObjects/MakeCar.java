package IntroductionToClassesAndObjects;

// Remember to put the code into a file with the same name of the
//   "public class", i.e., "MakeCar.java".


import java.util.Scanner;

public class MakeCar
{
    public static void main(String[] args)
    {

        // Declare the first car, i.e., c1, and create the object for c1
        // Here, we use the constructor to initialize the object
        Car c1 = new Car (123, 6, "Q123456");

        // Declare the second car, i.e., c2, and create the object for c2
        // We only use the "default constructor" with no initialization (will be introduced later)
        Car c2 = new Car();

        // Initialize the values of the attributes in c2
        c2.setCarID(124);
        c2.setNumberOfWheels(8);
        c2.setNumberPlate("W654321");

        // Show the info of two cars
        c1.printCarInfo();
        System.out.println("--------");
        c2.printCarInfo();

        // Speed up the first car c1 and see what happens
        c1.accelerate();
        c1.accelerate();
        c1.accelerate();

//        System.out.println("********************");
//        Car.numCarsWorld += 1;
        c1.printCarInfo();
        c2.printCarInfo();

//        Car.numCarsWorld += 1;
        c1.printCarInfo();
        c2.printCarInfo();
    }
}


class Car
{
    // Attributes are defined here
    private int carID;  // A unique ID of a car
    private int numberOfWheels = 0;
    private String numberPlate;
    private double speed = 0.0;

    public static int numCarsWorld = 0;

    // Two constructors are defined here

    // This is the so-called "default constructor" without any parameter and statement inside.
    public Car() {
        // an empty constructor
    }

    // This is another constructor with three parameters to initialize the corresponding attributes.
    // Note that the constructors can be overloaded as well (will introduce later).
    public Car(int carID, int numberOfWheels, String numberPlate) {
        this.setCarID(carID);
        this.setNumberOfWheels(numberOfWheels);
        this.setNumberPlate(numberPlate);
    }

    // Setters and getters start here
    public void setCarID(Car this, int carID) {
        // Pay attention to the reference of "this.carID" and "carID"
        //   in the following assignment statement.
        this.carID = carID;
    }

    public int getNumberOfWheels()
    {
        return this.numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels)
    {
        this.numberOfWheels = numberOfWheels;
    }

    public String getNumberPlate()
    {
        return this.numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    // A method to print the basic information of a car
    public void printCarInfo() {
        System.out.printf(
                "CarID: %d%nNumber Plate: %s%n# Wheels: %d%n# Cars in the world: %d%n",
                this.carID,
                this.numberPlate,
                this.numberOfWheels,
                numCarsWorld
        );
    }

    // A method to speed up the car
    public void accelerate() {
        this.speed += 10.0;
        System.out.printf(
                "Current speed: %.2f%n",
                this.speed
        );
    }
}