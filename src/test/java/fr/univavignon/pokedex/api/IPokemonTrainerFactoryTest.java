package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    @Test
    public void testCreateTrainer() {
        // Mock des dépendances
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);

        // Mock de IPokemonTrainerFactory
        IPokemonTrainerFactory trainerFactory = mock(IPokemonTrainerFactory.class);

        // Création d'un PokemonTrainer fictif pour la comparaison
        PokemonTrainer expectedTrainer = new PokemonTrainer("Ash", Team.MYSTIC, pokedex);

        // Définir le comportement attendu lors de l'appel à createTrainer
        when(trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory)).thenReturn(expectedTrainer);

        // Appeler la méthode createTrainer
        PokemonTrainer actualTrainer = trainerFactory.createTrainer("Ash", Team.MYSTIC, pokedexFactory);

        // Vérifier que le dresseur créé correspond au dresseur attendu
        assertEquals("The trainer's name should match the provided name.", expectedTrainer.getName(), actualTrainer.getName());
        assertEquals("The trainer's team should match the provided team.", expectedTrainer.getTeam(), actualTrainer.getTeam());

        // Vérifier que le dresseur a un Pokedex
        assertNotNull("L'entraîneur doit avoir un Pokedex.",actualTrainer.getPokedex());
    }
}
