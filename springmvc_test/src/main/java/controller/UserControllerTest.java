package controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import exception.UserException;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserControllerTest
{
    @InitBinder
    public void initBinder(DataBinder binder)
    {
        binder.setValidator(new UserValidator());
    }
    @RequestMapping("toLogin")
    public String toLoginPage()
    {
        return "/user/login";
    }
    private boolean checkBlackList(User user)
    {
        String black[] = {"jack","tim"};
        for(int i = 0;i<black.length;i++)
        {
            if(user.getUsername().equals(black[i]))
                return true;
        }
        return false;
    }
   /* @RequestMapping("login")
    public String login(Model model , @Valid User user, BindingResult bindingResult)throws UserException
    {
        boolean isblack=checkBlackList(user);
        if(isblack)
        {
            throw new UserException("无权限");
        }
        List<ObjectError> allErrors = null;
        if(bindingResult.hasErrors())
        {
            allErrors = bindingResult.getAllErrors();
            for(ObjectError objectError:allErrors)
            {
                System.out.println("code="+objectError.getCode()+"  DefaultMessage="+objectError.getDefaultMessage());

                model.addAttribute("allErrors",allErrors);
            }
            return "/user/login";
        }else
        {

        }
        return "/user/loginsuccess";

    }*/
   @RequestMapping("login")
   public String login(Model model, HttpServletRequest request,User user) throws UserException,IOException
   {
       boolean flag = checkUser(user);
       if(flag)
       {
           request.getSession().setAttribute("user",user);
       }else{
           model.addAttribute("errorMsg","cuowu");
            return "/user/login";
       }
       return "/user/loginsuccess";
   }
   private boolean checkUser(User u)
   {
       if(u.getUsername().equals("zhang") &&u.getPassword().equals("123"))
       {
           return true;
       }
       return false;
   }
   @RequestMapping("loginout")
   public String loginout(Model model,HttpServletRequest request)throws UserException,IOException
   {
       if(request.getSession().getAttribute("user")!=null)
       {
           request.getSession().removeAttribute("user");
       }else{
           model.addAttribute("errorMsg","注销失败");
       }
       return "/user/login";
   }
}
