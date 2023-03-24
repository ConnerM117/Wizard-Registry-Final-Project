package com.connerm117.wizard.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.connerm117.wizard.entity.Familiar;
import com.connerm117.wizard.entity.FamiliarType;

@Validated
@RequestMapping("/familiars")
public interface FamiliarController {

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Familiar createFamiliar(@RequestParam(required = true) int wizardId,
      @Length(max = 32) @Pattern(regexp = "[\\w\\s]*") @RequestParam(required = true) String familiarName,
      @RequestParam(required = true) FamiliarType familiarType,
      @Min(0) @Max(10) @RequestParam(required = false) Integer dangerRating);
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  String deleteFamiliar(@RequestParam(required = true) int wizardId);

}
