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
import com.connerm117.wizard.entity.Wizard;
import com.connerm117.wizard.errorhandling.ResourceNotFoundException;
import com.connerm117.wizard.errorhandling.WizardAlreadyHasFamiliarException;

@Service
public class DefaultFamiliarDao implements FamiliarDao {

  @Autowired
  NamedParameterJdbcTemplate jdbcTemplate;
  
  @Autowired
  DefaultWizardDao wizardDao;
  
  @Override
  public Familiar createFamiliar(int wizardId, String familiarName, FamiliarType familiarType,
      Integer dangerRating) {
    Wizard wizard = wizardDao.getWizardById(wizardId);
    
    if (wizard.getFamiliar() != null)
      throw new WizardAlreadyHasFamiliarException(wizardId);
    
    String sql = ""
        + "INSERT INTO familiars "
        + "(wizard_id, familiar_name, familiar_type, danger_rating) "
        + "VALUES "
        + "(:wizard_id, :familiar_name, :familiar_type, :danger_rating)";
    
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("wizard_id", wizardId);
    params.addValue("familiar_name", familiarName);
    params.addValue("familiar_type", familiarType.toString());
    params.addValue("danger_rating", dangerRating);
    
    KeyHolder keys = new GeneratedKeyHolder();
    
    jdbcTemplate.update(sql, params, keys);
    
    int familiarPK = keys.getKey().intValue();    
    return getFamiliarById(familiarPK);
  }

  @Override
  public String deleteFamiliar(int wizardId) {
    String sql = ""
        + "DELETE FROM familiars "
        + "WHERE wizard_id = :wizard_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("wizard_id", wizardId);
    
    jdbcTemplate.update(sql, params);
    
    return "Familiar belonging to Wizard with ID=" + wizardId + " was successfully deleted.";
  }

  private Familiar getFamiliarById(int familiarId) {
    String sql = ""
        + "SELECT * "
        + "FROM familiars "
        + "WHERE familiar_id = :familiar_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("familiar_id", familiarId);
    
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
      throw new ResourceNotFoundException("Familiar", "ID", familiarId);
    
    return familiars.get(0);
  }
}
