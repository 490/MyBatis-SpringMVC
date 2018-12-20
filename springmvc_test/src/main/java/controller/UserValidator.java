package controller;

import model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

public class UserValidator implements Validator
{
    public boolean supports(Class<?> clazz)
    {
        return User.class.equals(clazz);
    }
    public void validate(Object obj,Errors errors)
    {
        ValidationUtils.rejectIfEmpty(errors,"username","Username.is.empty"
        ,"用户名不能为空");
        User user = (User)obj;
        if(null==user.getPassword() || "".equals(user.getPassword()))
        {
            errors.rejectValue("password","Password.is.empty","密码不能为空");
        }else if(user.getPassword().length()<6)
        {
            errors.rejectValue("password","length.too.short","密码长度不得少于6位");
        }
    }
}
