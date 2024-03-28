package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;
    private IPokemonTrainerFactory trainerFactory;

    @Before
    public void setUp() {
        metadataProvider = mock(PokemonMetadataProviderImpl.class);
        pokemonFactory = mock(PokemonFactoryImpl.class);
        pokedexFactory = mock(PokedexFactoryImpl.class);
        pokedex = mock(PokedexImpl.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);

        trainerFactory = new PokemonTrainerFactoryImpl(metadataProvider,pokemonFactory);
    }
    @Test
    public void testCreateTrainer() {

        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.MYSTIC, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());
        assertNotNull(trainer.getPokedex());
    }
}
