package xyz.alfonso.paypalcalc.models;

import org.json.JSONObject;

public class Currency {

    private String name;
    private String symbol;
    private String abbreviation;

    public Currency(String name, String symbol, String abbreviation) {
        this.name = name;
        this.symbol = symbol;
        this.abbreviation = abbreviation;
    }

    public Currency(){
        this.name = "";
        this.symbol = "";
        this.abbreviation = "";
    }

    public Currency(JSONObject json) {

        this.name = json.optString("name");
        this.symbol = json.optString("symbol");
        this.abbreviation = json.optString("abbreviation");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
