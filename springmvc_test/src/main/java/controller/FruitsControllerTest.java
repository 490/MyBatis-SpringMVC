package controller;
import model.Fruits;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class FruitsControllerTest implements Controller
{
    private FruitsService fruitsService = new FruitsServiceImpl();

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)throws Exception
    {
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fruitsList",fruitsList);
        modelAndView.setViewName("WEB-INF/jsp/fruits/fruitsList.jsp");
        return modelAndView;
    }
}

