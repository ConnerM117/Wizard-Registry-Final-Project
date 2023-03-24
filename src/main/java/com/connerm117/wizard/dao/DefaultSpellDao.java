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
import com.connerm117.wizard.entity.Spell;
import com.connerm117.wizard.errorhandling.ResourceNotFoundException;
import com.connerm117.wizard.repository.SpellRepository;

@Service
public class DefaultSpellDao implements SpellDao {

  @Autowired
  SpellRepository spellRepo;
  
  @Autowired
  NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Spell> getAllSpells() {
    String sql = ""
        + "SELECT * "
        + "FROM spells";
    
    return jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Spell mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Spell.builder()
            .spell_id(rs.getInt("spell_id"))
            .spell_name(rs.getString("spell_name"))
            .spell_description(rs.getString("spell_description"))
            .build();
      }
      
    });
  }

  @Override
  public Spell getSpellById(int spellId) {
    String sql = ""
        + "SELECT * "
        + "FROM spells "
        + "WHERE spell_id = :spell_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("spell_id", spellId);
    
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
    
    if (spells.isEmpty())
      throw new ResourceNotFoundException("Spell", "ID", spellId);
    
    return spells.get(0);
  }

  @Override
  public Spell createSpell(String spellName, String spellDescription) {
    String sql = ""
        + "INSERT INTO spells "
        + "(spell_name, spell_description) "
        + "VALUES "
        + "(:spell_name, :spell_description)";
    
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("spell_name", spellName);
    params.addValue("spell_description", spellDescription);
    
    KeyHolder key = new GeneratedKeyHolder();
    jdbcTemplate.update(sql, params, key);
    
    int spellPK = key.getKey().intValue();
    
    return getSpellById(spellPK);
  }

  @Override
  public Spell updateSpell(int spellId, String newSpellDescription) {
    String sql = ""
        + "UPDATE spells SET "
        + "spell_description = :spell_description "
        + "WHERE spell_id = :spell_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("spell_description", newSpellDescription);
    params.put("spell_id", spellId);
    
    jdbcTemplate.update(sql, params);
    
    return getSpellById(spellId);
  }

  @Override
  public String deleteSpell(int spellId) {
    String sql = ""
        + "DELETE FROM spells "
        + "WHERE spell_id = :spell_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("spell_id", spellId);
    
    jdbcTemplate.update(sql, params);
    
    return "Spell with ID=" + spellId + " was successfully deleted.";
  }

}
