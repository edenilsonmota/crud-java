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

    public boolean setPeople(String cpf, String name, String email) {
        people.setCpf(cpf);
        people.setName(name);
        people.setEmail(email);

        return peopleDAO.insert(people);
    }

    public List<People> getAll(){
        return peopleDAO.getAll();
    }
}
