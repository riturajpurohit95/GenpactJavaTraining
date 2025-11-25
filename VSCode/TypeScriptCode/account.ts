class BankAccount{
    private holder : string;
    private balance :number;
 
    constructor(holder : string, initialBalance: number=0){
        this.holder=holder;
        this.balance=initialBalance;
    }
    deposit(amount:number) :string{
        if(amount<=0)
            return `Deposit Amount should be positive!`;
        this.balance+=amount;
        return `Deposited ${amount}. New Balance: ${this.balance}`;
    }
    withdraw(amount: number) : string{
        if(amount<=0)
            return `Withdraw Amount should be positive`;
        if(amount>this.balance)
            return `Insufficient Balance`;
        this.balance -=amount;
        return `Withdrawn ${amount}. New Balance: ${this.balance}`;
    }
    getBalance(): number{
        return this.balance;
    }
    getHolder(): string{
        return this.holder;
    }
}
//Attach to global app.js
(window as any).BankAccount = BankAccount