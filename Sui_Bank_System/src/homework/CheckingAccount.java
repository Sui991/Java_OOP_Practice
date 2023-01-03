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
public class CheckingAccount extends Account {
    public  CheckingAccount(String id, double balance, double rate)
    {
        super(id,balance,rate);
            }
      public  CheckingAccount()
      {
          this("No",0,0);
      }
      @Override
      public void debit ( double amount )
{    
super.debit(amount);
if (super.getBalance()<0)
{
    System.out.println("注意！支票帳戶透支");
}
}
}
