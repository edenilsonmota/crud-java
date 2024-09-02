package controller;

import dao.PeopleDAO;
import model.People;

import java.util.List;

public class PeopleController {
    private PeopleDAO peopleDAO;
    private People people;

    public PeopleController(){
        this.peopleDAO = new PeopleDAO();
        this.people = new People();
    }

    public boolean createPeople(String cpf, String name, String email) {
        people.setCpf(cpf);
        people.setName(name);
        people.setEmail(email);

        return peopleDAO.insert(people);
    }

    public boolean updatePeople(String cpf, String name, String email, int id) {
        people.setCpf(cpf);
        people.setName(name);
        people.setEmail(email);

        return peopleDAO.update(people, id);
    }

    public boolean deletePeople(int id) {
        return peopleDAO.delete(id);
    }

    public List<People> getAll(){
        return peopleDAO.getAll();
    }
}
