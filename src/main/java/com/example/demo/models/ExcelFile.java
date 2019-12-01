package com.example.demo.models;

import org.apache.commons.collections4.map.MultiKeyMap;

public class ExcelFile {

    private String classe;
    private String spell;
    private String school;
    private String level;
    private String savingThrow;
    private Boolean ritual;
    private Boolean concentration;
    private String castTime;
    private String range;
    private MultiKeyMap components;
    private String duration;
    private String description;

    public ExcelFile() {}

    public ExcelFile(String classe, String spell, String school, String level, String savingThrow, Boolean ritual, Boolean concentration, String castTime, String range, MultiKeyMap components, String duration, String description) {
        this.classe = classe;
        this.spell = spell;
        this.school = school;
        this.level = level;
        this.savingThrow = savingThrow;
        this.ritual = ritual;
        this.concentration = concentration;
        this.castTime = castTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(String savingThrow) {
        this.savingThrow = savingThrow;
    }

    public Boolean getRitual() {
        return ritual;
    }

    public void setRitual(Boolean ritual) {
        this.ritual = ritual;
    }

    public Boolean getConcentration() {
        return concentration;
    }

    public void setConcentration(Boolean concentration) {
        this.concentration = concentration;
    }

    public String getCastTime() {
        return castTime;
    }

    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public MultiKeyMap getComponents() {
        return components;
    }

    public void setComponents(MultiKeyMap components) {
        this.components = components;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
