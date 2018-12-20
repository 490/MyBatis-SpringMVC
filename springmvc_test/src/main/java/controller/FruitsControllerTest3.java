package controller;

import model.Fruits;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FruitsControllerTest3
{
    private FruitsService fruitsService = new FruitsServiceImpl();
    @RequestMapping("/queryFruitsList")
    public ModelAndView queryFruitsList() throws Exception
    {
        List<Fruits> fruitsList = fruitsService.queryFruitsList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("fruitsList",fruitsList);
        modelAndView.setViewName("WEB-INF/jsp/fruits/fruitsList.jsp");
        return modelAndView;
    }
}
