package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedex pokedex;
    private   IPokedexFactory factory;

    @Before
    public void setUp() {
        metadataProvider = mock(PokemonMetadataProviderImpl.class);
        pokemonFactory = mock(PokemonFactoryImpl.class);
        pokedex = mock(PokedexImpl.class);
        factory = new PokedexFactoryImpl();
    }

    @Test
    public void testCreatePokedex() {

        metadataProvider = new PokemonMetadataProviderImpl();
        pokemonFactory = new PokemonFactoryImpl();
        pokedex = factory.createPokedex(metadataProvider, pokemonFactory);
        assertNotNull(pokedex);
    }
}
