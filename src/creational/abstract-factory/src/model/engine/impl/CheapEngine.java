package model.engine.impl;

import model.engine.Engine;

public class CheapEngine implements Engine {
    @Override
    public String getCylinderCount() {
        return "1";
    }

    @Override
    public String getCC() {
        return "125";
    }
}
