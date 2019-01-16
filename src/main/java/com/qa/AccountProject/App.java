package com.qa.AccountProject;

import com.google.gson.Gson;

public class App 
{
    public static void main( String[] args )
    {
        Account accountOne = new Account("Brother", "Buddy");
        Account accountTwo = new Account("Sister", "Mary");
        Account accountThree = new Account("Cousin", "Susan");
        
        Data data = new Data();
        
        Service.add(data, accountOne);
        Service.add(data, accountTwo);
        Service.add(data, accountThree);
        
        System.out.println(new Gson().toJson(Service.retrieve(data)));
        
        System.out.println(Service.countAccounts(data, "Sister"));
        
    }
}
