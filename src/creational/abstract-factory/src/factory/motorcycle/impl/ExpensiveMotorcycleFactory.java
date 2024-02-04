package factory.motorcycle.impl;

import enums.EngineType;
import enums.WeelManufacturer;
import factory.motorcycle.MotorcycleFactory;
import model.engine.Engine;
import model.engine.impl.ExpensiveEngine;
import model.wheel.Wheel;
import model.wheel.impl.ExpensiveWheel;

public class ExpensiveMotorcycleFactory implements MotorcycleFactory {
    @Override
    public Engine getEngine() {
        System.out.println("Creating Expensive Engine");
        return new ExpensiveEngine();
    }

    @Override
    public Wheel getWheel() {
        System.out.println("Creating Expensive Wheel");
        return new ExpensiveWheel();
    }
}
