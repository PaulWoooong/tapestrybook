package de.t5book.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vote {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @Basic
   private String question;
   @OneToMany(cascade = CascadeType.ALL)
   private List<Option> options = new ArrayList<Option>();

   public String getQuestion() {
     return this.question;
   }

   public void setQuestion(final String question) {
     this.question = question;
   }

   public List<Option> getOptions() {
     return this.options;
   }

   public void setOptions(final List<Option> options) {
     this.options = options;
   }

   public Long getId() {
     return this.id;
   }

   public void setId(final Long id) {
     this.id = id;
   }
}