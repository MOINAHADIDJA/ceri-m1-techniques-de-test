package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Test
    public void testCreatePokemon() {
        // Créer une instance de l'implémentation de IPokemonFactory (supposons que vous ayez une classe ConcretePokemonFactory)
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Définir le comportement attendu lorsque la méthode createPokemon est appelée
        when(pokemonFactory.createPokemon(1, 100, 80, 2000, 5))
                .thenReturn(new Pokemon(1, "Pikachu", 50, 50, 50, 100, 80, 2000, 5, 90.0));

        // Appeler la méthode createPokemon
        Pokemon pokemon = pokemonFactory.createPokemon(1, 100, 80, 2000, 5);

        // Vérifier les attributs du Pokemon créé
        assertEquals(1, pokemon.getIndex());
        assertEquals("Pikachu", pokemon.getName());
        assertEquals(50, pokemon.getAttack());
        assertEquals(50, pokemon.getDefense());
        assertEquals(50, pokemon.getStamina());

        assertEquals(100, pokemon.getCp());
        assertEquals(80, pokemon.getHp());
        assertEquals(2000, pokemon.getDust());
        assertEquals(5, pokemon.getCandy());
        assertEquals(90.0, pokemon.getIv(), 0.01);
    }
}
