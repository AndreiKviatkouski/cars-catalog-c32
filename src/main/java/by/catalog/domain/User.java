package by.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private  String name;
    private  String lastName;
    private  String login;
    private  String password;
    private  String phone;
    private  String role;

        public User(String name, String lastName, String login, String password, String phone, String role) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public User(long id, String name, String lastName, String login, String password, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.phone = phone;
    }
}