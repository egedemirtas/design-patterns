package creator.impl;

import creator.TaxReportCreator;
import model.TaxReport;
import enums.TaxReportType;
import model.VehicleTaxReport;

public class VehicleTaxCreator implements TaxReportCreator {
    @Override
    public TaxReport createTaxReport() {
        System.out.println("createTaxReport for vehicle called.");
        return new VehicleTaxReport(TaxReportType.VEHICLE_TAX);
    }
}
