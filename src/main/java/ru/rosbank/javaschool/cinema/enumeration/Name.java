package ru.rosbank.javaschool.cinema.enumeration;

public enum Name {

    UPLOAD_PATH("/app/upload"),
    GARFIELD_IMAGE("Garfield.jpg"),
    GARFIELD_VIDEO("Garfield.mp4"),
    INCEPTION_IMAGE("Inception.jpg");

    private String value;

    Name(String value){
        this.value = value;
    }
}
