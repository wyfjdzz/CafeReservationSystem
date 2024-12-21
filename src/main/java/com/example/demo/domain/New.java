package com.example.demo.domain;

import jakarta.persistence.*;

@Table(name = "news")
@Entity
public class New {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int newId;
  private String dataTime;
  private String title;
  private String content;
  private String author;
  private String newDescription;
  private String newDetail;

  public int getNewId() { return this.newId; }
  public void setNewId(int newId) { this.newId = newId; }

  public String getDataTime() { return this.dataTime; }
  public void setDataTime(String dataTime) { this.dataTime = dataTime; }

  public String getTitle() { return this.title; }
  public void setTitle(String title) { this.title = title; }

  public String getContent() { return this.content; }
  public void setContent(String content) { this.content = content; }

  public String getAuthor() { return this.author; }
  public void setAuthor(String author) { this.author = author; }

  public String getNewDescription() { return this.newDescription; }
  public void setNewDescription(String newDescription) { this.newDescription = newDescription; }

  public String getNewDetail() { return this.newDetail; }
  public void setNewDetail(String newDetail) { this.newDetail = newDetail; }
}
