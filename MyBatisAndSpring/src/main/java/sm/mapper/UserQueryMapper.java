package sm.mapper;

import sm.po.User;

public interface UserQueryMapper
{
	  public User findUserById(int id) throws Exception;
}
