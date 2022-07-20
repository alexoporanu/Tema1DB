public class Main {
    public static void main(String[] args) {
        Account a1 = new Account();
        a1.deposit(1500);
        System.out.println(a1.getAmount());

        a1.withdraw(1000);
        System.out.println(a1.getAmount());

        a1.linkToNationalId("1234123412345");

        System.out.println(a1);


        /*
        /// asta da eroarea cu NotEnoughMoney

        Account a2 = new Account();
        a2.deposit(500);
        System.out.println(a2.getAmount());

        a2.withdraw(1000);

         */

        /// aici e eroarea cu CNP - ul invalid
        Account a3 = new Account();
        a3.linkToNationalId("321312312312312312312312312312321312");
    }
}
