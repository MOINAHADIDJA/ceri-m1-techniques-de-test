package fr.univavignon.pokedex.api;

/**
 * Implémentation de l'interface IPokemonFactory permettant de créer des instances de Pokémon.
 */
public class PokemonFactoryImpl implements IPokemonFactory{

    /**
     * Crée un Pokémon avec les paramètres spécifiés.
     *
     * @param index L'index du Pokémon.
     * @param cp Les points de combat du Pokémon.
     * @param hp Les points de vie du Pokémon.
     * @param dust La quantité de poussière d'étoile utilisée pour améliorer le Pokémon.
     * @param candy La quantité de bonbons utilisée pour améliorer le Pokémon.
     * @return Une instance de Pokemon créée avec les paramètres spécifiés.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        try {
            // Récupération des métadonnées du Pokémon à partir de son index
            IPokemonMetadataProvider metadataProvider = new PokemonMetadataProviderImpl();
            PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);

            // Création et retour du Pokémon avec les métadonnées et les paramètres spécifiés
            return new Pokemon(index, metadata.getName(), metadata.getAttack(),
                    metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, 0.0);
        } catch (PokedexException e) {
            // En cas d'erreur lors de la récupération des métadonnées, affiche une trace de la pile
            e.printStackTrace();
            return null; // Retourne null en cas d'erreur
        }
    }
}
