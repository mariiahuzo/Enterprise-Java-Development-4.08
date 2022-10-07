package com.ironhack.Lab_4_08.Lab_4_08.services.impl;


import com.ironhack.Lab_4_08.Lab_4_08.enums.Level;
import com.ironhack.Lab_4_08.Lab_4_08.models.Spell;
import com.ironhack.Lab_4_08.Lab_4_08.repositories.SpellRepository;
import com.ironhack.Lab_4_08.Lab_4_08.services.interfaces.SpellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class SpellServiceImpl implements SpellService {

    @Autowired
    private SpellRepository spellRepository;

    public Spell saveSpell(Spell spell) {
        spell.setId(null);
        return spellRepository.save(spell);
    }

    public void updateSpellLevel(Integer id, String level) {
        Optional<Spell> optionalSpell = spellRepository.findById(id);
        if (optionalSpell.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Spell not found");
        }
        optionalSpell.get().setLevel(Level.valueOf(level.toUpperCase()));
        spellRepository.save(optionalSpell.get());
    }
}
