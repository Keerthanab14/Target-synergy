package com.example.synergybackend.model;


public class Background {
    private int opacity;
    private String bgColor;
    private String textColor;

    public Background(int opacity, String bgColor, String textColor) {
        this.opacity = opacity;
        this.bgColor = bgColor;
        this.textColor = textColor;
    }

    public int getOpacity() {
        return opacity;
    }

    public void setOpacity(int opacity) {
        this.opacity = opacity;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
}
