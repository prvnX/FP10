object account{
    class Account(val accno: Int,var balance: Double){
        def deposit(amount: Double): Unit = {
            if(amount>0){
                balance += amount
                println(s"Deposited $amount to account $accno, new balance: $balance")
            }
            else{
                throw new Error("Amount must be greater than zero")
            }
        }

        def transfer(amount: Int, that: Account): Unit = {
            require(amount > 0, "Amount must be greater than zero")
            this.balance -= amount
            that.balance += amount
        }

        def withdraw(amount: Double): Unit = {
            if (amount > 0 && amount <= balance) {
                balance -= amount
                println(s"Withdrew $$amount from account $accno, new balance: $$balance")
            } else if (amount > balance) {
                println("Insufficient balance.")
            } else {
                println("Withdraw amount must be positive.")
            }
        }
        def getBalance: Double = balance;
    }
    def main(args: Array[String]): Unit = {
        val a1 = new Account(10574242, 10000.00)
        val a2 = new Account(50056421, 25000.00)
        a1.deposit(1000.00)
        println(s"Account 1  balance(after deposit): ${a1.getBalance}")
        a1.withdraw(2000.00)
        println(s"Account 1 balance(after withdrawal): ${a1.getBalance}")
        a1.transfer(10050, a2)
        println(s"Account 1 balance(after transfer to account 2): ${a1.getBalance}")
        println(s"Account 2 balance(after transfer ): ${a2.getBalance}")  
    }
}