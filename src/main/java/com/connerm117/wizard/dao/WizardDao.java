package com.connerm117.wizard.dao;

import java.util.List;
import com.connerm117.wizard.entity.Wizard;

public interface WizardDao {

  List<Wizard> getAllWizards();
  
  Wizard getWizardById(int wizardId);
  
  Wizard createWizard(String name, int age, boolean isMenaceToSociety);
  
  Wizard updateWizard(int wizardId, String name, int age, boolean isMenaceToSociety);
  
  String deleteWizard(int wizardId);
  
  String addSpellToWizard(int wizardId, int spellId);
  
  String removeSpellFromWizard(int wizardId, int spellId);
}
