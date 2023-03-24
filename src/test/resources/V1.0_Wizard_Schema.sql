DROP TABLE IF EXISTS familiars;
DROP TABLE IF EXISTS hats;
DROP TABLE IF EXISTS wizard_spells;
DROP TABLE IF EXISTS spells;
DROP TABLE IF EXISTS wizards;

CREATE TABLE wizards (
	wizard_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    wizard_name VARCHAR(128) NOT NULL,
    age INT UNSIGNED,
    is_menace_to_society BOOL NOT NULL,
    PRIMARY KEY (wizard_id)
);

CREATE TABLE hats (
	hat_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    wizard_id INT UNSIGNED NOT NULL,
    hat_name VARCHAR(128) NOT NULL,
    hat_description VARCHAR(128),
    is_sentient BOOL NOT NULL,
    PRIMARY KEY (hat_id),
    FOREIGN KEY (wizard_id) REFERENCES wizards (wizard_id) ON DELETE CASCADE
);

CREATE TABLE familiars (
	familiar_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    wizard_id INT UNSIGNED NOT NULL,
    familiar_name VARCHAR(32) NOT NULL,
    familiar_type enum('CAT', 'OWL', 'TOAD', 'DRAGONET') NOT NULL,
    danger_rating INT UNSIGNED,
    PRIMARY KEY (familiar_id),
    FOREIGN KEY (wizard_id) REFERENCES wizards (wizard_id) ON DELETE CASCADE
);

CREATE TABLE spells (
	spell_id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    spell_name VARCHAR(128) NOT NULL,
    spell_description VARCHAR(128) NOT NULL,
    PRIMARY KEY (spell_id)
);

CREATE TABLE wizard_spells (
	wizard_id INT UNSIGNED NOT NULL,
    spell_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (wizard_id) REFERENCES wizards (wizard_id) ON DELETE CASCADE,
    FOREIGN KEY (spell_id) REFERENCES spells (spell_id) ON DELETE CASCADE
);