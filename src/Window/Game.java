package Window;

import Object.Food;
import Object.Pigeon;
import Action.PigeonEat;
import Action.PigeonRun;
import Action.PigeonThreatened;

import java.util.ArrayList;

public class Game {
    private static ArrayList<Pigeon> pigeons;
    private static ArrayList<PigeonRun> pigeonRuns;
    private static ArrayList<PigeonEat> pigeonEats;
    private static ArrayList<PigeonThreatened> pigeonThreatened;

    private static ArrayList<Food> food = null;

    public Game() {
        // Initialise les tableaux
        pigeons = new ArrayList<>();
        pigeonRuns = new ArrayList<>();
        pigeonEats = new ArrayList<>();
        pigeonThreatened = new ArrayList<>();
        food = new ArrayList<>();
    }

    /**
     * Récupérer les pigeons
     * @return
     */
    public ArrayList<Pigeon> getPigeons() {
        return pigeons;
    }

    /**
     * Récupérer la nourriture
     * @return
     */
    public ArrayList<Food> getFood() {
        return food;
    }

    /**
     * Récupérer la nourriture fraîche
     * @return
     */
    public synchronized static Food getFreshFood() {
        return food.size() > 0 && food.get(food.size() - 1).isFresh() ? food.get(food.size() - 1) : null;
    }

    /**
     * Ajouter une nourriture à la position en paramètre
     * @param x
     * @param y
     */
    public void addFood(int x, int y) {
        food.add(new Food(x, y));
    }

    /**
     * Ajouter un pigeon et ses actions à la position en paramètre
     * @param x
     * @param y
     */
    public void addPigeon(int x, int y) {
        Pigeon p = new Pigeon(x, y);

        // Ajoute le pigeon et ses actions
        pigeons.add(p);
        pigeonRuns.add(new PigeonRun(p));
        pigeonEats.add(new PigeonEat(p));
        pigeonThreatened.add(new PigeonThreatened(p));
    }

    /**
     * Manger de la nourriture
     * @param freshFood
     */
    public synchronized static void eatFood(Food freshFood) {
        // Réinitialisation du timer de peur des pigeons
        for (PigeonThreatened pt : pigeonThreatened)
            pt.setThreatenedTimer();

        // Termine le timer de la nourriture
        freshFood.lifeTimer.cancel();
        // Supprime la nourriture du jeu
        removeFood(freshFood);
    }

    /**
     * Supprime la nourriture en paramètre
     * @param f
     */
    public synchronized static void removeFood(Food f) {
        if (f != null)
            food.remove(f);
    }

    /**
     * Réinitialise le jeu à son état d'origine
     */
    public synchronized void resetWorld() {
        // Termine tous les threads des pigeons (courir, manger et peur)
        for (int i = 0; i < pigeons.size(); i++) {
            pigeonRuns.get(i).interruptAction();
            pigeonEats.get(i).interruptAction();
            pigeonThreatened.get(i).interruptAction();
        }

        // Nettoie les tableaux
        pigeons.clear();
        pigeonRuns.clear();
        pigeonEats.clear();
        pigeonThreatened.clear();

        food.clear();
    }
}
