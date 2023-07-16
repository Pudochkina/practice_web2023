package ru.Pudochkina.model;

import java.util.Date;

public class ApplicationForm {

    private Long id;

    private String dateOfPost;

    private String sortOfWork;

    private int houseNumber;

    private String message;

    private String status = "";

    public ApplicationForm(Long id, String dateOfPost, String sortOfWork, int houseNumber, String message, String status) {
        this.id = id;
        this.dateOfPost = dateOfPost;
        this.sortOfWork = sortOfWork;
        this.houseNumber = houseNumber;
        this.message = message;
        this.status = status;
    }

    public ApplicationForm() {

    }

    public Long getId() {
        return id;
    }

    public String getDateOfPost() {
        return dateOfPost;
    }

    public String getSortOfWork() {
        return sortOfWork;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateOfPost(String dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public void setSortOfWork(String sortOfWork) {
        this.sortOfWork = sortOfWork;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
