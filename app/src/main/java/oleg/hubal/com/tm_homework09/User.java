package oleg.hubal.com.tm_homework09;

/**
 * Created by User on 15.03.2016.
 */
public class User {
    private String password, login, name, surname, sex;

    public User(String login, String password,String name,String surname, String sex) {
        this.password = password;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
