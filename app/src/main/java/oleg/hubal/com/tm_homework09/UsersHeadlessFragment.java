package oleg.hubal.com.tm_homework09;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 15.03.2016.
 */
public class UsersHeadlessFragment extends Fragment {

    private String greetings;
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);

        return null;
    }

    public ArrayList<User> getUserList() {
        return users;
    }

    public void addNewUser(String login, String password, String name, String surname, String sex) {
        User user = new User(login, password, name, surname, sex);
        users.add(user);
    }

    public String getGreetings() {
        return greetings;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }
}
