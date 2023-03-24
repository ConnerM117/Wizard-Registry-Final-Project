package com.connerm117.wizard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connerm117.wizard.dao.DefaultFamiliarDao;
import com.connerm117.wizard.entity.Familiar;
import com.connerm117.wizard.entity.FamiliarType;

@Service
public class DefaultFamiliarService implements FamiliarService {

  @Autowired
  DefaultFamiliarDao familiarDao;
  
  @Override
  public Familiar createFamiliar(int wizardId, String familiarName, FamiliarType familiarType,
      Integer dangerRating) {
    return familiarDao.createFamiliar(wizardId, familiarName, familiarType, dangerRating);
  }

  @Override
  public String deleteFamiliar(int wizardId) {
    return familiarDao.deleteFamiliar(wizardId);
  }

}
