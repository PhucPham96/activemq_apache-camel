package com.example.activeMQ.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTutorialResponseDTO {

    public String id;
    public String title;
    public String description;
    public String published;
}
