package by.it_academy.jd2.storage;

import by.it_academy.jd2.dto.About;
import by.it_academy.jd2.dto.Artist;
import by.it_academy.jd2.dto.Genre;
import by.it_academy.jd2.dto.Vote;
import by.it_academy.jd2.storage.api.IVoteStorage;
import by.it_academy.jd2.storage.api.PostgresConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class VoteStoragePostgres implements IVoteStorage {
    @Override
    public boolean addVote(Vote vote) {
        Artist artist = vote.getArtist();
        List<Genre> genres = vote.getGenres();
        About about = vote.getAbout();
        if(!artistExists(artist.getName())){return false;}
        for(Genre genre : genres){
            if(!genreExists(genre.getGenre())){return false;}
        }
        artist=getArtistByName(artist.getName());
        List<Genre> newGenres =new ArrayList<>();
        for(Genre genre : genres){
            genre=getGenreByName(genre.getGenre());
            newGenres.add(genre);
        }
        assert artist != null;
        if(!updateArtist(artist)){return false;}
        for(Genre genre : newGenres){
            if(!updateGenre(genre)){return false;}
        }
        String sql ="INSERT INTO vote_app.votes (now(), artist_id, genre_1_id, genre_2_id, genre_3_id, genre_4_id, genre_5_id, about) "+
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement preparedStatement= PostgresConnection.get().prepareStatement(sql)){
            preparedStatement.setInt(1, artist.getId());
            int index =2;
            for(Genre genre : newGenres){
                preparedStatement.setInt(index, genre.getId());
                index++;
            }
            preparedStatement.setString(7, about.getText());
            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();
        String sql ="SELECT name, count_of_votes FROM vote_app.artists";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery() ){
            while(resultSet.next()){
                artists.add(new Artist(resultSet.getString("name"), resultSet.getInt("count_of_votes")));
            }
            return artists;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();
        String sql ="SELECT name, count_of_votes FROM vote_app.genres";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                genres.add(new Genre(resultSet.getString("name"), resultSet.getInt("count_of_votes")));
            }
            return genres;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<About> getAbouts() {
        List<About> abouts = new ArrayList<>();
        String sql ="SELECT dt_create, about FROM vote_app.votes";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                abouts.add(new About(resultSet.getString("about"), resultSet.getTimestamp("dt_create").toLocalDateTime()));
            }
            return abouts;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private boolean artistExists(String artistName) {
        String sql = "SELECT * FROM vote_app.artists WHERE name = ?";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql)){
            preparedStatement.setString(1, artistName);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            return resultSet.next();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    private boolean genreExists(String genreName) {
        String sql = "SELECT * FROM vote_app.genres WHERE name = ?";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql)){
            preparedStatement.setString(1, genreName);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            return resultSet.next();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    private Artist getArtistByName(String name) {
        String sql = "select id, count_of_votes from vote_app.artists where name = ?";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql)){
           preparedStatement.setString(1, name);
           preparedStatement.executeQuery();
           ResultSet resultSet = preparedStatement.getResultSet();
           resultSet.next();
           int id = resultSet.getInt("id");
           int count = resultSet.getInt("count_of_votes");
           return new Artist(id, name, count);
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    private Genre getGenreByName(String name) {
        String sql = "select id, count_of_votes from vote_app.genres where name = ?";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            int id = resultSet.getInt("id");
            int count = resultSet.getInt("count_of_votes");
            return new Genre(id, name, count);
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }
    private boolean updateArtist(Artist artist) {
        String sql = "UPDATE vote_app.artists SET count_of_votes = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql)){
            preparedStatement.setInt(1, artist.getCountOfVotes()+1);
            preparedStatement.setInt(2, artist.getId());
            return true;
        }   catch (SQLException e){
            throw new RuntimeException();
        }
    }
    private boolean updateGenre(Genre genre) {
        String sql = "UPDATE vote_app.genres SET count_of_votes = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = PostgresConnection.get().prepareStatement(sql)){
            preparedStatement.setInt(1, genre.getCountOfVotes()+1);
            preparedStatement.setInt(2, genre.getId());
            return true;
        }   catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
