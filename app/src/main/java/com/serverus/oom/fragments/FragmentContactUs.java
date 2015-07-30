package com.serverus.oom.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.parse.ParseException;
import com.parse.SaveCallback;
import com.serverus.oom.parse.Enquiry;
import com.serverus.oom.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentContactUs extends Fragment implements View.OnClickListener,OnMapReadyCallback {
    private Spinner servicesSpinner;
    private Spinner howUFindUsSpinner;
    private Button  sendEnquiryButton;

    private static GoogleMap mMap;
    private FragmentTransaction fTransaction;
    private MapFragment mapFragment;

    private TextInputLayout _nameTextInput,
            _companyTextInput,
            _emailTextInput,
            _contactTextInput,
            _referralTextInput,
            _servicesTextInput;

    private EditText _nameText,
            _companyText,
            _emailText,
            _contactText,
            _messageText;

    private Spinner _servicesSpnr, _referralSpnr;

    public FragmentContactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // setTitle
        getActivity().setTitle("Countact Us");

        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        initViews(view);

        createMap();

        return view;
    }

    public void initViews(View view){

        sendEnquiryButton   = (Button) view.findViewById(R.id.send_enquiry_btn);

        _nameTextInput      = (TextInputLayout) view.findViewById(R.id.name_textInput);
        _companyTextInput   = (TextInputLayout) view.findViewById(R.id.company_textInput);
        _emailTextInput     = (TextInputLayout) view.findViewById(R.id.email_textInput);
        _contactTextInput   = (TextInputLayout) view.findViewById(R.id.contact_textInput);
        _referralTextInput  = (TextInputLayout) view.findViewById(R.id.referral_textInput);
        _servicesTextInput  = (TextInputLayout) view.findViewById(R.id.services_textInput);

        _nameText       = (EditText) view.findViewById(R.id.edit_text_name);
        _companyText    = (EditText) view.findViewById(R.id.edit_text_company);
        _emailText      = (EditText) view.findViewById(R.id.edit_text_email);
        _contactText    = (EditText) view.findViewById(R.id.edit_text_contact);
        _messageText    = (EditText) view.findViewById(R.id.edit_text_enquiry);

        _servicesSpnr = (Spinner) view.findViewById(R.id.services_spinner);
        _referralSpnr = (Spinner) view.findViewById(R.id.referral_spinner);

        ArrayAdapter<CharSequence> servicesAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.services_array, android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> findUsAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.findUs_array, android.R.layout.simple_spinner_dropdown_item);

        _servicesSpnr.setAdapter(servicesAdapter);
        _referralSpnr.setAdapter(findUsAdapter);


        sendEnquiryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_enquiry_btn:
                sendEnquiry();
                break;
        }
    }

    public void sendEnquiry(){
        String name     = _nameText.getText().toString();
        String company  = _companyText.getText().toString();
        String email    = _emailText.getText().toString();
        String contact  = _contactText.getText().toString();
        String services = _servicesSpnr.getSelectedItem().toString();
        String referral = _referralSpnr.getSelectedItem().toString();
        String message  = _messageText.getText().toString();
        if (!validate()) {
            //onLoginFailed();
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Sending Enquiry...");
        progressDialog.show();

        Enquiry enquiry = new Enquiry();
        enquiry.setName(name.toLowerCase());
        enquiry.setCompany(company.toLowerCase());
        enquiry.setEmail(email);
        enquiry.setContactNumber(contact);
        enquiry.setService(services.toLowerCase());
        enquiry.setReferral(referral.toLowerCase());
        enquiry.setMessage(message);

        enquiry.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    progressDialog.dismiss();
                    sendEnquiryButton.setEnabled(true);
                    Toast.makeText(getActivity(),
                            "Enquiry was Sent Successful ",
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(getActivity(),
                            e.getMessage(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                    sendEnquiryButton.setEnabled(true);
                }
            }
        });

    }

    public boolean validate(){
        boolean valid = true;

        String name     = _nameText.getText().toString();
        String company  = _companyText.getText().toString();
        String email    = _emailText.getText().toString();
        String contact  = _contactText.getText().toString();
        String services = _servicesSpnr.getSelectedItem().toString();
        String referral = _referralSpnr.getSelectedItem().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameTextInput.setErrorEnabled(true);
            _nameTextInput.setError("enter a valid Name");
            valid = false;
        } else {
            _nameTextInput.setError(null);
        }

        if (company.isEmpty() || company.length() < 3) {
            _companyTextInput.setErrorEnabled(true);
            _companyTextInput.setError("enter a valid Company name");
            valid = false;
        } else {
            _companyTextInput.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailTextInput.setErrorEnabled(true);
            _emailTextInput.setError("enter a valid Email");
            valid = false;
        } else {
            _emailTextInput.setError(null);
        }

        if (contact.isEmpty() || contact.length() < 3) {
            _contactTextInput.setErrorEnabled(true);
            _contactTextInput.setError("enter a valid Contact Number");
            valid = false;
        } else {
            _contactTextInput.setError(null);
        }

        if (services.equals("Service?")) {
            _servicesTextInput.setErrorEnabled(true);
            _servicesTextInput.setError("Choose a type of service");
            valid = false;
        } else {
            _contactTextInput.setError(null);
        }

        if(referral.equals("How did you find us?")){
            _referralTextInput.setErrorEnabled(true);
            _referralTextInput.setError("Choose a referral type");
            valid = false;
        }else{
            _referralTextInput.setError(null);
        }

        return valid;
    }


    public void createMap(){
        FragmentManager fm = getChildFragmentManager();
        SupportMapFragment supportMapFragment =  SupportMapFragment.newInstance();
        fm.beginTransaction().replace(R.id.map, supportMapFragment).commit();
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng oomOffice = new LatLng(1.358606,103.833566);
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);
        googleMap.addMarker(new MarkerOptions().position(oomOffice)
                .title("Optimal Online Marketing")).showInfoWindow();
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(oomOffice));
        googleMap.animateCamera(zoom);
    }

}
