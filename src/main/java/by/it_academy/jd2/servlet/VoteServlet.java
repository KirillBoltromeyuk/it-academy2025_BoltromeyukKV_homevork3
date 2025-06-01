package by.it_academy.jd2.servlet;

import by.it_academy.jd2.service.VoteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    VoteService voteService = new VoteService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String singer = req.getParameter("singer");
        String[] genres = req.getParameterValues("genre");
        String about = req.getParameter("about");

        if(singer == null){
            resp.sendError(400, "Нужно выбрать одного исполнителя!");
        }
        if(!voteService.addSingerVote(singer)){
            resp.sendError(404, "Такого исполнителя нет в списке!");
        }
        if(genres == null || genres.length == 0){
            resp.sendError(400, "Нужно выбрать от одного до пяти жанров!");
        }
        if(genres.length < 3|| genres.length > 5){
            resp.sendError(400, "Нужно выбрать от одного до пяти жанров!");
        }
        for(String genre : genres){
            if(!voteService.addGenreVote(genre)){
                resp.sendError(404,"Такого жанра нет в списке!");
            }
        }
        if (about == null){
            resp.sendError(400, "Поле о себе не должно быть пустым");
        }
        voteService.addAbout(about);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect(req.getContextPath() + "/result");
    }
}
