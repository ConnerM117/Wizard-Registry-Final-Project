package com.connerm117.wizard.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "wizards")
public class Wizard {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer wizard_id;
  
  @Column(value = "age")
  private Integer age;
  
  @Column(value = "is_menace_to_society")
  private boolean is_menace_to_society;
  
  @Column(value = "wizard_name")
  private String wizard_name;
  
  @ManyToMany(cascade = { CascadeType.ALL } )
  @JoinTable(
      name = "wizard_spells",
      joinColumns = { @JoinColumn(name = "wizard_id") },
      inverseJoinColumns = { @JoinColumn(name = "spell_id") })
  private List<Spell> spells;
  
  @OneToMany(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Hat> hats;
  
  @OneToOne(mappedBy = "wizard", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Familiar familiar;

  @JsonIgnore
  public Integer getWizard_id() {
    return wizard_id;
  }
  
}
