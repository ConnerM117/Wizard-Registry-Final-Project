package com.connerm117.wizard.controller;

import java.util.List;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.connerm117.wizard.entity.Spell;

@Validated
@RequestMapping("/spells")
public interface SpellController {
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Spell> getAllSpells();

  @GetMapping("{spell_id}")
  @ResponseStatus(code = HttpStatus.OK)
  Spell getSpellById(@RequestParam(required = true) int spellId);

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Spell createSpell(@Length(max = 32) @Pattern(regexp = "[\\w\\s]*") @RequestParam(required = true) String spellName,
      @Length(max = 128) @RequestParam(required = true) String spellDescription);

  @PutMapping("{spell_id}")
  @ResponseStatus(code = HttpStatus.OK)
  Spell updateSpell(@RequestParam(required = true) int spellId,
      @Length(max = 128) @RequestParam(required = true) String newSpellDescription);

  @DeleteMapping("{spell_id}")
  @ResponseStatus(code = HttpStatus.OK)
  String deleteSpell(@RequestParam(required = true) int spellId);
}
