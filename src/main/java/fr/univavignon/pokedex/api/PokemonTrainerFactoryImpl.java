package fr.univavignon.pokedex.api;

public class PokemonTrainerFactoryImpl implements IPokemonTrainerFactory{

    private IPokemonMetadataProvider metaProvider;
    private IPokemonFactory pfactory;

    public PokemonTrainerFactoryImpl(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metaProvider = metadataProvider;
        this.pfactory = pokemonFactory;
    }
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {


            IPokedex pokedex = pokedexFactory.createPokedex(metaProvider,pfactory );
            return new PokemonTrainer(name, team, pokedex);

    }
}
