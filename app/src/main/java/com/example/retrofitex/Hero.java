package com.example.retrofitex;

public class Hero {

    private String bio;
    private String createdby;
    private String firstappearance;
    private String imageurl;
    private String name;
    private String publisher;
    private String realname;
    private String team;

    public Hero(String bio, String createdby, String firstappearance, String imageurl, String name, String publisher, String realname, String team) {
        this.bio = bio;
        this.createdby = createdby;
        this.firstappearance = firstappearance;
        this.imageurl = imageurl;
        this.name = name;
        this.publisher = publisher;
        this.realname = realname;
        this.team = team;
    }

    public String getBio() {
        return bio;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }
}
