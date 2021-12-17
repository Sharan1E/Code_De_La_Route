package com.example.code_de_la_route;

public class Listview_element {
    private String themeName;
    private String themeNumber;

    private String themelogoName;

    public Listview_element(String themeNumber, String themeName, String themelogoName) {
        this.themeName = themeName;
        this.themelogoName = themelogoName;
        this.themeNumber = themeNumber;
    }

    public String getThemeNumber() {
        return themeNumber;
    }

    public void setThemeNumber(String themeNumber) { this.themeNumber = themeNumber;}

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemelogoName() {
        return themelogoName;
    }

    public void setThemelogoName(String themelogoName) {
        this.themelogoName = themelogoName;
    }

}
