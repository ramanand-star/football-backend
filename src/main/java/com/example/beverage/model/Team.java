package com.example.beverage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private String team_key;
    private String team_name;
    private String team_country;
    private String team_founded;
    private String team_badge;
    private Venue venue;
    private List<Player> players;
    private List<Coach> coaches;
}
