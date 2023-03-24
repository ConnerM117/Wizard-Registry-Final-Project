package com.connerm117.wizard.service;

import com.connerm117.wizard.entity.Hat;

public interface HatService {

  Hat createHat(int wizardId, String hatName, String hatDescription, boolean isSentient);
  
  String deleteHat(int hatId);
}
