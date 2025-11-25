var account = null;
var ops = document.getElementById('accountOperations');
var accountInfo = document.getElementById('accountInfo');
document.getElementById('createBtn').addEventListener('click', function () {
    var name = document.getElementById('holderName').value.trim();
    var initialBal = parseFloat(document.getElementById('initialBalance').value) || 0;
    account = new window.BankAccount(name, initialBal);
    accountInfo.textContent = "".concat(account.getHolder(), " - ").concat(account.getBalance());
    console.log('Account Object created: ', account);
});
document.getElementById('depositBtn').addEventListener('click', function () {
    var amt = parseFloat(document.getElementById('depositAmount').value) || 0;
    var res = account.deposit(amt);
    accountInfo.textContent = "".concat(account.getHolder(), " - ").concat(account.getBalance());
    console.log(res);
});
document.getElementById('withdrawBtn').addEventListener('click', function () {
    var amt = parseFloat(document.getElementById('withdrawAmount').value) || 0;
    var res = account.withdraw(amt);
    accountInfo.textContent = "".concat(account.getHolder(), " - ").concat(account.getBalance());
    console.log(res);
});
document.getElementById('balanceBtn').addEventListener('click', function () {
    var res = account.getBalance();
    accountInfo.textContent = "Current Balance: ".concat(res);
});
document.getElementById('closeBtn').addEventListener('click', function () {
    account = null;
    accountInfo.textContent = "Account Closed.";
});
