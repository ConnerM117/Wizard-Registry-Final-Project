package com.connerm117.wizard.service;

import java.util.List;
import com.connerm117.wizard.entity.Spell;

public interface SpellService {
  List<Spell> getAllSpells();
  
  Spell getSpellById(int spellId);
  
  Spell createSpell(String spellName, String spellDescription);
  
  Spell updateSpell(int spellId, String newSpellDescription);
  
  String deleteSpell(int spellId);
}
