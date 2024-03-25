package fr.univavignon.pokedex.api;

public class PokemonFactoryImpl implements IPokemonFactory{
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        try {
            IPokemonMetadataProvider metadataProvider = new PokemonMetadataProviderImpl();
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
            return new Pokemon(index, metadata.getName(), metadata.getAttack(),metadata.getDefense(), metadata.getStamina(), cp,hp,dust,candy,0.0);
        } catch (PokedexException e) {
            e.printStackTrace();
            return null;
        }
    }
}
