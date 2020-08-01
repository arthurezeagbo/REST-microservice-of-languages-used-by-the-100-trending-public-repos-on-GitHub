package com.arthurezeagbo.repoinfoservice.models;

import java.util.ArrayList;
import java.util.List;

public class LanguageDetail {

    private String language;
    private int total_repo_count;
    private List<Item> repos = new ArrayList<Item>();

    public LanguageDetail(String language, int total_repo_count, List<Item> repos) {
        this.language = language;
        this.total_repo_count = total_repo_count;
        this.repos = repos;
    }

    public LanguageDetail(){}


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotal_repo_count() {
        return total_repo_count;
    }

    public void setTotal_repo_count(int total_repo_count) {
        this.total_repo_count = total_repo_count;
    }

    public List<Item> getRepos() {
        return repos;
    }

    public void setRepos(List<Item> repos) {
        this.repos = repos;
    }
}
