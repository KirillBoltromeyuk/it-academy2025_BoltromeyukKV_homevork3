package by.it_academy.jd2.servlet;

import by.it_academy.jd2.service.VoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    private final VoteService voteService = new VoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("artistsList", voteService.getSingers());
        req.setAttribute("genresList", voteService.getGenres());
        req.getRequestDispatcher("templates/form.jsp").forward(req, resp);
    }
}
