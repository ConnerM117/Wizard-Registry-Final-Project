package com.connerm117.wizard.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connerm117.wizard.dao.DefaultSpellDao;
import com.connerm117.wizard.entity.Spell;

@Service
public class DefaultSpellService implements SpellService {

  @Autowired
  DefaultSpellDao spellDao;
  
  @Override
  public List<Spell> getAllSpells() {
    return spellDao.getAllSpells();
  }

  @Override
  public Spell getSpellById(int spellId) {
    return spellDao.getSpellById(spellId);
  }

  @Override
  public Spell createSpell(String spellName, String spellDescription) {
    return spellDao.createSpell(spellName, spellDescription);
  }

  @Override
  public Spell updateSpell(int spellId, String newSpellDescription) {
    return spellDao.updateSpell(spellId, newSpellDescription);
  }

  @Override
  public String deleteSpell(int spellId) {
    return spellDao.deleteSpell(spellId);
  }

}
