package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Implémentation de l'interface IPokemonMetadataProvider pour fournir les métadonnées des Pokémon.
 */
public class PokemonMetadataProviderImpl implements IPokemonMetadataProvider{

    private Map<Integer, PokemonMetadata> metadataMap;

    /**
     * Constructeur par défaut de PokemonMetadataProviderImpl.
     * Initialise une map contenant les métadonnées de certains Pokémon.
     */
    public PokemonMetadataProviderImpl() {
        this.metadataMap = new HashMap<>();
        // Ajout de métadonnées pour chaque Pokémon
        metadataMap.put(1, new PokemonMetadata(1, "Bulbasaur", 126, 126, 90));
        metadataMap.put(2, new PokemonMetadata(2, "Ivysaur", 156, 158, 120));
        metadataMap.put(3, new PokemonMetadata(3, "Pikachu", 112, 96, 70));
    }

    /**
     * Récupère les métadonnées d'un Pokémon à partir de son index.
     *
     * @param index L'index du Pokémon dont on veut récupérer les métadonnées.
     * @return Les métadonnées du Pokémon correspondant à l'index spécifié.
     * @throws PokedexException Si aucune métadonnée n'est trouvée pour le Pokémon avec l'index donné.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata metadata = metadataMap.get(index);
        if (metadata == null) {
            throw new PokedexException("Aucune métadonnée trouvée pour le Pokémon avec l'index: " + index);
        }
        return metadata;
    }
}
