public class Account {
    private static int accountCounter = 0;

    private int accountNo;
    private int amount;

    private String nationalId;

    public static int getAccountCounter() {
        return accountCounter;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public int getAmount() {
        return amount;
    }

    public String getNationalID() {
        return nationalID;
    }

    private String nationalID;

    public Account() {
        Account.accountCounter += 1;
        this.accountNo += Account.accountCounter;
        amount = 0;
        nationalID = "0000000000000";
    }


    public void deposit(int amount) {
        this.amount += amount;
    }

    /// retrag din amount-ul pe care il am, deci nu pot
    /// retrage mai multi bani decat am in cont
    public void withdraw(int amount) {
        try {
            if(amount > this.amount) {
                throw new NotEnoughMoneyException("Nu aveti suficienti bani");
            }
            this.amount -= amount;
        }
        catch (NotEnoughMoneyException e) {
            throw new RuntimeException(e);
        }
    }



    /// consider CNP-ul invalid daca nu are 13 cifre
    /// stiu ca sunt multe alte constrangeri pentru CNP dar nu stiu daca asta
    /// se vrea de la exercitiul acesta
    public void linkToNationalId(String nationalId) {
        try {
            if(nationalId.length() != 13) {
                throw new InvalidNationalIdException("CNP-ul nu are 13 cifre!");
            }

            this.nationalId = nationalId;
        } catch (InvalidNationalIdException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", amount=" + amount +
                ", nationalId='" + nationalId + '\'' +
                ", nationalID='" + nationalID + '\'' +
                '}';
    }
}
