package com.example.beverage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String player_key;
    private String player_id;
    private String player_image;
    private String player_name;
    private String player_number;
    private String player_country;
    private String player_type;
    private String player_age;
    private String player_match_played;
    private String player_goals;
    private String player_yellow_cards;
    private String player_red_cards;
    private String player_injured;
    private String player_substitute_out;
    private String player_substitutes_on_bench;
    private String player_assists;
    private String player_birthdate;
    private String player_is_captain;
    private String player_goals_conceded;
    private String player_fouls_committed;
    private String player_clearances;
    private String player_saves;
    private String player_inside_box_saves;
    private String player_duels_total;
    private String player_duels_won;
    private String player_dribble_attempts;
    private String player_dribble_succ;
    private String player_passes;
    private String player_passes_accuracy;
    private String player_rating;
}
