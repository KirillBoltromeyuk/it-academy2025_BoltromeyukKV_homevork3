package by.it_academy.jd2.dto;

public class Artist {
    private int id;
    private String name;
    private int countOfVotes;
    public Artist(String name) {
        this.name = name;
        countOfVotes = 0;
    }

    public Artist(String name, int countOfVotes) {
        this.name = name;
        this.countOfVotes = countOfVotes;
    }

    public Artist(int id, String name, int countOfVotes) {
        this.id = id;
        this.name = name;
        this.countOfVotes = countOfVotes;
    }

    public void addVote(){
        countOfVotes++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getCountOfVotes() {
        return countOfVotes;
    }

    public  void setCountOfVotes(int countOfVotes) {
        this.countOfVotes = countOfVotes;
    }

    public int getId() {
        return id;
    }
}