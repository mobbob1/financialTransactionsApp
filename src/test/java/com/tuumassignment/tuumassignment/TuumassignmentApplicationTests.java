package com.tuumassignment.tuumassignment;

import com.tuumassignment.tuumassignment.mappers.AccountMapper;
import com.tuumassignment.tuumassignment.model.Account;
import com.tuumassignment.tuumassignment.util.Currency;
import java.net.URI;
import java.net.URISyntaxException;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
class TuumassignmentApplicationTests {

    @Autowired
    AccountMapper accountMapper;
    
    
    public void createAccount(){
    Account account = new Account();
    account.setAccountid(1);
    account.setBalance(3000);
    account.setCountry("Germany");
    account.setCurrency(Currency.EUR);
    account.setCustomer(1);
    accountMapper.insertAccount(account);
    }
    
//      @Test
//    public void testEmployee(){
//        System.out.println("testEmployee");
//        Account accountByID = accountMapper.findAccountById(1);
//        Assert.class
//    }
	
@Test
public void testCreateAccount() throws URISyntaxException  
{
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:8080"  + "/createAccount";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
     
    //Verify request succeed
    //Assert.assertEquals(200, result.getStatusCodeValue());

}
@Test
public void testFindAccountById() throws URISyntaxException  
{
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:8080"  + "/findAccountById/1";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
     
    //Verify request succeed
    //Assert.assertEquals(200, result.getStatusCodeValue());

}
@Test
public void testCreateTransaction() throws URISyntaxException  
{
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:8080"  + "/createTransaction";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
     
    //Verify request succeed
    //Assert.assertEquals(200, result.getStatusCodeValue());

}
@Test
public void testFindTransactionByAccountId() throws URISyntaxException  
{
    RestTemplate restTemplate = new RestTemplate();
     
    final String baseUrl = "http://localhost:8080"  + "/findTransactionByAccountId/1";
    URI uri = new URI(baseUrl);
 
    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
     
    //Verify request succeed
    //Assert.assertEquals(200, result.getStatusCodeValue());

}
}
