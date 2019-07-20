package com.wx.domain;

public class Film {
    private Short film_id;
    private String title;
    private String description;
    private Short language_id;

    public Short getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Short film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Short language_id) {
        this.language_id = language_id;
    }
}
