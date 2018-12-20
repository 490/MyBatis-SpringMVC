package sm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sm.mapper.UserMapper;
import sm.mapper.UserQueryMapper;
import sm.po.User;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class UserMapperTest {
private ApplicationContext applicationContext;  
    
    @Before
    public void setup() throws Exception{  
        applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }  
      
    @Test  
    public void testFindUserById() throws Exception
    {
    	UserQueryMapper userQueryMapper=(UserQueryMapper)applicationContext.getBean("userQueryMapper");
        User user=userQueryMapper.findUserById(1);
        System.out.println(user.getId()+":"+user.getUsername());
    }
    @Test
    public void testgenerate() throws Exception
    {
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");
        User user1 = new User();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user1.setUsername("zhaozhaozhao");
        user1.setPassword("12345");
        user1.setGender("male");
        user1.setBirthday(sdf.parse("1992-01-01"));
        user1.setCity("bj");
        user1.setProvince("bj");
        user1.setEmail("@@");
        userMapper.insert(user1);
        System.out.println("1.insert:"+user1.getUsername());
    }
}
