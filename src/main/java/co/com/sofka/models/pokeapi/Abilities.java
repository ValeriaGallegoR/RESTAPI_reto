package co.com.sofka.models.pokeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.runner.Result;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Abilities {


    private Ability ability;
    private Boolean is_hidden;
    private Integer slot;

    public Abilities(Ability ability, Boolean is_hidden, Integer slot) {
        this.ability = ability;
        this.is_hidden = is_hidden;
        this.slot = slot;
    }

    public Ability getAbility() {
        return ability;
    }
    public Boolean getIs_hidden() {
        return is_hidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Abilities()
    {
        super();
    }


}