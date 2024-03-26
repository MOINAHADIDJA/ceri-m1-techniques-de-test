package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {


    @Test
    public void testCreatePokedex() {
        IPokedexFactory factory = new PokedexFactoryImpl();
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProviderImpl();
        IPokemonFactory pokemonFactory = new PokemonFactoryImpl();
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}
