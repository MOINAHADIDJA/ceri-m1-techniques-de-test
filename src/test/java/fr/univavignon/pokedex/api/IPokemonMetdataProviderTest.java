package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokemonMetdataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        metadataProvider = new PokemonMetadataProviderImpl();
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);
        assertNotNull(metadata);
        assertEquals(1, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }
}
