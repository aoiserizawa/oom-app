package com.serverus.oom.fragments;


import android.app.ProgressDialog;
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

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.serverus.oom.MainActivity;
import com.serverus.oom.R;
import com.serverus.oom.SignupActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLogin extends Fragment {
    private TextInputLayout _userNameLayout;
    private TextInputLayout _passwordLayout;
    private EditText _userNameText;
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
        _userNameText = (EditText) view.findViewById(R.id.edit_text_username);
        _passwordText = (EditText) view.findViewById(R.id.edit_text_password);
        _userNameLayout = (TextInputLayout) view.findViewById(R.id.username_layout);
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

        _loginBtn.setEnabled(false);

        String username = _userNameText.getText().toString();
        String password = _passwordText.getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loging in...");
        progressDialog.show();

        ParseUser.logInInBackground(username, password,
                new LogInCallback() {

                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            // If user exist and authenticated, send user to Welcome.class
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(),
                                    "Successfully Logged in",
                                    Toast.LENGTH_LONG).show();

                            Intent refresh = new Intent(getActivity(), MainActivity.class);
                            startActivity(refresh);
                            getActivity().finish();

                        } else {
                            Toast.makeText(
                                    getActivity(),
                                    e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void onLoginFailed() {
        Toast.makeText(getActivity(), "Login failed", Toast.LENGTH_LONG).show();
        _loginBtn.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String username = _userNameText.getText().toString();
        String password = _passwordText.getText().toString();


        if (username.isEmpty() || username.length() < 3) {
            _userNameLayout.setErrorEnabled(true);
            _userNameLayout.setError("enter a valid Username");
            valid = false;
        } else {
            _userNameLayout.setError(null);
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
