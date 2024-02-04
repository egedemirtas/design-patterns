package factory.motorcycle;

import enums.EngineType;
import enums.WeelManufacturer;
import model.engine.Engine;
import model.wheel.Wheel;

public interface MotorcycleFactory {
    Engine getEngine();

    Wheel getWheel();
}
