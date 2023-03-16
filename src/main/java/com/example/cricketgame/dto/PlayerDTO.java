package com.example.cricketgame.dto;


import com.example.cricketgame.Entities.PlayerTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    private String id;
    private String name;
    private PlayerTitle title;
}
