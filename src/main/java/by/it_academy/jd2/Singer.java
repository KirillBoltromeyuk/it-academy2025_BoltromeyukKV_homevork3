package by.it_academy.jd2;

public class Singer {
    private String name;
    private int countOfVotes;
    public Singer(String name) {
        this.name = name;
        countOfVotes = 0;
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
}