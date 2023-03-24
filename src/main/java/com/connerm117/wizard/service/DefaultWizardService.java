package com.connerm117.wizard.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connerm117.wizard.dao.DefaultWizardDao;
import com.connerm117.wizard.entity.Wizard;

@Service
public class DefaultWizardService implements WizardService {

  @Autowired
  DefaultWizardDao wizardDao;
  
  @Override
  public List<Wizard> getAllWizards() {
    return wizardDao.getAllWizards();
  }

  @Override
  public Wizard getWizardById(int wizardId) {
    return wizardDao.getWizardById(wizardId);
  }

  @Override
  public Wizard createWizard(String name, int age, boolean isMenaceToSociety) {
    return wizardDao.createWizard(name, age, isMenaceToSociety);
  }

  @Override
  public Wizard updateWizard(int wizardId, String name, int age, boolean isMenaceToSociety) {
    return wizardDao.updateWizard(wizardId, name, age, isMenaceToSociety);
  }

  @Override
  public String deleteWizard(int wizardId) {
    return wizardDao.deleteWizard(wizardId);
  }

  @Override
  public String addSpellToWizard(int wizardId, int spellId) {
    return wizardDao.addSpellToWizard(wizardId, spellId);
  }

  @Override
  public String removeSpellFromWizard(int wizardId, int spellId) {
    return wizardDao.removeSpellFromWizard(wizardId, spellId);
  }

}
