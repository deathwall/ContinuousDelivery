package com.fr.training.entities;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Game {

	@Id
    public String id;

    public String name;
    public String platform;

    public Game() {}

    public Game(String name, String platform) {
        this.name = name;
        this.platform = platform;
    }

    @Override
    public String toString() {
        return String.format("Game[id=%s, name='%s', platform='%s']",id, name, platform);
    }
}
