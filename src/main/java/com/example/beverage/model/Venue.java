package com.example.beverage.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    private String venue_name;
    private String venue_address;
    private String venue_city;
    private String venue_capacity;
    private String venue_surface;
}
