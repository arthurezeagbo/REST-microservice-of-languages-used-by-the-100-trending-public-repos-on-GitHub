package com.arthurezeagbo.repoinfoservice.models;

import java.util.ArrayList;
import java.util.List;

public class LanguageDetail {

    private String language;
    private int count;
    private List<Item> repos = new ArrayList<Item>();

    public LanguageDetail(String language, int count, List<Item> repos) {
        this.language = language;
        this.count = count;
        this.repos = repos;
    }

    public LanguageDetail(){}


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Item> getRepos() {
        return repos;
    }

    public void setRepos(List<Item> repos) {
        this.repos = repos;
    }
}
