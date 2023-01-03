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
    public  CheckingAccount(String id, double  initialBalance, double rate)
    {
        super(id, initialBalance,rate);
            }
      public  CheckingAccount()
      {
          this("No",0,0);
      }
      
      public static void main(String[] args) {
CheckingAccount ca=new CheckingAccount("ff",100,1);
ca.credit(2000);
ca.debit(1000);
}
      @Override
      public void debit ( double amount )
{    
balance = balance - amount;
if (super.getBalance()<0)
{
    System.out.println("注意！支票帳戶透支");
     System.out.println("帳戶餘額還有"+super.getBalance());
}
}
}
