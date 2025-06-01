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
    VoteService voteService = new VoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        Writer writer = resp.getWriter();
        writer.write("Результаты голосования:");
        writer.write("");
        writer.write("Исполнители:");
        writer.write("<table border=1>");
        writer.write("<tr>");
        writer.write("<th>Исполнитель</th>");
        writer.write("<th>Число голосов</th>");
        writer.write("</tr>");
        List<Singer> singers = voteService.getSingers();
        List<Genre> genres = voteService.getGenres();
        List<About> abouts = voteService.getAbouts();

        for (Singer singer : singers) {
            writer.write("<tr>");
            writer.write("<td>" + singer.getName() + "</td>");
            writer.write("<td>" + singer.getCountOfVotes() + "</td>");
            writer.write("</tr>");
        }

        writer.write("</table>");
        writer.write("");
        writer.write("Жанры:");
        writer.write("<table border=1>");
        writer.write("<tr>");
        writer.write("<th>Жанр</th>");
        writer.write("<th>Число голосов</th>");
        writer.write("</tr>");
        for (Genre genre : genres) {
            writer.write("<tr>");
            writer.write("<td>" + genre.getGenre() + "</td>");
            writer.write("<td>" + genre.getCountOfVotes() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");
        writer.write("");
        writer.write("О голосовавших:");
        writer.write("<table border=1>");
        writer.write("<tr>");
        writer.write("<th>Текст</th>");
        writer.write("<th>Дата</th>");
        writer.write("</tr>");
        for (About about : abouts) {
            writer.write("<tr>");
            writer.write("<td>" + about.getText() + "</td>");
            writer.write("<td>" + about.getDate() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");
    }

}
