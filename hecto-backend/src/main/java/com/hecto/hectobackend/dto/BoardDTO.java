package com.hecto.hectobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long id;
    private String boardWriter;
    private String boardTitle;
    private String boardContents;
    private String createdAt;

}
