package com.example.beverage.service;

import com.example.beverage.model.Country;
import com.example.beverage.model.League;
import com.example.beverage.model.Player;
import com.example.beverage.model.Team;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class CountryService {

    private final WebClient webClient;
    @Value("${api.football.key}")
    private String apiKey;

    //docker.repo1.uhc.com/dpaas/tokenization-file-service-java:2.1.9

    public CountryService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://apiv3.apifootball.com").build();
    }

    public Flux<Country> getCountries() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("action", "get_countries")
                        .queryParam("APIkey", apiKey)
                        .build())
                .retrieve()
                .bodyToFlux(Country.class);
    }

    public Flux<League> getLeaguesByCountry(String countryId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("action", "get_leagues")
                        .queryParam("country_id", countryId)
                        .queryParam("APIkey", apiKey)
                        .build())
                .retrieve()
                .bodyToFlux(League.class);
    }

    public Flux<Team> getTeamsByLeague(String leagueId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("action", "get_teams")
                        .queryParam("league_id", leagueId)
                        .queryParam("APIkey", apiKey)
                        .build())
                .retrieve()
                .bodyToFlux(Team.class);
    }

    public Flux<Player> getPlayersByName(String playerName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("action", "get_players")
                        .queryParam("player_name", playerName)
                        .queryParam("APIkey", apiKey)
                        .build())
                .retrieve()
                .bodyToFlux(Player.class);
    }
}
