package com.qa.AccountProject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Account accountOne = new Account("Brother", "Buddy");
        Account accountTwo = new Account("Sister", "Mary");
        
        Service service = new Service();
        
        Data data = new Data();
        
        service.Add(data, accountOne);
        service.Add(data, accountTwo);
        
        System.out.println(service.Retrieve(data));
        
    }
}
