package com.example.beverage;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TeamStandingServiceTest {

    @Autowired
    private TeamStandingService service;

    @MockBean
    private TeamStandingRepository repository;

    //@Test
    public void testGetTeamStanding() {
        TeamStanding standing = new TeamStanding();
        standing.setCountry("England");
        standing.setLeague("Premier League");
        standing.setTeam("Manchester United");
        standing.setPosition(1);

        Mockito.when(repository.findByCountryAndLeagueAndTeam("England", "Premier League", "Manchester United"))
                .thenReturn(Optional.of(standing));

        Optional<TeamStanding> result = service.getTeamStanding("England", "Premier League", "Manchester United");
        assertTrue(result.isPresent());
    }
}