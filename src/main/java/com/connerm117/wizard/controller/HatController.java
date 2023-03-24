package com.connerm117.wizard.controller;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.connerm117.wizard.entity.Hat;

@Validated
@RequestMapping("/hats")
public interface HatController {

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Hat createHat(@RequestParam(required = true) int wizardId,
      @Length(max = 32) @Pattern(regexp = "[\\w\\s]*") @RequestParam(required = true) String hatName,
      @Length(max = 128) @RequestParam(required = true) String hatDescription,
      @RequestParam(required = true) boolean isSentient);
  
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  String deleteHat(@RequestParam(required = true) int hatId);
}
