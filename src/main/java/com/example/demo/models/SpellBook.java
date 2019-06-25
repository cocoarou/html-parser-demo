package com.example.demo.models;

import java.util.List;

public class SpellBook {

    private List<String> spells;

    public SpellBook() {

    }

    public SpellBook(List<String> spells) {
        this.spells = spells;
    }

    public List<String> getSpells() {
        return spells;
    }

    public void setSpells(List<String> spells) {
        this.spells = spells;
    }

    @Override
    public String toString() {
        return "SpellBook{" +
                "spells=" + spells +
                '}';
    }
}
