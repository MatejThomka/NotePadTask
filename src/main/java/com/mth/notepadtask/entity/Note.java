package com.mth.notepadtask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Note {
  @Id
  private Long id;
  private String noteText;



  public Note() {
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getNoteText() {
    return noteText;
  }

  public void setNoteText(String noteText) {
    this.noteText = noteText;
  }
}
