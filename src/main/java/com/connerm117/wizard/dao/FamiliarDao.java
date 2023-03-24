package com.connerm117.wizard.dao;

import com.connerm117.wizard.entity.Familiar;
import com.connerm117.wizard.entity.FamiliarType;

public interface FamiliarDao {

  Familiar createFamiliar(int wizardId, String familiarName, FamiliarType familiarType,
      Integer dangerRating);
  
  String deleteFamiliar(int wizardId);
}
