import enums.MotorcycleType;
import factory.motorcycle.MotorcycleFactory;
import factory.motorcycle.MotorcycleFactoryProducer;
import model.engine.Engine;
import model.wheel.Wheel;

public class Main {
    public static void main(String[] args) {
        MotorcycleFactory motorcycleFactory = MotorcycleFactoryProducer.getMotorcycleFactory(MotorcycleType.EXPENSIVE);

        Engine engine = motorcycleFactory.getEngine();
        System.out.println("Engine cc: " + engine.getCC());

        Wheel wheel = motorcycleFactory.getWheel();
        System.out.println("Wheel manufacturer: " + wheel.getManufacturer());

    }
}