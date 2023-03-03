https://user-images.githubusercontent.com/75710628/222833901-258553cc-395c-4fad-b684-b47e8061c59b.mov

# Banking App
This is a Java application that simulates the use of a bank machine with the extra included functionality of being able to create and delete accounts. Users can set up as many accounts as they desire and each account has a balance, a description, and a series of transactions that have occurred (withdraw / deposit).

## Functionality
The banking app provides the following functionality:

- Main menu: to select an appropriate task
- Select Account: to select an account to carry out transactions
- Deposit sum to account: to deposit into the currently selected account
- Withdraw sum from account: withdraw from the currently selected account if the balance is large enough
- Create account: create a new Savings account or Airmiles Savings Account. When an account is created it is automatically set to be the selected account.
Delete account: delete either a Savings account or Airmiles Savings Account
- View account transactions: view account information and transactions of the currently selected account
- Load / Save: all account information (including transactions) must be saved in an external binary file. If the binary file exists when the application loads, all accounts must be restored in the application. Both loading and saving should happen automatically.
Accounts can be of two different types:

    - Savings Account: has a fee of $0.50 for every withdraw
    - Airmiles Savings Account: has a fee of $0.75 for every withdraw but as well adds 1 Airmile for every $30 deposited into the account in one transaction. When you open an account of this type you automatically receive 10 additional bonus Airmiles on top of any Airmiles earned with the initial deposit.

- Each transaction must have a description (payday / movies / groceries / etc.), date and time, and the amount (positive for deposit, negative for withdraw).

## Design Pattern
The banking app uses the Model View Controller (MVC) design pattern to separate the application into three interconnected components: Model, View, and Controller. The Model represents the data and business logic of the application, the View displays the data to the user, and the Controller handles the user input and updates the Model.

## Usage
To use the banking app, download or clone the repository and run the Main.java file. The app will open a command line interface that allows users to interact with the application.

## Error Handling
All input must be error checked for incorrect input with user-friendly feedback. There should be no way to crash the application.

## Dependencies
The banking app requires Java 8 or higher to run.

## Version Control
We have implemented GIT for version control with adequate commits and branching.

## Authors
This application was developed by Jenny Ngi.
