package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProviderImpl implements IPokemonMetadataProvider{

    private Map<Integer, PokemonMetadata> metadataMap;

    public PokemonMetadataProviderImpl() {
        this.metadataMap = new HashMap<>();
        // Ajout de métadata de chaque Pokémon
        metadataMap.put(1, new PokemonMetadata(1, "Bulbasaur", 126, 126, 90));
        metadataMap.put(2, new PokemonMetadata(2, "Ivysaur", 156, 158, 120));

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata metadata = metadataMap.get(index);
        if (metadata == null) {
            throw new PokedexException("Aucune métadata trouvée pour Pokemon avec index: " + index);
        }
        return metadata;
    }



}
