package ec.edu.epn;

public class TaxCalculator {

    /**
     * Calculates the total amount after applying tax.
     * @param valor The initial amount.
     * @param impuesto The tax percentage to apply.
     * @return The total amount after tax.
     */
    public double calculateTax(double valor, double impuesto){
        return (valor * (1 + (impuesto / 100)));
    }
}
