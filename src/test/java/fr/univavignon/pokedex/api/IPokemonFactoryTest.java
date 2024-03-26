package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        IPokemonFactory pokemonFactory = new PokemonFactoryImpl();
        Pokemon pokemon = pokemonFactory.createPokemon(1, 100, 80, 2000, 5);
        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(126, pokemon.getAttack());
        assertEquals(126, pokemon.getDefense());
        assertEquals(90, pokemon.getStamina());
        assertEquals(100, pokemon.getCp());
        assertEquals(80, pokemon.getHp());
        assertEquals(2000, pokemon.getDust());
        assertEquals(5, pokemon.getCandy());
        assertEquals(0.0, pokemon.getIv(), 0.01);
    }
}
