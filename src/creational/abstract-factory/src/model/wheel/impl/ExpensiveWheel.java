package model.wheel.impl;

import enums.WeelManufacturer;
import model.wheel.Wheel;

public class ExpensiveWheel implements Wheel {
    @Override
    public WeelManufacturer getManufacturer() {
        return WeelManufacturer.PIRELLI;
    }
}
