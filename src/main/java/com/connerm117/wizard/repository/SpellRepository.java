package com.connerm117.wizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.connerm117.wizard.entity.Spell;

public interface SpellRepository extends JpaRepository<Spell, Integer> {

}
