package by.it_academy.jd2.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Vote {
    private int id;
    private LocalDateTime dateCreated;
    private Artist artist;
    private List<Genre> genres;
    private About about;

    public Vote(Artist artist, List<Genre> genres, About about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }
}
