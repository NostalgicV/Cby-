package com.cby.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Style {
    private int id;
    private String name;

    public Style(String name) {
        this.name = name;
    }
}
