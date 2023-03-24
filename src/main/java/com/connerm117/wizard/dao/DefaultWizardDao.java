package com.connerm117.wizard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import com.connerm117.wizard.entity.Familiar;
import com.connerm117.wizard.entity.FamiliarType;
import com.connerm117.wizard.entity.Hat;
import com.connerm117.wizard.entity.Spell;
import com.connerm117.wizard.entity.Wizard;
import com.connerm117.wizard.errorhandling.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultWizardDao implements WizardDao {
  
  @Autowired
  NamedParameterJdbcTemplate jdbcTemplate;
  
  @Autowired
  DefaultSpellDao spellDao;
  
  @Override
  public List<Wizard> getAllWizards() {
    String sql = ""
        + "SELECT * "
        + "FROM wizards "
        + "ORDER BY wizard_id";
    
    List<Wizard> wizards = jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Wizard mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Wizard.builder()
            .wizard_id(rs.getInt("wizard_id"))
            .wizard_name(rs.getString("wizard_name"))
            .age(rs.getInt("age"))
            .is_menace_to_society(rs.getBoolean("is_menace_to_society"))
            .build();
      }
      
    });
    
    for (Wizard wizard : wizards) {
      getWizardsFamiliar(wizard);
      getWizardsSpells(wizard);
      getWizardsHats(wizard);
    }
    
    return wizards;
  }

  private void getWizardsHats(Wizard wizard) {
    String sql = ""
        + "SELECT * "
        + "FROM hats "
        + "WHERE wizard_id = :wizard_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizard.getWizard_id());
    
    List<Hat> hats = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Hat mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Hat.builder()
            .hat_id(rs.getLong("hat_id"))
            .hat_name(rs.getString("hat_name"))
            .hat_description(rs.getString("hat_description"))
            .is_sentient(rs.getBoolean("is_sentient"))
            .build();
      }
      
    });
    
    wizard.setHats(hats);
  }

  private void getWizardsSpells(Wizard wizard) {
    String sql = ""
        + "SELECT s.* "
        + "FROM spells s "
        + "JOIN wizard_spells ws USING (spell_id) "
        + "WHERE wizard_id = :wizard_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizard.getWizard_id());
    
    List<Spell> spells = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Spell mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Spell.builder()
            .spell_id(rs.getInt("spell_id"))
            .spell_name(rs.getString("spell_name"))
            .spell_description(rs.getString("spell_description"))
            .build();
      }
      
    });
    
    wizard.setSpells(spells);
  }

  private void getWizardsFamiliar(Wizard wizard) {
    String sql = ""
        + "SELECT * "
        + "FROM familiars "
        + "WHERE wizard_id = :wizard_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizard.getWizard_id());
    
    List<Familiar> familiars = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Familiar mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Familiar.builder()
            .familiar_id(rs.getLong("familiar_id"))
            .familiar_name(rs.getString("familiar_name"))
            .familiar_type(FamiliarType.valueOf(rs.getString("familiar_type")))
            .danger_rating(rs.getInt("danger_rating"))
            .build();
      }
      
    });
    
    if (familiars.isEmpty())
      return;
    
    wizard.setFamiliar(familiars.get(0));
  }

  @Override
  public Wizard getWizardById(int wizardId) {
    String sql = ""
        + "SELECT * "
        + "FROM wizards "
        + "WHERE wizard_id = :wizard_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizardId);
    
    List<Wizard> wizards = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Wizard mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Wizard.builder()
            .wizard_id(rs.getInt("wizard_id"))
            .wizard_name(rs.getString("wizard_name"))
            .age(rs.getInt("age"))
            .is_menace_to_society(rs.getBoolean("is_menace_to_society"))
            .build();
      }
      
    });
    
    if (wizards.isEmpty()) {
      throw new ResourceNotFoundException("Wizard", "Id", wizardId);
    }
    
    Wizard wizard = wizards.get(0);
    
    getWizardsFamiliar(wizard);
    getWizardsSpells(wizard);
    getWizardsHats(wizard);
    
    return wizard;
  }

  @Override
  public Wizard createWizard(String name, int age, boolean isMenaceToSociety) {
    String sql = ""
        + "INSERT INTO wizards "
        + "(wizard_name, age, is_menace_to_society) "
        + "VALUES "
        + "(:wizard_name, :age, :is_menace_to_society)";
    
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("wizard_name", name);
    params.addValue("age", age);
    params.addValue("is_menace_to_society", isMenaceToSociety);
    
    KeyHolder key = new GeneratedKeyHolder();
    jdbcTemplate.update(sql, params, key);
    
    int wizardPK = key.getKey().intValue();
    
    return getWizardById(wizardPK);
  }

  @Override
  public Wizard updateWizard(int wizardId, String name, int age, boolean isMenaceToSociety) {
    String sql = ""
        + "UPDATE wizards SET "
        + "wizard_name = :wizard_name, "
        + "age = :age, "
        + "is_menace_to_society = :is_menace_to_society "
        + "WHERE wizard_id = :wizard_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_name", name);
    params.put("age", age);
    params.put("is_menace_to_society", isMenaceToSociety);
    params.put("wizard_id", wizardId);
    
    log.debug("Name = " + name + ", Age = " + age);
    
    jdbcTemplate.update(sql, params);
    
    return getWizardById(wizardId);
  }

  @Override
  public String deleteWizard(int wizardId) {
    String sql = ""
        + "DELETE FROM wizards "
        + "WHERE wizard_id = :wizard_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizardId);
    
    jdbcTemplate.update(sql, params);
    
    return "Wizard with ID=" + wizardId + " was successfully deleted.";
  }

  @Override
  public String removeSpellFromWizard(int wizardId, int spellId) {
    spellDao.getSpellById(spellId); //if the spellId is invalid, this will throw a ResourceNotFoundException
    getWizardById(wizardId); //if the wizardId is invalid, this will throw a ResourceNotFoundException
    wizardHasSpell(wizardId, spellId);
    if (!wizardHasSpell(wizardId, spellId)) {
      return "Wizard with ID=" + wizardId + " does not have spell with ID=" + spellId;
    }
    
    String sql = ""
        + "DELETE FROM wizard_spells "
        + "WHERE wizard_id = :wizard_id AND spell_id = :spell_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizardId);
    params.put("spell_id", spellId);
    
    jdbcTemplate.update(sql, params);
    
    return "Spell with ID=" + spellId + " was removed from Wizard with ID=" + wizardId;
  }

  @Override
  public String addSpellToWizard(int wizardId, int spellId) {
    spellDao.getSpellById(spellId); //if the spellId is invalid, this will throw a ResourceNotFoundException
    getWizardById(wizardId); //if the wizardId is invalid, this will throw a ResourceNotFoundException
    if (wizardHasSpell(wizardId, spellId)) {
      return "Wizard with ID=" + wizardId + " already has spell with ID=" + spellId;
    }
    
    String sql = ""
        + "INSERT INTO wizard_spells "
        + "(wizard_id, spell_id) "
        + "VALUES "
        + "(:wizard_id, :spell_id)";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizardId);
    params.put("spell_id", spellId);
    
    jdbcTemplate.update(sql, params);
    
    return "Spell with ID=" + spellId + " was added to Wizard with ID=" + wizardId;
  }
  
  /**
   * returns a boolean representing whether the wizard has the spell
   * @param wizardId references the wizard in question
   * @param spellId references the spell in question
   */
  private boolean wizardHasSpell(int wizardId, int spellId) {
    String sql = ""
        + "SELECT * "
        + "FROM wizard_spells "
        + "WHERE wizard_id = :wizard_id AND spell_id = :spell_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizardId);
    params.put("spell_id", spellId);
    
    List<WizardSpellConnection> results = jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public WizardSpellConnection mapRow(ResultSet rs, int rowNum) throws SQLException {
        return WizardSpellConnection.builder()
            .wizardID(rs.getInt("wizard_id"))
            .spellID(rs.getInt("spell_id"))
            .build();
      }
      
    });
    
    if (results.isEmpty())
      return false;
    
    return true;
  }
  
  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  private static class WizardSpellConnection {
    private int wizardID;
    private int spellID;
  }

}
