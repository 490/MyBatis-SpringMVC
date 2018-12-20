package mybatis.po;

public interface CustomerMapper {
    public Customer findCustomerById(int id) throws Exception;
    public void insertCustomer(Customer customer) throws Exception;
    public void deleteCustomer(int id) throws Exception;
    public void updateCustomer(Customer customer) throws Exception;

}
