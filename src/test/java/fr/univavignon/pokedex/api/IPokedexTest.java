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

    private PokedexImpl pokedex;

    @Before
    public void setUp() {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProviderImpl();
        IPokemonFactory pokemonFactory = new PokemonFactoryImpl();
        pokedex = new PokedexImpl(metadataProvider, pokemonFactory);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = pokedex.createPokemon(3, 431, 35, 100, 25);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        pokedex.addPokemon(pokedex.createPokemon(3, 431, 35, 100, 25));
        Pokemon pokemon = pokedex.getPokemon(0);
        assertNotNull(pokemon);
        assertEquals(3, pokemon.getIndex());
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
        pokedex.addPokemon(pokedex.createPokemon(3, 431, 35, 100, 25));
        pokedex.addPokemon(pokedex.createPokemon(1, 100, 45, 200, 10));

        Comparator<Pokemon> orderByIndex = Comparator.comparing(Pokemon::getIndex);
        List<Pokemon> pokemons = pokedex.getPokemons(orderByIndex);

        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(1, pokemons.get(0).getIndex());
        assertEquals(3, pokemons.get(1).getIndex());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(3);
        assertNotNull(metadata);
        assertEquals(3, metadata.getIndex());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokedex.createPokemon(3, 431, 35, 100, 25);
        assertNotNull(pokemon);
        assertEquals(3, pokemon.getIndex());
        assertEquals("Pikachu", pokemon.getName());
    }
}
