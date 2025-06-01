package by.it_academy.jd2;

import java.time.LocalDateTime;

public class About {
    private String text;
    private LocalDateTime date;
    public About(String text) {
        this.text = text;
        this.date = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
