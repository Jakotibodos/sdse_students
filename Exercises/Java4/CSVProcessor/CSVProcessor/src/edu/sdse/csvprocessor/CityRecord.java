/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sdse.csvprocessor;

/**
 *
 * @author jakot
 */
public class CityRecord {
    private int id;
    private int year;
    private String city;
    private int population;
    
    
    public CityRecord(int id, int year, String city, int population){
        this.id = id;
        this.year = year;
        this.city = city;
        this.population = population;
        
    }
    
    @Override
    public String toString(){
        return "id: "+id+",year: "+year+",city: "+city+",population: "+population;
    }    
    
}
