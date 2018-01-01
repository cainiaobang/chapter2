package org.smart4j.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.Helper.DataBaseHelper;
import org.smart4j.chapter2.Model.Customer;
import org.smart4j.chapter2.Service.CustomerService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {
    private final CustomerService customerService;
    public static final Logger LOGGER= LoggerFactory.getLogger(CustomerServiceTest.class);

    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }


    @Before
    public void init() {
        String  file="sql/customer_init.sql";
        InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        BufferedReader reader=new BufferedReader((new InputStreamReader(is)));
        try{
            String sql;
            while((sql=reader.readLine())!=null){
                DataBaseHelper.executeUpdate(sql);
            }
        }catch (Exception e ){
            LOGGER.error("execute sql file failure",e);
            throw new RuntimeException(e);
        }

    }

    @Test
    public void getCustomerListTest()  throws Exception{
        List<Customer> list=customerService.getCustomerList();
        Assert.assertEquals(2,list.size());
    }

    @Test
    public void createCustomer() throws Exception{
        Map<String, Object> map=new HashMap<String , Object>();
        map.put("name","customer3");
        customerService.createCustomer(map);
    }



}
