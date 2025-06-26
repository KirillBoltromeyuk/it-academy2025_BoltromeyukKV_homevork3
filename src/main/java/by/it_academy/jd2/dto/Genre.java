package by.it_academy.jd2.dto;

public class Genre {
    private int id;
    private String genre;
    private int countOfVotes;

    public Genre(String genre) {
        this.genre = genre;
        this.countOfVotes = 0;
    }

    public Genre(String genre, int countOfVotes) {
        this.genre = genre;
        this.countOfVotes = countOfVotes;
    }

    public Genre(int id, String genre, int countOfVotes) {
        this.id = id;
        this.genre = genre;
        this.countOfVotes = countOfVotes;
    }

    public void addVote (){
        this.countOfVotes++;
    }

    public String getGenre() {
        return genre;
    }

    public int getCountOfVotes() {
        return countOfVotes;
    }

    public int getId() {
        return id;
    }


}
