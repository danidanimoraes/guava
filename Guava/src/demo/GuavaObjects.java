package demo;


public class GuavaObjects {

    public static void main(String[] args) {

        DunningScenario oldCustomers = new DunningScenario("1", "Old Customers", "Individual", "send a letter");
        DunningScenario youngCustomers = new DunningScenario("2", "Young Customers", "Individual", "send a SMS");
        DunningScenario invalidDunningScenario = new DunningScenario("3", null, null, "do nothing");

        System.out.println(oldCustomers.equals(youngCustomers));
        System.out.println(oldCustomers.equals(invalidDunningScenario));
        System.out.println(youngCustomers.equals(invalidDunningScenario));
        System.out.println(oldCustomers.hashCode());
        System.out.println(youngCustomers.hashCode());
        System.out.println(invalidDunningScenario.hashCode());
    }
}
