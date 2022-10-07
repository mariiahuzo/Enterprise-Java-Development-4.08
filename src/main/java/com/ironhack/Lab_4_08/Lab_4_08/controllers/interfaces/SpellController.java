package com.ironhack.Lab_4_08.Lab_4_08.controllers.interfaces;

import com.ironhack.Lab_4_08.Lab_4_08.models.Spell;

public interface SpellController {
    Spell saveSpell(Spell spell);
    void updateSpellLevel(Integer id, String level);
}
