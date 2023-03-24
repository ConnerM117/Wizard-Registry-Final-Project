package com.connerm117.wizard.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.connerm117.wizard.entity.Spell;
import com.connerm117.wizard.service.DefaultSpellService;

@RestController
public class DefaultSpellController implements SpellController {

  @Autowired
  DefaultSpellService spellService;

  @Override
  public List<Spell> getAllSpells() {
    return spellService.getAllSpells();
  }

  @Override
  public Spell getSpellById(int spellId) {
    return spellService.getSpellById(spellId);
  }

  @Override
  public Spell createSpell(String spellName, String spellDescription) {
    return spellService.createSpell(spellName, spellDescription);
  }

  @Override
  public Spell updateSpell(int spellId, String newSpellDescription) {
    return spellService.updateSpell(spellId, newSpellDescription);
  }

  @Override
  public String deleteSpell(int spellId) {
    return spellService.deleteSpell(spellId);
  }

}
