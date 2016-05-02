public class Accounts{
    
    private double[] accountArr = new double[10];   
    
    /***********
     * This method accepts an in for the account to work with and a double for the
     * transaction ammount. It also locks the account to ensure that no other thread
     * will get access to said account when it is being manipulated.
     *********/
    public synchronized void deposit(int account, double amount){
        accountArr[account] += amount;
        return;
    }

    /***********
     * This method accepts an in for the account to work with and a double for the
     * transaction ammount. It also locks the account to ensure that no other thread
     * will get access to said account when it is being manipulated.
     *********/
    public synchronized void withdraw(int account, double amount){
        if(accountArr[account] - amount < 0)
            System.out.println("ERROR: not enough money in " + account);
        else
             accountArr[account] -= amount;
        return;
    }
    
    /***********
     * This method prints out the balances of all the accounts.
     *********/
    public void printBalances(){
        for(int i = 0; i < 10; i++){
            System.out.println("Account " + i + ": " + accountArr[i]);
        }
        return;
    }
    
}