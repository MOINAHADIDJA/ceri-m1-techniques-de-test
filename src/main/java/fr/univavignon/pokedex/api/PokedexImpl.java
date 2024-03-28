package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokedexImpl implements IPokedex{

    private List<Pokemon> pokemons;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    public PokedexImpl(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemons = new ArrayList<>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon != null && pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Pokemon with ID " + id + " not found.");
    }

    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons); // Return a copy to prevent modification
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}





