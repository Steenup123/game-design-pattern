import java.util.ArrayList;
import java.util.List;

// Classe représentant un groupe d'unités
class Group implements GameEntity {
    private List<Unit> units;
    private int speed;
    private int foodCost;

    public Group() {
        this.units = new ArrayList<>();
        this.speed = 0;
        this.foodCost = 0;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
        updateSpeed();
        updateFoodCost();
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
        updateSpeed();
        updateFoodCost();
    }

    private void updateSpeed() {
        // Mettre à jour la vitesse du groupe en fonction de la vitesse de l'unité la plus lente
        int minSpeed = Integer.MAX_VALUE;
        for (Unit unit : units) {
            if (unit.getSpeed() < minSpeed) {
                minSpeed = unit.getSpeed();
            }
        }
        speed = minSpeed;
    }

    private void updateFoodCost() {
        // Mettre à jour le coût en nourriture du groupe en fonction du coût en nourriture de toutes les unités
        foodCost = 0;
        for (Unit unit : units) {
            foodCost += unit.getFoodCost();
        }
    }

    public void move() {
        // Logique de déplacement du groupe d'unités
        System.out.println("Le groupe d'unités se déplace.");
        for (Unit unit : units) {
            unit.move();
        }
    }

    public void work() {
        // Logique de travail du groupe d'unités et de collecte de ressources
        System.out.println("Le groupe d'unités travaille et collecte des ressources.");
        for (Unit unit : units) {
            unit.work();
        }
    }

    public void update() {
        // Logique de mise à jour de l'état du groupe d'unités
        System.out.println("Mise à jour du groupe d'unités.");
        for (Unit unit : units) {
            unit.update();
        }
    }
}
