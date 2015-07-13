package com.serverus.oom;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment {
    private TextInputLayout _emailLayout;
    private TextInputLayout _passwordLayout;
    private EditText _emailText;
    private EditText _passwordText;
    private Button _loginBtn;
    private Button _registerBtn;

    public FragmentLogin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_login, container, false);
        initViews(view);


        // Inflate the layout for this fragment
        return view;
    }

    public void initViews(View view){
        _emailText = (EditText) view.findViewById(R.id.edit_text_email);
        _passwordText = (EditText) view.findViewById(R.id.edit_text_password);
        _emailLayout = (TextInputLayout) view.findViewById(R.id.email_layout);
        _passwordLayout = (TextInputLayout) view.findViewById(R.id.password_layout);
        _loginBtn = (Button) view.findViewById(R.id.login_btn);
        _registerBtn = (Button) view.findViewById(R.id.register_btn);

        _loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        _registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignupActivity.class);
                startActivity(intent);
            }
        });

    }

    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

    }

    public void onLoginFailed() {
        Toast.makeText(getActivity(), "Login failed", Toast.LENGTH_LONG).show();
        //_loginButton.setEnabled(true);
    }



    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailLayout.setErrorEnabled(true);
            _emailLayout.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordLayout.setErrorEnabled(true);
            _passwordLayout.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }


}
