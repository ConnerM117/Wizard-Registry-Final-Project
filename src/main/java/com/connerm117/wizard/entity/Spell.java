package com.connerm117.wizard.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "spells")
public class Spell {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer spell_id;
  
  @Column(value = "spell_name")
  private String spell_name;
  
  @Column(value = "spell_description")
  private String spell_description;
  
  @ManyToMany(mappedBy = "spells")
  @JsonIgnore
  private Set<Wizard> wizards;

}
