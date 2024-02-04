package factory.motorcycle.impl;

import factory.motorcycle.MotorcycleFactory;
import model.engine.Engine;
import model.engine.impl.CheapEngine;
import model.wheel.Wheel;
import model.wheel.impl.CheapWheel;

public class CheapMotorcycleFactory implements MotorcycleFactory {
    @Override
    public Engine getEngine() {
        return new CheapEngine();
    }

    @Override
    public Wheel getWheel() {
        return new CheapWheel();
    }
}
