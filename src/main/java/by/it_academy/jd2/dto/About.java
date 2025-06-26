package by.it_academy.jd2.dto;

import java.time.LocalDateTime;

public class About {
    private int id;
    private String text;
    private LocalDateTime date;
    public About(String text) {
        this.text = text;
        this.date = LocalDateTime.now();
    }

    public About(String text, LocalDateTime date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
