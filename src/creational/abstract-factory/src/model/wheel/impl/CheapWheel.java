package model.wheel.impl;

import enums.WeelManufacturer;
import model.wheel.Wheel;

public class CheapWheel implements Wheel {
    @Override
    public WeelManufacturer getManufacturer() {
        return WeelManufacturer.UNKNOWN;
    }
}
