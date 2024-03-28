package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;


    @Before
    public void setUp() {
        metadataProvider = mock(PokemonMetadataProviderImpl.class);
        pokemonFactory = mock(PokemonFactoryImpl.class);
        pokedex = new PokedexImpl(metadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = pokedex.createPokemon(1, 431, 35, 100, 25);
        pokedex.addPokemon(pokemon);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(1, index);
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(4, "mo",423, 36, 120, 45,3,6,3,0.8);
        pokedex.addPokemon(pokemon);
        Pokemon expected = pokedex.getPokemon(4);
        assertNotNull(expected);
        assertEquals(expected, pokemon);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidIndex() throws PokedexException {
        pokedex.getPokemon(-1);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(0, pokemons.size());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        pokedex.addPokemon(new Pokemon(2, "mo",423, 36, 120, 45,3,6,3,0.8));
        pokedex.addPokemon(new Pokemon(1, "na",43, 6, 108, 57,9,4,3,0.4));

        Comparator<Pokemon> orderByIndex = Comparator.comparing(Pokemon::getIndex);
        List<Pokemon> pokemons = pokedex.getPokemons(orderByIndex);

        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(1, pokemons.get(0).getIndex());
        assertEquals(2, pokemons.get(1).getIndex());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = new PokemonMetadata(2, "Bulbasaur", 45, 49, 49);
        assertNotNull(metadata);
        assertEquals(2, metadata.getIndex());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = new Pokemon(3, "ha",43, 6, 108, 57,9,4,3,0.4);
        assertNotNull(pokemon);
        assertEquals(3, pokemon.getIndex());
        assertEquals("ha", pokemon.getName());
    }
}
