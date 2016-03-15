package oleg.hubal.com.tm_homework09;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by User on 13.03.2016.
 */
public class RegFragment extends Fragment implements View.OnClickListener {


    private UsersHeadlessFragment usersFragment;
    private View view;
    private EditText etLogin, etPassword, etName, etSurname;
    private RadioGroup radioGroup;
    private Button btnCreate;
    private String login, password, name, surname, sex;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sabedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reg, container, false);

        usersFragment = (UsersHeadlessFragment) getFragmentManager().findFragmentByTag("users");
        initViews();

        return view;
    }

    private void initViews() {
        etLogin = (EditText) view.findViewById(R.id.et_reg_login);
        etPassword = (EditText) view.findViewById(R.id.et_reg_pass);
        etName = (EditText) view.findViewById(R.id.et_reg_name);
        etSurname = (EditText) view.findViewById(R.id.et_reg_surname);
        radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
        btnCreate = (Button) view.findViewById(R.id.btn_reg_reg);

        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getFieldValues();

        if(isEmptyFields())
            Toast.makeText(getActivity(), R.string.empty_field_toast, Toast.LENGTH_LONG).show();
        else {
            usersFragment.getUserList()
                    .add(new User(login, password, name, surname, sex));
            showDialogFragment();
        }
    }

    private void showDialogFragment() {
        GreetingDialogFragment dialogFragment = new GreetingDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putString("user", name + " " + surname);
        dialogFragment.setArguments(bundle);

        dialogFragment.show(getActivity().getFragmentManager(), "dialog");
    }

    private boolean isEmptyFields() {
        if(login.isEmpty() || password.isEmpty() || name.isEmpty()
                || surname.isEmpty() || sex.isEmpty())
            return true;
        else return false;
    }

    private void getFieldValues() {
        login = etLogin.getText().toString();
        password = etPassword.getText().toString();
        name = etName.getText().toString();
        surname = etSurname.getText().toString();

        if(radioGroup.getCheckedRadioButtonId() == R.id.rb_male)
            sex = Constants.cMALE;
        else if(radioGroup.getCheckedRadioButtonId() == R.id.rb_female)
            sex = Constants.cFEMALE;
    }
}