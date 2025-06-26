package by.it_academy.jd2.controller;

import by.it_academy.jd2.service.VoteService;
import by.it_academy.jd2.service.VoteServiceOld;
import by.it_academy.jd2.service.api.IVoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    private final IVoteService voteService = new VoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("artistsList", voteService.getArtists());
        req.setAttribute("genresList", voteService.getGenres());
        req.setAttribute("aboutsList", voteService.getAbouts());
        req.getRequestDispatcher("templates/result.jsp").forward(req, resp);

    }

}
