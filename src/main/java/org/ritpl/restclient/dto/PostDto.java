package org.ritpl.restclient.dto;

import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class PostDto {

    private Long userId;
    private long id;
    private String title;
    private String body;
    private URL link;
    private int comment_count;

}
