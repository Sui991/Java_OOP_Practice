/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

/**
 *
 * @author user
 */
public abstract class Account {
 private String id;
 double balance ;
private double rate; 
//Constructor
public Account( String id, double initialBalance, double rate)
{
this(initialBalance);
this.id = id;
this.rate = rate;
    
}
//Constructor
public Account ( double initialBalance )
{
if ( initialBalance > 0.0 )
this.balance = initialBalance;
else
this.balance = 0;
}
public void credit ( double amount )
{
balance = balance + amount;
}
public double getBalance()
{
return balance;
}
public abstract void debit ( double amount );
};




