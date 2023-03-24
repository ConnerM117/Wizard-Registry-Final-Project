package com.connerm117.wizard.dao;

import java.util.List;
import com.connerm117.wizard.entity.Spell;

public interface SpellDao {
  List<Spell> getAllSpells();
  
  Spell getSpellById(int spellId);
  
  Spell createSpell(String spellName, String spellDescription);
  
  Spell updateSpell(int spellId, String newspellDescription);
  
  String deleteSpell(int spellId);
}
