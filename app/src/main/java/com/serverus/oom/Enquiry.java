package com.serverus.oom;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by alvinvaldez on 7/20/15.
 */

@ParseClassName("Enquiries")
public class Enquiry extends ParseObject {

    public Enquiry() {
        super();
    }

    public void setName(String name) {
        put("name", name);
    }

    public void setCompany(String company) {
        put("company", company);
    }

    public void setContactNumber(String contactNumber) {
        put("contact_no", contactNumber);
    }

    public void setEmail(String email) {
        put("email", email);
    }

    public void setReferral(String referral) {
        put("referral", referral);
    }

    public void setService(String service) {
        put("service", service);
    }

    public void setMessage(String message) {
        put("message", message);
    }
}
