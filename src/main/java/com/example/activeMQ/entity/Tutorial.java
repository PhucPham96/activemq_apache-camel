package com.example.activeMQ.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
    private Long id;
    private String description;
    private Boolean published;
    private String title;
}
