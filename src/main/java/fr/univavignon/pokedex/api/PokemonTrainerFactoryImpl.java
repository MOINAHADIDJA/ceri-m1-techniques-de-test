package fr.univavignon.pokedex.api;

public class PokemonTrainerFactoryImpl implements IPokemonTrainerFactory{
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {

            IPokemonMetadataProvider pMetaProvider = new PokemonMetadataProviderImpl();
            IPokemonFactory pfactory = new PokemonFactoryImpl();
            IPokedex pokedex = pokedexFactory.createPokedex(pMetaProvider,pfactory );
            return new PokemonTrainer(name, team, pokedex);

    }
}
