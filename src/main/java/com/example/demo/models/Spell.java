package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "school", "cast_time", "range", "components", "duration", "description" })
public class Spell {

    private String school;
    private String castTime;
    private String range;
    private String components;
    private String duration;
    private String description;

    public Spell() {
    }

    public Spell(String school, String castTime, String range, String components, String duration, String description) {
        this.school = school;
        this.castTime = castTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.description = description;
    }

    @JsonGetter("school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @JsonGetter("cast_time")
    public String getCastTime() {
        return castTime;
    }

    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    @JsonGetter("range")
    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    @JsonGetter("components")
    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    @JsonGetter("duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    @JsonGetter("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Spell{" +
                "school='" + school + '\'' +
                ", castTime='" + castTime + '\'' +
                ", range='" + range + '\'' +
                ", components='" + components + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
