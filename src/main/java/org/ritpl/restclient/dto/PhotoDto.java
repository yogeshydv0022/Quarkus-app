package org.ritpl.restclient.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDto {

    private Long albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

}
