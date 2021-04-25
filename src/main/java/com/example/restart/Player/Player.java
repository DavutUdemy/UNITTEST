package com.example.restart.Player;

import javax.persistence.*;

@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(
            name = "player_sequence",
            sequenceName = "player_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "player_sequence"

    )
    private Long Id;
    private String name;
    private String lastName;

    public Player() {
    }

    public Player(Long id, String name, String lastName) {
        Id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Player(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
