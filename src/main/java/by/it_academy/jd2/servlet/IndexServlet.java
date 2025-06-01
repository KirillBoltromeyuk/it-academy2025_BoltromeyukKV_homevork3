package by.it_academy.jd2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        writer.write("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                " <head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>Тег FORM</title>\n" +
                " </head>\n" +
                " <body>\n" +
                "\n" +
                " <form action=\"http://localhost:8080/Homework3-1.0-SNAPSHOT/vote\" method=\"POST\">\n" +
                "  <p><b>Ваш любимый исполнитель?</b></p>\n" +
                "  <p><input type=\"radio\" name=\"singer\" value=\"Александр Горлодёр\">Александр Горлодёр<Br>\n" +
                "  <input type=\"radio\" name=\"singer\" value=\"Анастасия Ультразвуковна\">Анастасия Ультразвуковна<Br>\n" +
                "  <input type=\"radio\" name=\"singer\" value=\"Филипп Микрофонов\">Филипп Микрофонов<Br>\n" +
                "  <input type=\"radio\" name=\"singer\" value=\"Николай Фонограммов\">Николай Фонограммов</p>\n" +
                "  \n" +
                "  <p><b>Ваши любимые жанры?</b></p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Рок\">Рок</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Рэп\">Рэп</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Джаз\">Джаз</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Поп\">Поп</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Классика\">Классика</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Шансон\">Шансон</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Блюз\">Блюз</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Фолк\">Фолк</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Метал\">Метал</p>\n" +
                "  <input type=\"checkbox\" name=\"genre\" value=\"Оркестровая музыка\">Оркестровая музыка</p>\n" +
                " \n" +
                "  \n" +
                "  \n" +
                "  <p><b>Расскажите о себе?</b></p>\n" +
                "  <textarea name=\"about\"></textarea>\n" +
                "  <p><input type=\"submit\"></p>\n" +
                " </form>\n" +
                "\n" +
                " </body>\n" +
                "</html>");
    }
}
