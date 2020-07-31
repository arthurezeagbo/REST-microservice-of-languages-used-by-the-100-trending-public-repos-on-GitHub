package com.arthurezeagbo.repodataservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Base {

    private Integer totalCount;
    private Boolean incompleteResult;
    private Item[] items;

    public Base(){}

    public Integer getTotal() {
        return totalCount;
    }

    @JsonProperty("total_count")
    public void setTotal(Integer total) {
        this.totalCount = total;
    }

    public Boolean getIncompleteResult() {
        return incompleteResult;
    }

    @JsonProperty("incomplete_results")
    public void setIncompleteResult(Boolean incompleteResult) {
        this.incompleteResult = incompleteResult;
    }

    public Item[] getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Item[] items) {
        this.items = items;
    }
}
