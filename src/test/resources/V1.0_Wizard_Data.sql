-- Wizards
INSERT INTO wizards (wizard_name, age, is_menace_to_society) VALUES ('Francesca Findabair', NULL, 1);
INSERT INTO wizards (wizard_name, age, is_menace_to_society) VALUES ('Gilbert the Unhelpful', 68, 0);
INSERT INTO wizards (wizard_name, age, is_menace_to_society) VALUES ('Tyrannicus the Tyrant', 146, 1);
INSERT INTO wizards (wizard_name, age, is_menace_to_society) VALUES ('Mascarpone Cheesefiend', 53, 1);
INSERT INTO wizards (wizard_name, age, is_menace_to_society) VALUES ('Merlin', NULL, 0);

-- Hats
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (1, 'Elf Hat', 'Makes your ears pointy when worn', 0);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (1, 'Starry Hat', 'Allows the wearer to blend into darkness, but only on a starry night', 0);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (1, 'Helpful Hat', 'Gives useful advice. Gilbert the Unhelpful would give anything for this', 1);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (2, 'Blue Hat', 'A pointed and wide-brimmed hat dyed blue', 0);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (2, 'Baseball Cap', 'A blue baseball cap adorned with the logo of Gilbert\'s favorite baseball team', 0);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (3, 'Fearsome Helm', 'A horned iron helmet that turns the wearer\'s eyes red', 1);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (3, 'Party Hat', 'A pointed and multicolored hat Tyrannicus only breaks out for special occasions', 0);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (4, 'Gouda Hat', 'Mascarpone\'s favorite cheese-tasting hat', 0);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (4, 'Muenster Hat', 'Mascarpone\'s \"attack\" hat', 1);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (4, 'Cheddar Hat', 'Mascarpone\'s favorite hat for entertaining guests', 0);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (4, 'Parmesan Hat', 'Mascarpone\'s most trusted hat', 1);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (5, 'Merlin\'s Hat', 'Rumored to contain a mote of Merlin\'s power', 1);
INSERT INTO hats (wizard_id, hat_name, hat_description, is_sentient) VALUES (5, 'Pointy Hat', 'A hat covered in spikes', 0);

-- Familiars
INSERT INTO familiars (wizard_id, familiar_name, familiar_type, danger_rating) VALUES (1, 'Barney', 'OWL', 3);
INSERT INTO familiars (wizard_id, familiar_name, familiar_type, danger_rating) VALUES (2, 'Neville', 'TOAD', 1);
INSERT INTO familiars (wizard_id, familiar_name, familiar_type, danger_rating) VALUES (3, 'Fluffy', 'CAT', 4);
INSERT INTO familiars (wizard_id, familiar_name, familiar_type, danger_rating) VALUES (5, 'Lucius', 'DRAGONET', 7);

-- Spells
INSERT INTO spells (spell_name, spell_description) VALUES ('Fireball', 'Creates a highly destructive explosion');
INSERT INTO spells (spell_name, spell_description) VALUES ('Gilbert\'s Cheese Whiz', 'Creates up to one pound of any type of cheese');
INSERT INTO spells (spell_name, spell_description) VALUES ('Invisibility', 'Turns the caster invisible');
INSERT INTO spells (spell_name, spell_description) VALUES ('Eldritch Arrow', 'Fires a blast of magical power');
INSERT INTO spells (spell_name, spell_description) VALUES ('Alchemy', 'Turns iron into gold');
INSERT INTO spells (spell_name, spell_description) VALUES ('Lightning Bolt', 'Fires a powerful lightning bolt');
INSERT INTO spells (spell_name, spell_description) VALUES ('Gilbert\'s Curse', 'The target is cursed to never accomplish some minor task (like the laundry)');
INSERT INTO spells (spell_name, spell_description) VALUES ('Francesca\'s Beauty Cream', 'Makes the caster attractive to all onlookers');
INSERT INTO spells (spell_name, spell_description) VALUES ('Merlin\'s Copyright Infringement', 'Allows the caster to learn a spell cast by someone else');
INSERT INTO spells (spell_name, spell_description) VALUES ('Merlin\'s Marvelous Mansion', 'Creates a portal that leads to a personalized extra-dimensional mansion');
INSERT INTO spells (spell_name, spell_description) VALUES ('Tyrannicus\'s Dominion', 'The target must obey the caster\'s will');

-- Wizard Spells
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (1, 1);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (1, 3);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (1, 5);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (1, 8);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (1, 10);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (2, 2);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (2, 3);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (2, 4);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (2, 7);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (3, 1);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (3, 3);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (3, 4);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (3, 6);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (3, 11);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (4, 2);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (4, 4);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (4, 5);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (4, 8);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (4, 9);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 1);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 2);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 3);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 4);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 5);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 6);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 7);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 8);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 9);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 10);
INSERT INTO wizard_spells (wizard_id, spell_id) VALUES (5, 11);
