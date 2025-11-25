let account: any=null;
 
const ops=document.getElementById('accountOperations') as HTMLElement;
const accountInfo=document.getElementById('accountInfo') as HTMLElement;
 
(document.getElementById('createBtn') as HTMLButtonElement).addEventListener('click',() => {
    const name =(document.getElementById('holderName') as HTMLInputElement).value.trim();
    const initialBal= parseFloat((document.getElementById('initialBalance')as HTMLInputElement).value) || 0;
   
    account=new (window as any).BankAccount(name,initialBal);
    accountInfo.textContent = `${account.getHolder()} - ${account.getBalance()}`;
    console.log('Account Object created: ',account)  
});
 
(document.getElementById('depositBtn') as HTMLButtonElement).addEventListener('click',() => {
    const amt=parseFloat((document.getElementById('depositAmount') as HTMLInputElement).value) ||0;
    const res =account.deposit(amt);
    accountInfo.textContent = `${account.getHolder()} - ${account.getBalance()}`;
    console.log(res);
});
 
(document.getElementById('withdrawBtn') as HTMLButtonElement).addEventListener('click',() => {
    const amt=parseFloat((document.getElementById('withdrawAmount') as HTMLInputElement).value) ||0;
    const res =account.withdraw(amt);
    accountInfo.textContent = `${account.getHolder()} - ${account.getBalance()}`;
    console.log(res);
});
 
(document.getElementById('balanceBtn') as HTMLButtonElement).addEventListener('click',() => {
    const res=account.getBalance();
    accountInfo.textContent=`Current Balance: ${res}`;
});
 
(document.getElementById('closeBtn') as HTMLButtonElement).addEventListener('click',() => {
    account=null;
    accountInfo.textContent=`Account Closed.`
});