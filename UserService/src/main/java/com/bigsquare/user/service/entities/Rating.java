package com.bigsquare.user.service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @JsonProperty("id")
    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String feedback;

    private Hotel hotel;


}
