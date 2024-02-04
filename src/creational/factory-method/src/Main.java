import creator.TaxReportCreator;
import factory.TaxFactory;
import model.TaxReport;
import enums.TaxReportType;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating tax issuer for income");
        TaxReportCreator taxCreator = TaxFactory.getTaxReportCreator(TaxReportType.INCOME_TAX);
        TaxReport incomeTaxReport = taxCreator.createTaxReport();

        System.out.println("Creating tax issuer for vehicle");
        taxCreator = TaxFactory.getTaxReportCreator(TaxReportType.VEHICLE_TAX);
        TaxReport vehicleTaxReport = taxCreator.createTaxReport();
    }
}