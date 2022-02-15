package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{
//... imports class definition...
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
    	this.id = id;
    	this.role = role;
    }
    
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	

    // TO DO: Implement HIPAACompliantAdmin!
    //Returns a list of strings (incidents reported)
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
	}
	
	// TO DO: Implement HIPAACompliantUser!
	
	//Pin must be 6 digits or more; returns false if not
	//Expected to assign the pin to the user (as a member variable)
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if ( pin >= 100000 ) {
			this.pin = pin;
			return true;
		} else return false;
	}
	
	//Compares the ids, and if they are not a match,
	//creates an incident report using the  authIncident method,
	//Returns true if ids match, false if not.
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if ( this.id == confirmedAuthID ) {
			return true;
		} else {
			this.authIncident();
			return false;
		}
	}
	
    
    // TO DO: Setters & Getters
	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}



	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}


}
