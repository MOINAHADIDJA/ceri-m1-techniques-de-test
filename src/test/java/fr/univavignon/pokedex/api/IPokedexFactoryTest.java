package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {


    @Test
    public void testCreatePokedex() {

        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        IPokedexFactory factory = mock(IPokedexFactory.class);

        IPokedex iPok = mock(IPokedex.class);

        when(factory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(iPok);

        IPokedex actualPok = factory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull("Le Pokedex créé ne doit pas être nul.", actualPok);
        // Vérifier que le Pokedex retourné est le même que celui retourné par Mockito
        assertSame("Le Pokedex créé ne correspond pas au Pokedex attendu.", iPok, actualPok);
    }
}
