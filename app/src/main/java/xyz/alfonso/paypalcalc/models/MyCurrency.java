package xyz.alfonso.paypalcalc.models;

public class MyCurrency extends Currency {

    private Double sell;
    private Double buy;

    public MyCurrency(String name, String symbol, String abbreviation, Double sell, Double buy) {
        super(name, symbol, abbreviation);
        this.sell = sell;
        this.buy = buy;
    }

    public MyCurrency() {

        super();
        this.sell = 0.0;
        this.buy = 0.0;

    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }
}
