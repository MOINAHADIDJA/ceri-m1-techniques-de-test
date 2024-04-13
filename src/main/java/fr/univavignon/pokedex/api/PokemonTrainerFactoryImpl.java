package fr.univavignon.pokedex.api;

/**
 * Implémentation de l'interface IPokemonTrainerFactory pour la création de dresseurs de Pokémon.
 */
public class PokemonTrainerFactoryImpl implements IPokemonTrainerFactory{

    private IPokemonMetadataProvider metaProvider;
    private IPokemonFactory pfactory;

    /**
     * Constructeur de PokemonTrainerFactoryImpl.
     *
     * @param metadataProvider Fournisseur de métadonnées des Pokémon.
     * @param pokemonFactory   Fabrique de Pokémon.
     */
    public PokemonTrainerFactoryImpl(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metaProvider = metadataProvider;
        this.pfactory = pokemonFactory;
    }

    /**
     * Crée un nouveau dresseur de Pokémon.
     *
     * @param name           Le nom du dresseur.
     * @param team           L'équipe du dresseur.
     * @param pokedexFactory La fabrique de Pokédex à utiliser pour créer le Pokédex du dresseur.
     * @return Le dresseur de Pokémon créé.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(metaProvider, pfactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}
