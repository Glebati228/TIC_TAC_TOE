package com.example.exampler.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;
    private String tag;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    private String filename;
    private String datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Message()
    {

    }

    public Message(String text, String tag, User author, String datetime)
    {
        this.text = text;
        this.tag = tag;
        this.author = author;
        this.datetime = datetime;
        username = author.getUsername();
    }

    public String getAuthorName()
    {
        return author != null ? author.getUsername() : "none";
    }

    public User getUser() {
        return author;
    }

    public void setUser(User user) {
        this.author = user;
    }

    public void SetText(String text)
    {
        this.text = text;
    }
    public String GetText()
    {
        return text;
    }

    public void SetTag(String tag)
    {
        this.tag = tag;
    }
    public String GetTag()
    {
        return tag;
    }
}
