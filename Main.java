// Classe principale du programme
public class Main {
    public static void main(String[] args) {
        // Création du jeu avec une taille de 20x20
        Game game = new Game(20, 20);

        // Ajouter les entités (bâtiments, unités, etc.) au jeu
        game.addEntity(new Building("Building 1", BuildingType.RESOURCE, 5, ResourceType.GOLD, new int[]{2, 0, 0, 0}));
        game.addEntity(new Building("Building 2", BuildingType.PRODUCTION, 3, ResourceType.WOOD, new int[]{0, 3, 0, 0}));
        game.addEntity(new Unit("Unit 1", 2, 1));
        game.addEntity(new Unit("Unit 2", 1, 1));

        // Démarrer le jeu
        game.start();
    }
}
