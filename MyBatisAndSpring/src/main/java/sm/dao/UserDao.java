package sm.dao;

import sm.po.User;
public interface UserDao
{
    public User findUserById(int id) throws Exception;
}  