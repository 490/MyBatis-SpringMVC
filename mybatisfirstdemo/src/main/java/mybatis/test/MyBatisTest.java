import mybatis.datasource.DataConnection;
import mybatis.po.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MyBatisTest
{
    public DataConnection dataConn=new DataConnection();
    PropertyConfigurator propertyConfigurator = new PropertyConfigurator();

    @Test
    public void TestSelect() throws IOException {
        SqlSession sqlSession=dataConn.getSqlSession();
        User user=sqlSession.selectOne("test.findUserById",1);
        System.out.println("姓名:"+user.getUsername());
        System.out.println("性别:"+user.getGender());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("生日:"+sdf.format(user.getBirthday()));
        System.out.println("所在地:"+user.getProvince()+user.getCity());
        sqlSession.close();
    }
    @Test
    public void TestfuzzySearch() throws IOException
    {
        SqlSession sqlSession = dataConn.getSqlSession();
        List<User> list = sqlSession.selectList("test.findUserByUsername","孙");
        for(int i = 0;i < list.size();i++)
        {
            User u = list.get(i);
            System.out.println(u.getUsername());
        }
        sqlSession.close();
    }
    @Test
    public void TestInsert() throws Exception
    {
        SqlSession sqlSession=dataConn.getSqlSession();
        User user=new User();
        user.setUsername("孙佳佳");
        user.setGender("男");
        user.setPassword("5555");
        user.setEmail("5555@126.com");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("1991-02-16"));
        user.setProvince("湖北省");
        user.setCity("武汉市");
        sqlSession.insert("test.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testBatchCustomer() throws Exception
    {
        SqlSession sqlSession = dataConn.getSqlSession();
        List<BatchItem> bcList = sqlSession.selectList("findBatchCustomerToMap");
        if(bcList!=null)
        {
            BatchItem batchItem = null;
            Customer customer  = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(int i = 0;i < bcList.size();i++)
            {
                batchItem = bcList.get(i);
                customer = batchItem.getCustomer();
                System.out.println("卡号："+customer.getAcno()+"\n姓名："+customer.getUsername()
                +"\n时间："+sdf.format(batchItem.getCreatetime())+"\n批号："+batchItem.getNumber()+"\n"+customer.getGender());
            }
        }
        sqlSession.close();
    }
    @Test
    public void testfindBatchAndBatchDetail() throws Exception
    {
        SqlSession sqlSession=dataConn.getSqlSession();
        BatchItem batchItem=sqlSession.selectOne("findBatchAndBatchDetail");
        if(batchItem!=null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Customer customer = batchItem.getCustomer();
            List<BatchDetail> batchDetails = batchItem.getBatchDetails();
            System.out.println("卡号："+customer.getAcno()+"\n姓名："+customer.getUsername()+"\n批次："+batchItem.getNumber());
            BatchDetail batchDetail=null;
            if(batchDetails!=null)
            {
                for(int i = 0;i < batchDetails.size();i++)
                {
                    batchDetail = batchDetails.get(i);
                    System.out.println("id:"+batchDetail.getProduct_id());
                }
            }
        }
        sqlSession.close();
    }
    @Test
    public void testFindCustomerOnMapper() throws Exception
    {
        SqlSession sqlSession = dataConn.getSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.findCustomerById(1);
        System.out.println(customer.getUsername());
        sqlSession.close();
    }

    @Test
    public void testFindCustomerCache1() throws  Exception
    {
             System.setProperty("log4j.configuration", "E:\\BUAA\\mybatisfirstdemo\\config\\log4j.properties");
        SqlSession sqlSession = dataConn.getSqlSession();
        Customer customer1 = sqlSession.selectOne("findCustomerById",1);
        System.out.println("name="+customer1.getUsername());

        Customer customer2 = sqlSession.selectOne("findCustomerById",1);
        System.out.println("name="+customer2.getUsername());
        sqlSession.close();
    }
}
