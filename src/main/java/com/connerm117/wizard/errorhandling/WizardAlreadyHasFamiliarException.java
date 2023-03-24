package com.connerm117.wizard.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WizardAlreadyHasFamiliarException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private int wizardId;
  
  public WizardAlreadyHasFamiliarException(int wizardId) {
    super("Wizard with ID=" + wizardId + " already has a familiar. Delete the existing one to create a new one.");
    this.wizardId = wizardId;
  }
  
  public int getWizardId() {
    return wizardId;
  }

}
