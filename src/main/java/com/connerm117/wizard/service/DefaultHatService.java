package com.connerm117.wizard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connerm117.wizard.dao.DefaultHatDao;
import com.connerm117.wizard.entity.Hat;

@Service
public class DefaultHatService implements HatService {

  @Autowired
  DefaultHatDao hatDao;
  
  @Override
  public Hat createHat(int wizardId, String hatName, String hatDescription, boolean isSentient) {
    return hatDao.createHat(wizardId, hatName, hatDescription, isSentient);
  }

  @Override
  public String deleteHat(int hatId) {
    return hatDao.deleteHat(hatId);
  }

}
