package controller;
import model.Fruits;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FruitsControllerTest2 implements HttpRequestHandler
{
    private FruitsService fruitsService = new FruitsServiceImpl();
    @Override
    public void handleRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
    {
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
     //   request.setAttribute("fruitsList",fruitsList);
      //  request.getRequestDispatcher("WEB-INF/jsp/fruits/fruitsList.jsp").forward(request,response);
        String jsoninfo = convertListToJson(fruitsList);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsoninfo);
    }
    private String convertListToJson(List<Fruits> fruitsList)
    {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for(Fruits fruits:fruitsList)
        {
            builder.append('{');
            builder.append("\"name\":\"").append(fruits.getName()).append("\",");
            builder.append("\"price\":\"").append(fruits.getPrice()).append("\",");
            builder.append("\"area\":\"").append(fruits.getProducing_area()).append("\",");
            builder.append("},");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(']');
        return builder.toString();
    }
}
