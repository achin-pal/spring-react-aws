package com.demo.basicApp;

public class Challanges {
    private Long id;
    private String month;
    private String description;

    public Challanges(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}