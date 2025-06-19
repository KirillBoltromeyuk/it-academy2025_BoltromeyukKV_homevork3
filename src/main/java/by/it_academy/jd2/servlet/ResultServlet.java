package by.it_academy.jd2.servlet;

import by.it_academy.jd2.About;
import by.it_academy.jd2.Genre;
import by.it_academy.jd2.Singer;
import by.it_academy.jd2.service.VoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet(urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    private final VoteService voteService = new VoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("artistsList", voteService.getSingers());
        req.setAttribute("genresList", voteService.getGenres());
        req.setAttribute("aboutsList", voteService.getAbouts());
        req.getRequestDispatcher("templates/result.jsp").forward(req, resp);

    }

}
