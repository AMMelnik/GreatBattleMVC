package mvc.model;

/**
 * Created by pc on 19.01.2017. Changed on 20.01.17
 */
class WarriorsFactory {

    Warrior createWarrior(String name, int type) {
        Warrior warrior = null;

        switch (type) {
            case 0:
                warrior = new Scout(name, 80, 60);
                break;
            case 1:
                warrior = new Fighter(name, 50, 150);
                break;
            case 2:
                warrior = new Bomber(name, 100, 50);
                break;
        }
        return warrior;
    }

}

