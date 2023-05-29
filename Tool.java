// Classe représentant un outil
class Tool {
    private int level;

    public Tool() {
        level = 1;
    }

    public void upgrade() {
        // Logique de mise à niveau de l'outil
        System.out.println("L'outil a été amélioré au niveau " + (level + 1));
        level++;
    }
}
