package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import Utilities.Conversions;

@Entity
public class Reading extends Model {
    public String name;
    public int code;
    public double temperature;
    public double windSpeed;
    public double windDirection;
    public int pressure;



    public Reading(String name, int code, double temperature, double windSpeed, int pressure) {
        this.name = name;
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }

    public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure) {

        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

    //getters
    public String getName(){
        return name;
    }
    public int getCode(){
        return code;
    }
    public double getTemperature(){
        return temperature;
    }
    public double getWindSpeed(){
        return windSpeed;
    }
    public double getWindDirection(){
        return windDirection;
    }
    public int getPressure(){
        return pressure;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setCode(int code){
        this.code = code;
    }
    public void setTemperature(double temperature){
        this.temperature = temperature;
    }
    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }
    public void setWindDirection(double windDirection){
        this.windDirection = windDirection;
    }
    public void setPressure(int pressure){
        this.pressure = pressure;
    }
}