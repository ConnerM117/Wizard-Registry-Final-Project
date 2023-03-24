package com.connerm117.wizard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.connerm117.wizard.entity.Wizard;

public interface WizardRepository extends JpaRepository<Wizard, Integer> {

}
