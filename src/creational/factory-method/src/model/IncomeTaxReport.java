package model;

import enums.TaxReportType;

public class IncomeTaxReport extends TaxReport {
    public IncomeTaxReport(TaxReportType taxReportType) {
        super();
        this.taxReportType = taxReportType;
        System.out.println("Income tax constructor called.");
    }

}
