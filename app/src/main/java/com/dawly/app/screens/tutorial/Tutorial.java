package com.dawly.app.screens.tutorial;

import app.dawly.com.dawly.R;

import java.util.ArrayList;
import java.util.List;

public class Tutorial {
    private int number;
    private int image;
    private int header;
    private int body;

    public Tutorial() {
        number = 1;
        image = 1;
        number = 1;
        header = 1;
        body = 1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Tutorial(int number, int image, int header, int body) {
        this.number = number;
        this.image = image;
        this.header = header;
        this.body = body;
    }

    public Tutorial(int image, int header, int body) {
        this.image = image;
        this.header = header;
        this.body = body;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getHeader() {
        return header;
    }

    public void setHeader(int header) {
        this.header = header;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public static List<Tutorial> getDawlyTutorials() {
        List<Tutorial> dawlyTutorials = new ArrayList<>();
        dawlyTutorials.add(new Tutorial(1, R.drawable.ic_illustration2, R.string.tutorial_1_header, R.string.tutorial_1_body));
        dawlyTutorials.add(new Tutorial(2, R.mipmap.tutorial_2, R.string.tutorial_2_header, R.string.tutorial_2_body));
        dawlyTutorials.add(new Tutorial(3, R.mipmap.tutorial_3, R.string.tutorial_3_header, R.string.tutorial_3_body));

        return dawlyTutorials;
    }


}
