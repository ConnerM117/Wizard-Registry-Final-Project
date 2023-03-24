package com.connerm117.wizard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Column;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hats")
public class Hat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long hat_id;
  
  @Column(value = "hat_name")
  private String hat_name;
  
  @Column(value = "hat_description")
  private String hat_description;
  
  @Column(value = "is_sentient")
  private boolean is_sentient;
  
  @ManyToOne
  @JoinColumn(name = "wizard_id")
  @JsonIgnore
  private Wizard wizard;
  
}
