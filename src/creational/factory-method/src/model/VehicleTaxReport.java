package model;

import enums.TaxReportType;

public class VehicleTaxReport extends TaxReport {
    public VehicleTaxReport(TaxReportType taxReportType) {
        super();
        this.taxReportType = taxReportType;
        System.out.println("Vehicle tax constructor called.");

    }
}
