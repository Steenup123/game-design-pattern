import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface commune à toutes les entités du jeu
interface GameEntity {
    void update();
}

// Énumération pour les types de ressources
enum ResourceType {
    GOLD,
    WOOD,
    STONE,
    FOOD
}

// Classe représentant une unité
class Unit implements GameEntity {
    private String name;
    private int speed;
    private int foodCost;
    private boolean mounted;
    private int experience;
    private int level;
    private Tool tool;

    public Unit(String name, int speed, int foodCost) {
        this.name = name;
        this.speed = speed;
        this.foodCost = foodCost;
        this.mounted = false;
        this.experience = 0;
        this.level = 1;
        this.tool = new Tool();
    }

    public void move(int x, int y) {
        // Logique pour déplacer l'unité vers les coordonnées spécifiées
        System.out.println(name + " se déplace vers (" + x + ", " + y + ").");
    }

    // Les autres méthodes de la classe Unit...

    public void update() {
        // Logique pour mettre à jour l'état de l'unité
        System.out.println("Mise à jour de l'unité : " + name);
    }
}

// Classe représentant un outil
class Tool {
    private int level;

    public Tool() {
        level = 1;
    }

    public void upgrade() {
        // Logique pour améliorer l'outil
        System.out.println("L'outil a été amélioré au niveau " + (level + 1));
        level++;
    }
}

// Classe représentant un bâtiment
class Building implements GameEntity {
    private String name;
    private BuildingType type;
    private List<Unit> units;
    private List<Tool> tools;
    private int productionInterval;
    private ResourceType resourceType;
    private int[] resourceCost;
    private int[] resourceCountdown;

    public Building(String name, BuildingType type, int productionInterval, ResourceType resourceType, int[] resourceCost) {
        this.name = name;
        this.type = type;
        this.productionInterval = productionInterval;
        this.resourceType = resourceType;
        this.resourceCost = resourceCost;
        this.resourceCountdown = new int[resourceCost.length];
        this.units = new ArrayList<>();
        this.tools = new ArrayList<>();
    }

    // Les autres méthodes de la classe Building...

    public void produceUnit() {
        // Logique pour produire une unité
        System.out.println("Production d'une unité depuis " + name);
        units.add(new Unit(name + "'s Unit", 1, 1));
    }
    
    public void produceTool() {
        // Logique pour produire un outil
        System.out.println("Production d'un outil depuis " + name);
        tools.add(new Tool());
    }
}

// Énumération pour les types de bâtiments
enum BuildingType {
    RESOURCE,
    PRODUCTION
}

// Classe représentant le jeu
class Game {
    private List<GameEntity> entities;
    private int[][] resources;
    private int[] playerResources;
    private Scanner scanner;

    public Game(int x, int y) {
        entities = new ArrayList<>();
        resources = new int[x][y];
        playerResources = new int[4]; // En supposant 4 types de ressources
        scanner = new Scanner(System.in);
    }

    // Les autres méthodes de la classe Game...

    public void moveUnits() {
        System.out.print("Entrez les coordonnées de destination (x y) : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.nextLine(); // Consommer le caractère de nouvelle ligne

        for (GameEntity entity : entities) {
            if (entity instanceof Unit) {
                Unit unit = (Unit) entity;
                unit.move(x, y);
            }
        }

        System.out.println("Déplacement des unités vers la position : (" + x + ", " + y + ")");
    }

    public void start() {
        // Logique pour démarrer le jeu
        System.out.println("Démarrage du jeu...");

        // Boucle principale du jeu
        boolean running = true;
        while (running) {
            // Afficher le menu des actions possibles
            System.out.println("\nMENU");
            System.out.println("1. Produire une unité");
            System.out.println("2. Produire un outil");
            System.out.println("3. Déplacer des unités");
            System.out.println("4. Quitter");

            // Lire le choix du joueur
            System.out.print("Choisissez une action : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer le caractère de nouvelle ligne

            // Exécuter l'action choisie
            switch (choice) {
                case 1:
                    produceUnit();
                    break;
                case 2:
                    produceTool();
                    break;
                case 3:
                    moveUnits();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Action invalide. Veuillez réessayer.");
            }

            // Mettre à jour toutes les entités du jeu
            for (GameEntity entity : entities) {
                entity.update();
            }
        }

        // Fermer le scanner
        scanner.close();

        System.out.println("Fin du jeu.");
    }
}

