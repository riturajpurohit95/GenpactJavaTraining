var BankAccount = /** @class */ (function () {
    function BankAccount(holder, initialBalance) {
        if (initialBalance === void 0) { initialBalance = 0; }
        this.holder = holder;
        this.balance = initialBalance;
    }
    BankAccount.prototype.deposit = function (amount) {
        if (amount <= 0)
            return "Deposit Amount should be positive!";
        this.balance += amount;
        return "Deposited ".concat(amount, ". New Balance: ").concat(this.balance);
    };
    BankAccount.prototype.withdraw = function (amount) {
        if (amount <= 0)
            return "Withdraw Amount should be positive";
        if (amount > this.balance)
            return "Insufficient Balance";
        this.balance -= amount;
        return "Withdrawn ".concat(amount, ". New Balance: ").concat(this.balance);
    };
    BankAccount.prototype.getBalance = function () {
        return this.balance;
    };
    BankAccount.prototype.getHolder = function () {
        return this.holder;
    };
    return BankAccount;
}());
//Attach to global app.js
window.BankAccount = BankAccount;
