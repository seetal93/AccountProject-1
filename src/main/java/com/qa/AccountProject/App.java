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
        Account accountThree = new Account("Cousin", "Susan");
        
        Data data = new Data();
        
        Service.Add(data, accountOne);
        Service.Add(data, accountTwo);
        Service.Add(data, accountThree);
        
        System.out.println(Service.Retrieve(data));
        
    }
}
