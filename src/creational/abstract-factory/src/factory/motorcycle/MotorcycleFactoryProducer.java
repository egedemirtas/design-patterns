package factory.motorcycle;

import enums.MotorcycleType;
import factory.motorcycle.impl.CheapMotorcycleFactory;
import factory.motorcycle.impl.ExpensiveMotorcycleFactory;

public class MotorcycleFactoryProducer {
    public static MotorcycleFactory getMotorcycleFactory(MotorcycleType motorcycleType){
        if (motorcycleType == MotorcycleType.EXPENSIVE) {
            System.out.println("Creating Expensive Motorcycle");
            return new ExpensiveMotorcycleFactory();
        } else if (motorcycleType == MotorcycleType.CHEAP){
            System.out.println("Creating Cheap Motorcycle");
            return new CheapMotorcycleFactory();
        }
        return null;
    }
}
