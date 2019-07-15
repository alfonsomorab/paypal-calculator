package xyz.alfonso.paypalcalc.models;

import org.json.JSONObject;

public class Wallet {

    private String name;
    private Currency currency;
    private Double amount;

    public Wallet(String name, Currency currency, Double amount) {
        this.name = name;
        this.currency = currency;
        this.amount = amount;
    }

    public Wallet() {

        this.name = "";
        this.currency = new Currency();
        this.amount = 0.0;
    }

    public Wallet(JSONObject json) {
        this.name = json.optString("name");
        this.currency = new Currency(json.optJSONObject("currency"));
        this.amount = json.optDouble("amount", 0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
