package com.connerm117.wizard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.connerm117.wizard.entity.Hat;
import com.connerm117.wizard.service.DefaultHatService;

@RestController
public class DefaultHatController implements HatController {

  @Autowired
  DefaultHatService hatService;
  
  @Override
  public Hat createHat(int wizardId, String hatName, String hatDescription, boolean isSentient) {
    return hatService.createHat(wizardId, hatName, hatDescription, isSentient);
  }

  @Override
  public String deleteHat(int hatId) {
    return hatService.deleteHat(hatId);
  }

}
