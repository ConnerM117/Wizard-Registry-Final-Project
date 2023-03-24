package com.connerm117.wizard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.connerm117.wizard.entity.Familiar;
import com.connerm117.wizard.entity.FamiliarType;
import com.connerm117.wizard.service.DefaultFamiliarService;

@RestController
public class DefaultFamiliarController implements FamiliarController {

  @Autowired
  DefaultFamiliarService familiarService;
  
  @Override
  public Familiar createFamiliar(int wizardId, String familiarName, FamiliarType familiarType,
      Integer dangerRating) {
    return familiarService.createFamiliar(wizardId, familiarName, familiarType, dangerRating);
  }

  @Override
  public String deleteFamiliar(int wizardId) {
    return familiarService.deleteFamiliar(wizardId);
  }

}
