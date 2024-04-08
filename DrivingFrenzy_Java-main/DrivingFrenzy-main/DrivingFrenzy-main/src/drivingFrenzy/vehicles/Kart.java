package drivingFrenzy.vehicles;

import drivingFrenzy.race.Section;

//Implementación de nuevo tipo de vehçiculo, con nuevos atributos para marchas(dos marchas con su min y max velocidad)

public class Kart implements Vehicle {

    private int number;
    private String driver;
    private int currentSpeed;
    private int maxSpeed;
    private String description;

    //atributo para la marcha
    private int gear;

    //atributo maxima velocidad 1marcha
    private double maxSpeed1Gear;

    //atributo minima valocidad 1marcha
    private double minSpeed1Gear;

    //atributo maxima velocidad 2marcha
    private double maxSpeed2Gear;

    //atributo minima valocidad 2marcha
    private double minSpeed2Gear;



    public Kart(int number, String driver, int currentSpeed, int maxSpeed, String description, int gear, double maxSpeed1Gear, double minSpeed1Gear, double maxSpeed2Gear, double minSpeed2Gear) {
        super();
        this.number = number;
        this.driver = driver;
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
        this.description = description;
        this.gear = gear;
        this.maxSpeed1Gear = maxSpeed1Gear;
        this.minSpeed1Gear = minSpeed1Gear;
        this.maxSpeed2Gear = maxSpeed2Gear;
        this.minSpeed2Gear = minSpeed2Gear;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getCurrentSpeed() {
        return currentSpeed;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String adaptSpeed(Section nextSection) {
        String result = "";
        if (nextSection.getTheoreticalMaxSpeed() > currentSpeed) {
            int nextSpeed =  Math.min(maxSpeed, nextSection.getTheoreticalMaxSpeed());
            result += "El número " + number + " acelera desde " + currentSpeed + " a " + nextSpeed + ". ";
            currentSpeed = nextSpeed;
            if (maxSpeed == currentSpeed) {
                result += driver + " aprieta a fondo, pero su " + description + " está al límite!";
            }
        } else {
            currentSpeed = nextSection.getTheoreticalMaxSpeed();
            result += "El número " + number + " reduce la velocidad a " + currentSpeed;
        }
        return result;
    }

    @Override
    public int increaseGear() {
        if (gear == 1) {
            gear = 2;
            minSpeed2Gear = maxSpeed1Gear;
        }
        return gear;
    }


    @Override
    public int decreaseGear() {
        if (gear == 2) {
            gear = 1;
            maxSpeed1Gear = minSpeed2Gear;
        }
        return gear;
    }
}
