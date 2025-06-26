package by.it_academy.jd2.controller;

import by.it_academy.jd2.dto.About;
import by.it_academy.jd2.dto.Artist;
import by.it_academy.jd2.dto.Genre;
import by.it_academy.jd2.dto.Vote;
import by.it_academy.jd2.service.VoteService;
import by.it_academy.jd2.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    IVoteService voteService = new VoteService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String artistName = req.getParameter("artist");
        String[] genreNames = req.getParameterValues("genre");
        String about = req.getParameter("about");

        if (artistName == null) {
            resp.sendError(400, "Нужно выбрать одного исполнителя!");
        }
        if (genreNames == null || genreNames.length == 0) {
            resp.sendError(400, "Нужно выбрать от трёх до пяти жанров!");
        }
        assert genreNames != null;
        if (genreNames.length < 3 || genreNames.length > 5) {
            resp.sendError(400, "Нужно выбрать от трёх до пяти жанров!");
        }
        if (about == null) {
            resp.sendError(400, "Поле о себе не должно быть пустым");
        }


        List<Genre> genres = new ArrayList<>();
        for (String genreName : genreNames) {
            genres.add(new Genre(genreName));
        }

        Vote vote = new Vote(new Artist(artistName), genres, new About(about));
        if(voteService.addVote(vote) ) resp.sendRedirect("/result");
        else resp.sendError(500 ,"Голос не был добавлен!");

    }
}
