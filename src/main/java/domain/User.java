package domain;

import org.joda.time.DateTime;

import java.time.LocalTime;

public class User {

    private String name;
    private String lastName;
    private String email;
    private String password;
    private DateTime birthdate;
    private int id;


    public User (String name,String lastName, String email, String password, DateTime birthdate){

        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(DateTime birthdate) {
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Auction createAuction(String title, String description, String address, double priceInit, DateTime dateInit,
                                 DateTime dateFinal, LocalTime hoursFinal, User owner) {

        return new Auction(title,description,address,priceInit,dateInit,dateFinal,hoursFinal,owner);
    }

    public void bidAtAuction(Auction auction, double autoBid) {
        auction.makeABid(this,autoBid);
    }
}