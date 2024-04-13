package fr.univavignon.pokedex.api;

/**
 * Implémentation de l'interface IPokedexFactory pour la création de Pokédex.
 */
public class PokedexFactoryImpl implements IPokedexFactory {

    /**
     * Crée un nouveau Pokédex avec les fournisseurs de métadonnées et de Pokémon spécifiés.
     *
     * @param metadataProvider Le fournisseur de métadonnées des Pokémon.
     * @param pokemonFactory   La fabrique de Pokémon.
     * @return Un nouvel objet IPokedex.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new PokedexImpl(metadataProvider, pokemonFactory);
        //
    }
}
