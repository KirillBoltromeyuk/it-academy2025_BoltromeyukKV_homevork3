package by.it_academy.jd2.service;

import by.it_academy.jd2.dto.About;
import by.it_academy.jd2.dto.Artist;
import by.it_academy.jd2.dto.Genre;
import by.it_academy.jd2.dto.Vote;
import by.it_academy.jd2.service.api.IVoteService;
import by.it_academy.jd2.storage.VoteStoragePostgres;
import by.it_academy.jd2.storage.api.IVoteStorage;

import java.util.List;

public class VoteService implements IVoteService {
    private final IVoteStorage voteStorage=new VoteStoragePostgres();
    @Override
    public boolean addVote(Vote vote) {
        if(vote.getArtist()==null){return false;}
        List<Genre> genres = vote.getGenres();
        if(genres==null||genres.size()<3||genres.size()>5){return false;}
        return voteStorage.addVote(vote);
    }

    @Override
    public List<Artist> getArtists() {
        return voteStorage.getArtists();
    }

    @Override
    public List<Genre> getGenres() {
        return voteStorage.getGenres();
    }

    @Override
    public List<About> getAbouts() {
        return voteStorage.getAbouts();
    }
}
