package com.connerm117.wizard.dao;

import com.connerm117.wizard.entity.Hat;

public interface HatDao {

  Hat createHat(int wizardId, String hatName, String hatDescription, boolean isSentient);

  String deleteHat(int hatId);
}
