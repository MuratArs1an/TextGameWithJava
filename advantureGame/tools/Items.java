package advantureGame.tools;

public class Items {
    private boolean food;
    private boolean water;
    private boolean firewood;

    public Items(boolean food, boolean water, boolean firewood) {
        this.food = food;
        this.water = water;
        this.firewood = firewood;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
}
