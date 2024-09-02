import controller.PeopleController;
import java.util.List;
import model.People;

public class Main {
    public static void main(String[] args) {
        PeopleController people = new PeopleController();

        List<People> allPeople = people.getAll();

        for(People person: allPeople){
            System.out.println("ID: " + person.getId());
            System.out.println("CPF: " + person.getCpf());
            System.out.println("Name: " + person.getName());
            System.out.println("Email: " + person.getEmail());
            System.out.println("------");
        }

       // System.out.println(people.setPeople("22117357890", "Alice Giovana Catarina Brito", "alice_giovana_brito@crsilvadesign.com"));
    }
}
