package model.engine.impl;

import model.engine.Engine;

public class ExpensiveEngine implements Engine {
    @Override
    public String getCylinderCount() {
        return "2";
    }

    @Override
    public String getCC() {
        return "700";
    }
}
