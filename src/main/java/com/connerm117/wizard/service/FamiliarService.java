package com.connerm117.wizard.service;

import com.connerm117.wizard.entity.Familiar;
import com.connerm117.wizard.entity.FamiliarType;

public interface FamiliarService {
  
  Familiar createFamiliar(int wizardId, String familiarName, FamiliarType familiarType,
      Integer dangerRating);
  
  String deleteFamiliar(int wizardId);
}
