package com.example.beverage.controller;

import com.example.beverage.model.Country;
import com.example.beverage.model.League;
import com.example.beverage.model.Player;
import com.example.beverage.model.Team;
import com.example.beverage.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin
public class CountryController {

    @Autowired
    private CountryService service;

    //http://localhost:8080/countries
    @GetMapping("/countries")
    public Flux<Country> getCountries() {
        //country_id 44 is UK
        return service.getCountries();
    }

  //http://localhost:8080/leagues?countryId=44
    @GetMapping("/leagues")
    public Flux<League> getLeaguesByCountry(@RequestParam String countryId) {
        return service.getLeaguesByCountry(countryId);
    }
//http://localhost:8080/teams?leagueId=302
    @GetMapping("/teams")
    public Flux<Team> getTeamsByLeague(@RequestParam String leagueId) {
        return service.getTeamsByLeague(leagueId);
    }
//http://localhost:8080/players?playerName=Benzema
    @GetMapping("/players")
    public Flux<Player> getPlayersByName(@RequestParam String playerName) {
        return service.getPlayersByName(playerName);
    }


}
