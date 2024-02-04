package creator.impl;

import creator.TaxReportCreator;
import model.IncomeTaxReport;
import model.TaxReport;
import enums.TaxReportType;

public class IncomeTaxCreator implements TaxReportCreator {
    @Override
    public TaxReport createTaxReport() {
        System.out.println("createTaxReport for income called.");
        return new IncomeTaxReport(TaxReportType.INCOME_TAX);
    }
}
