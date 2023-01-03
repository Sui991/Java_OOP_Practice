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
public class SavingsAccount extends Account {
    public SavingsAccount(String id, double initialBalance, double rate)
    {
        super(id,initialBalance,rate);
    }
     public  SavingsAccount()
      {
          this("No",0,0);
      }
     public void debit ( double amount )
{  if (super.getBalance()>=0)
{balance = balance - amount;
 System.out.println("帳戶餘額還有"+super.getBalance());
   }
  
else
     System.out.println("注意！帳戶餘額不足，無法提領 ");

}
      public static void main(String[] args) {
SavingsAccount sa=new SavingsAccount("GG",1000,1);
sa.debit(100);
}
}