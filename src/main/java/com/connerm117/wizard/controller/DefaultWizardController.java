package com.connerm117.wizard.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.connerm117.wizard.entity.Wizard;
import com.connerm117.wizard.service.DefaultWizardService;

@RestController
public class DefaultWizardController implements WizardController {

  @Autowired
  DefaultWizardService wizardService;
  
  @Override
  public List<Wizard> getAllWizards() {
    return wizardService.getAllWizards();
  }

  @Override
  public Wizard getWizardById(int wizardId) {
    return wizardService.getWizardById(wizardId);
  }

  @Override
  public Wizard createWizard(String name, int age, boolean isMenaceToSociety) {
    return wizardService.createWizard(name, age, isMenaceToSociety);
  }

  @Override
  public Wizard updateWizard(int wizardId, String name, int age, boolean isMenaceToSociety) {
    return wizardService.updateWizard(wizardId, name, age, isMenaceToSociety);
  }

  @Override
  public String deleteWizard(int wizardId) {
    return wizardService.deleteWizard(wizardId);
  }

  @Override
  public String addSpellToWizard(int wizardId, int spellId) {
    return wizardService.addSpellToWizard(wizardId, spellId);
  }

  @Override
  public String removeSpellFromWizard(int wizardId, int spellId) {
    return wizardService.removeSpellFromWizard(wizardId, spellId);
  }

}
