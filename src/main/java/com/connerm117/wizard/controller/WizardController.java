package com.connerm117.wizard.controller;

import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.connerm117.wizard.entity.Wizard;

@Validated
@RequestMapping("/wizards")
public interface WizardController {

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Wizard> getAllWizards();

  @GetMapping("{wizard_id}")
  @ResponseStatus(code = HttpStatus.OK)
  Wizard getWizardById(@PathVariable("wizard_id") int wizardId);

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Wizard createWizard(@Length(max = 32) @Pattern(regexp = "[\\w\\s]*") @RequestParam(required = true) String name,
      @Min(18) @RequestParam(required = false) int age,
      @RequestParam(required = true) boolean isMenaceToSociety);

  @PutMapping("/addSpell")
  @ResponseStatus(code = HttpStatus.OK)
  String addSpellToWizard(@RequestParam(required = true) int wizardId,
      @RequestParam(required = true) int spellId);

  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Wizard updateWizard(@RequestParam(required = true) int wizardId,
      @Length(max = 32) @Pattern(regexp = "[\\w\\s]*") @RequestParam(required = true) String name, 
      @RequestParam(required = false) int age,
      @RequestParam(required = true) boolean isMenaceToSociety);

  @PutMapping("/removeSpell")
  @ResponseStatus(code = HttpStatus.OK)
  String removeSpellFromWizard(@RequestParam(required = true) int wizardId,
      @RequestParam(required = true) int spellId);

  @DeleteMapping("{wizard_id}")
  @ResponseStatus(code = HttpStatus.OK)
  String deleteWizard(@RequestParam(required = true) int wizardId);

}
