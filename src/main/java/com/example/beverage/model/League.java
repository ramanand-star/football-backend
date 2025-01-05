package com.example.beverage.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class League {
    private String country_id;
    private String country_name;
    private String league_id;
    private String league_name;
    private String league_season;
    private String league_logo;
    private String country_logo;
}
