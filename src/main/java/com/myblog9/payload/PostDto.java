package com.myblog9.payload;

import lombok.*;

import java.util.List;
import java.util.stream.Collector;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;


    public Object Collect(Collector<Object, ?, List<Object>> list) {
        return null;
    }
}
