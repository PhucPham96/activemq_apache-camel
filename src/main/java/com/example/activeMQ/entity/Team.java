package com.example.activeMQ.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    private Long id;
    private String name;
    private Long playerId;
    private String playerName;

}
