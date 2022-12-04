package lombokUse;

public class TestCustomer {

    public static void main(String[] args) {

        Customer c1 = new Customer("mohit", 20, "Ny", true, "20-01");
        System.out.println(c1.getName());
       // c1.setName("Mohit");

        c1.setActive(false);
    }
}
