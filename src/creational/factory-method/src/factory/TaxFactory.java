package factory;

import creator.TaxReportCreator;
import creator.impl.IncomeTaxCreator;
import creator.impl.VehicleTaxCreator;
import enums.TaxReportType;

public class TaxFactory {

    public static TaxReportCreator getTaxReportCreator(TaxReportType taxReportType) {
        if (taxReportType == TaxReportType.INCOME_TAX) {
            return new IncomeTaxCreator();
        } else if (taxReportType == TaxReportType.VEHICLE_TAX) {
            return new VehicleTaxCreator();
        }
        return null;
    }
}
