package model;

public class People {
    private int id;
    private String cpf;
    private String name;
    private String email;

    public People(int id, String cpf, String name, String email){
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public People(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
