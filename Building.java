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

    public void produceUnit() {
        // Logique de production d'une unité
        System.out.println("Production d'une unité depuis " + name);
        units.add(new Unit(name + " - Unité"));
    }

    public void produceTool() {
        // Logique de production d'un outil
        System.out.println("Production d'un outil depuis " + name);
        tools.add(new Tool());
    }

    public void update() {
        // Logique de mise à jour de l'état du bâtiment
        System.out.println("Mise à jour du bâtiment : " + name);
    }
}
