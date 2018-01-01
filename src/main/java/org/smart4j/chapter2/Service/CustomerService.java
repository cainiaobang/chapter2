package org.smart4j.chapter2.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.Helper.DataBaseHelper;
import org.smart4j.chapter2.Model.Customer;
import org.smart4j.chapter2.Util.PropsUtil;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class CustomerService {

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerService.class);
    public List<Customer> getCustomerList() {
            String sql = "SELECT * FROM customer";
           return DataBaseHelper.queryEntityList(Customer.class,sql);
}



    public Customer getCustomer(long id){
        String sql="SELECT * FROM customer where id = "+id;
        return DataBaseHelper.queryEntity(Customer.class,sql);
    }

    public boolean createCustomer(Map<String ,Object> fieldMap){
        return DataBaseHelper.insertEntity(Customer.class,fieldMap);
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        return DataBaseHelper.updateEntity(Customer.class,id, fieldMap);
    }

    public boolean deleteCustomer(long id){
        return DataBaseHelper.delateEntity(Customer.class,id);
    }



}
