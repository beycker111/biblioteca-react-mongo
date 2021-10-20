package com.biblotecareact.biblotecareactmongo.dtos;

import java.util.Objects;

public class ResourceAnswerDTO {

    private String answer;
    private boolean status;
    private String date;

    public ResourceAnswerDTO(){
    }

    public ResourceAnswerDTO(String answer, boolean status, String date){
        this.answer = answer;
        this.status = status;
        this.date = date;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceAnswerDTO that = (ResourceAnswerDTO) o;
        return status == that.status && Objects.equals(answer, that.answer) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, status, date);
    }
}
