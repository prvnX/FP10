object bank {

  case class Account(accountNumber: String, balance: Double)

  class Bank(accounts: List[Account]) {

    // Accounts with negative balances
    def negativeBalanceAccounts(): List[Account] = {
      accounts.filter(_.balance < 0)
    }

    // Sum of all account balances
    def totalBalance(): Double = {
      accounts.map(_.balance).sum
    }
    // Final balances of all accounts after applying interest
    def applyInterest(): List[Account] = {
      accounts.map { account =>
        val interestRate = if (account.balance >= 0) 0.05 else 0.1
        val newBalance = account.balance + (account.balance * interestRate)
        account.copy(balance = newBalance)
      }
    }
  }

    def main(args: Array[String]): Unit = {
    // list of accounts
    val accounts = List(
      Account("A001", 500.0),
      Account("A002", -200.0),
      Account("A003", 1000.0),
      Account("A004", -50.0)
    )

    // Create a Bank object
    val bank = new Bank(accounts)

    // List of Accounts with negative balances
    val negativeAccounts = bank.negativeBalanceAccounts()
    println(s"Accounts with negative balances: $negativeAccounts")

    // Calculate the sum of all account balances
    val totalBalance = bank.totalBalance()
    println(s"Total balance of all accounts: $totalBalance")

    // Calculate the final balances of all accounts after applying interest
    val accountsWithInterest = bank.applyInterest()
    println(s"Accounts after applying interest: $accountsWithInterest")
  }
}

