package com.connerm117.wizard.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "familiars")
public class Familiar {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long familiar_id;
  
  @Column(value = "familiar_name")
  private String familiar_name;
  
  @Column(value = "familiar_type")
  private FamiliarType familiar_type;
  
  @Column(value = "danger_rating")
  private Integer danger_rating;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "wizard_id")
  @JsonIgnore
  private Wizard wizard;
  
}
