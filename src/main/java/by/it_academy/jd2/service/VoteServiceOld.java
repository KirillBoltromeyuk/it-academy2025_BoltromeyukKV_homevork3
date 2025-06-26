package by.it_academy.jd2.service;

import by.it_academy.jd2.dto.About;
import by.it_academy.jd2.dto.Artist;
import by.it_academy.jd2.dto.Genre;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class VoteServiceOld {
    private static List<Artist> artists = new ArrayList<>();
    private static List<Genre> genres= new ArrayList<>();
    private static List<About> abouts=new ArrayList<>();
    private Artist artist1 =new Artist("Александр Горлодёр");
    private Artist artist2 =new Artist("Анастасия Ультразвуковна");
    private Artist artist3 =new Artist("Филипп Микрофонов");
    private Artist artist4 =new Artist("Николай Фонограммов");

    private Genre genre1=new Genre("Рок");
    private Genre genre2=new Genre("Рэп");
    private Genre genre3=new Genre("Джаз");
    private Genre genre4=new Genre("Поп");
    private Genre genre5=new Genre("Классика");
    private Genre genre6=new Genre("Шансон");
    private Genre genre7=new Genre("Блюз");
    private Genre genre8=new Genre("Фолк");
    private Genre genre9=new Genre("Метал");
    private Genre genre10=new Genre("Оркестровая музыка");

    public VoteServiceOld() {
        if(artists.isEmpty()){
            artists.add(artist1);
            artists.add(artist2);
            artists.add(artist3);
            artists.add(artist4);
        }
        if(genres.isEmpty()){
            genres.add(genre1);
            genres.add(genre2);
            genres.add(genre3);
            genres.add(genre4);
            genres.add(genre5);
            genres.add(genre6);
            genres.add(genre7);
            genres.add(genre8);
            genres.add(genre9);
            genres.add(genre10);
        }
    }
    public List<Artist> getSingers() {
        artists.sort(new Comparator<Artist>() {
            public int compare(Artist artist1, Artist artist2) {
                int votes1 = artist1.getCountOfVotes();
                int votes2 = artist2.getCountOfVotes();
                if (votes1 < votes2) {
                    return 1;
                } else if (votes1 > votes2) {
                    return -1;
                }
                return 0;
            }
        });
        return artists;
    }
    public List<Genre> getGenres() {
        genres.sort(new Comparator<Genre>() {
            public int compare(Genre genre1, Genre genre2) {
                int votes1 = genre1.getCountOfVotes();
                int votes2 = genre2.getCountOfVotes();
                if (votes1 < votes2) {
                    return 1;
                }else if (votes1 > votes2) {
                    return -1;
                }
                return 0;
            }
        });
        return genres;
    }
    public List<About> getAbouts() {
        abouts.sort(new Comparator<About>() {
            public int compare(About about1, About about2) {
                LocalDateTime about1Date = about1.getDate();
                LocalDateTime about2Date = about2.getDate();
                if (about1Date.isBefore(about2Date)) {
                    return 1;
                }else if (about1Date.isAfter(about2Date)) {
                    return -1;
                }
                return 0;
            }
        });
        return abouts;
    }
    public boolean addSingerVote(String singerName) {
        for (Artist artist : artists) {
            if (artist.getName().equals(singerName)) {
                artist.addVote();
                return true;
            }
        }
        return false;
    }

    public boolean addGenreVote(String genreName) {
        for (Genre genre : genres) {
            if(genre.getGenre().equals(genreName)) {
                genre.addVote();
                return true;
            }
        }
        return false;
    }

    public void addAbout(String about) {
        abouts.addLast(new About(about));
    }
    public List<String> getSingerNames(){
        List<String> singerNames = new ArrayList<>();
        for (Artist artist : artists) {
            singerNames.add(artist.getName());
        }
        return singerNames;
    }
}
