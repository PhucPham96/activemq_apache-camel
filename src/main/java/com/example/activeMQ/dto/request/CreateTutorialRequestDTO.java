package com.example.activeMQ.dto.request;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTutorialRequestDTO {

    public String title;
    public String description;
    public String published;
}
