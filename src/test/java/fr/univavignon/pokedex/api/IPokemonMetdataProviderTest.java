package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class IPokemonMetdataProviderTest {


    @Test
    public void testGetPokemonMetadata() throws PokedexException {

        // Créer un mock pour l'interface IPokemonMetadataProvider
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        // Configurer le comportement du mock
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(1, "first_pokemon", 25, 29, 29));

        // Utiliser le mock dans le test
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);

        // Assertions pour vérifier les résultats du test
        assert metadata.getIndex() == 1;
        assert "first_pokemon".equals(metadata.getName());
        assert metadata.getAttack() == 25;
        assert metadata.getDefense() == 29;
        assert metadata.getStamina() == 29;
    }
}
