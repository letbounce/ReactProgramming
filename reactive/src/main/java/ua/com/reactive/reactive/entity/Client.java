package ua.com.reactive.reactive.entity;

public class Client {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final int age;

    public Client(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
