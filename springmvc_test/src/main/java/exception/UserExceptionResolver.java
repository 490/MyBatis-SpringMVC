package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class UserExceptionResolver implements HandlerExceptionResolver
{
    @Override  
    public ModelAndView resolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex)
    {
        UserException userException=null;
        if(ex instanceof UserException)
        {
            userException=(UserException)ex;
              
        }else
            {
        	userException=new UserException("unknown error----");
        }  
        String message=userException.getMessage();
        ModelAndView modelAndView=new ModelAndView();   
        modelAndView.addObject("message",message);
        modelAndView.setViewName("/error/userError");
        return modelAndView;  
    }  
}  
