import java.util.Arrays;

class Main {
    public static void main(String[] args) {

    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int i = 0; i < asteroids.length; i++) {
            if(mass>=100000) return true;
            else if (mass >= asteroids[i]) mass += asteroids[i];
            else return false;
        }
        return true;
    }
}