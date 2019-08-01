package com.test.demo.test.design_pattern.factory_pattern;

/**
 * Created by DEV002 on 2018/6/25.
 */

public class CarFactory {

    private Car car;

    private CarName carName;

    public CarFactory(CarName carName) {
        this.carName = carName;
    }

    public Car getCar(){
        switch (carName){
            case BMW:
                return new BMWCar();
            case BENZ:
                return new BenzCar();
            case AUDI:
                return new AudiCar();
            case BENTLY:
                return new BentlyCar();
            case LAMBORGHINI:
                return new LamborghiniCar();
            case FERRARI:
                return new FerrariCar();
            default:
                return null;
        }
    }

}
