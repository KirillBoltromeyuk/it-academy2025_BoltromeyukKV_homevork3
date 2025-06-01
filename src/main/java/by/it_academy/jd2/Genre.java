package by.it_academy.jd2;

public class Genre {
    private String genre;
    private int countOfVotes;

    public Genre(String genre) {
        this.genre = genre;
        this.countOfVotes = 0;
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


}
