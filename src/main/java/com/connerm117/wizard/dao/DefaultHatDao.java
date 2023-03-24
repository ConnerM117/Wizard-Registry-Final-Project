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
import com.connerm117.wizard.entity.Hat;
import com.connerm117.wizard.errorhandling.ResourceNotFoundException;

@Service
public class DefaultHatDao implements HatDao {

  @Autowired
  NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Hat createHat(int wizardId, String hatName, String hatDescription, boolean isSentient) {
    String sql = ""
        + "INSERT INTO hats "
        + "(wizard_id, hat_name, hat_description, is_sentient) "
        + "VALUES "
        + "(:wizard_id, :hat_name, :hat_description, :is_sentient)";
    
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("wizard_id", wizardId);
    params.addValue("hat_name", hatName);
    params.addValue("hat_description", hatDescription);
    params.addValue("is_sentient", isSentient);
    
    KeyHolder key = new GeneratedKeyHolder();
    jdbcTemplate.update(sql, params, key);
    
    int hatPK = key.getKey().intValue();
    return getHat(hatPK);
  }

  @Override
  public String deleteHat(int hatId) {
    String sql = ""
        + "DELETE FROM hats "
        + "WHERE hat_id = :hat_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("hat_id", hatId);
    
    jdbcTemplate.update(sql, params);
    
    return "Hat with ID=" + hatId + " was successfully deleted.";
  }
  
  public Hat getHat(int hatId) {
    String sql = ""
        + "SELECT * "
        + "FROM hats "
        + "WHERE hat_id = :hat_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("hat_id", hatId);
    
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
    
    if (hats.isEmpty())
      throw new ResourceNotFoundException("Hat", "ID", hatId);
    
    return hats.get(0);
  }

}
