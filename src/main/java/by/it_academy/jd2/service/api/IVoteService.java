package by.it_academy.jd2.service.api;

import by.it_academy.jd2.dto.About;
import by.it_academy.jd2.dto.Artist;
import by.it_academy.jd2.dto.Genre;
import by.it_academy.jd2.dto.Vote;

import java.util.List;

public interface IVoteService {
    boolean addVote(Vote vote);
    List<Artist> getArtists();
    List<Genre> getGenres();
    List<About> getAbouts();

}
