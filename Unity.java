// Classe représentant une unité
class Unit implements GameEntity {
    private String name;
    private int speed;
    private int foodCost;
    private boolean mounted;
    private int experience;
    private int level;
    private Tool tool;

    public Unit(String name) {
        this.name = name;
        this.speed = 1; // Vitesse par défaut
        this.foodCost = 1; // Coût en nourriture par défaut
        this.mounted = false;
        this.experience = 0;
        this.level = 1;
        this.tool = new Tool();
    }

    public void move() {
        // Logique de déplacement de l'unité
        System.out.println(name + " se déplace.");
    }

    public void work() {
        // Logique de travail de l'unité et de collecte de ressources
        System.out.println(name + " travaille et collecte des ressources.");
    }

    public void levelUp() {
        // Logique de montée de niveau de l'unité
        System.out.println(name + " a monté de niveau !");
        level++;
    }

    public void mount() {
        // Logique de montée de l'unité sur un cheval
        if (!mounted) {
            System.out.println(name + " est maintenant monté sur un cheval.");
            mounted = true;
        } else {
            System.out.println(name + " est déjà monté sur un cheval.");
        }
    }

    public void dismount() {
        // Logique de descente de l'unité du cheval
        if (mounted) {
            System.out.println(name + " est descendu du cheval.");
            mounted = false;
        } else {
            System.out.println(name + " n'est pas monté sur un cheval.");
        }
    }

    public void update() {
        // Logique de mise à jour de l'état de l'unité
        System.out.println("Mise à jour de l'unité : " + name);
    }
}

