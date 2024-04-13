package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implémentation de l'interface IPokedex pour la gestion des Pokémon dans le Pokédex.
 */
public class PokedexImpl implements IPokedex {

    private List<Pokemon> pokemons;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;;

    /**
     * Constructeur de la classe PokedexImpl.
     *
     * @param metadataProvider Le fournisseur de métadonnées des Pokémon.
     * @param pokemonFactory   La fabrique de Pokémon.
     */
    public PokedexImpl(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemons = new ArrayList<>();;
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Retourne le nombre de Pokémon dans le Pokédex.
     *
     * @return Le nombre de Pokémon dans le Pokédex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Ajoute un Pokémon au Pokédex.
     *
     * @param pokemon Le Pokémon à ajouter.
     * @return L'index du Pokémon ajouté.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    /**
     * Récupère un Pokémon du Pokédex en fonction de son identifiant.
     *
     * @param id L'identifiant du Pokémon à récupérer.
     * @return Le Pokémon correspondant à l'identifiant spécifié.
     * @throws PokedexException Si aucun Pokémon avec cet identifiant n'est trouvé.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon != null && pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        throw new PokedexException("Pokemon with ID " + id + " not found.");
    }

    /**
     * Récupère une copie de la liste des Pokémon du Pokédex.
     *
     * @return Une copie de la liste des Pokémon du Pokédex.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons); // Return a copy to prevent modification
    }

    /**
     * Récupère une liste des Pokémon du Pokédex triés selon l'ordre spécifié.
     *
     * @param order Le comparateur pour l'ordre de tri.
     * @return Une liste des Pokémon triés selon l'ordre spécifié.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
    }

    /**
     * Récupère les métadonnées d'un Pokémon à partir de son index.
     *
     * @param index L'index du Pokémon.
     * @return Les métadonnées du Pokémon correspondant à l'index spécifié.
     * @throws PokedexException Si aucune métadonnée n'est trouvée pour le Pokémon avec l'index spécifié.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    /**
     * Crée un nouveau Pokémon avec les attributs spécifiés.
     *
     * @param index L'index du Pokémon.
     * @param cp    Les points de combat du Pokémon.
     * @param hp    Les points de vie du Pokémon.
     * @param dust  La poussière d'étoile du Pokémon.
     * @param candy Le bonbon du Pokémon.
     * @return Le Pokémon créé.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}
