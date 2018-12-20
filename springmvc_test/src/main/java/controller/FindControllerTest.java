package controller;


import model.Fruits;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("query")
public class FindControllerTest
{
    private FruitsService fruitsService = new FruitsServiceImpl();
    @RequestMapping("queryFruitsByCondition")
    public String queryFruitsByCondition(Model model, @Validated Fruits fruits, BindingResult bindingResult)
    {
        List<ObjectError> allErrors = null;
        if(bindingResult.hasErrors())
        {
            allErrors = bindingResult.getAllErrors();
            for(ObjectError objectError:allErrors)
            {
               // System.out.println(objectError.getDefaultMessage());
            }
        }
        List<Fruits> findList = null;
        if(fruits==null||(fruits.getName()==null&&fruits.getProducing_area()==null))
        {
           // System.out.println("1111\n\n");
            findList=fruitsService.queryFruitsList();
        }
        else
        {
          //  System.out.println("2222_____\n\n");
            findList=fruitsService.queryFruitsByCondition(fruits);
        }
        model.addAttribute("fruitsList",findList);
        model.addAttribute("allErrors",allErrors);
        return "/fruits/findFruits";
    }
}
