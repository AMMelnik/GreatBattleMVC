package mvc.model;

import java.util.ArrayList;

/**
 * Created by pc on 11.12.2016.
 */
class Squad {

    private String squadName;
    private ArrayList<Warrior> squad = new ArrayList<>();

    void setSquadName(String name) {
        squadName = name;
    }

    String getSquadName() {
        return squadName;
    }

    // добавление бойцов в отряд
    void addToSquad(String name, int type) {
        switch (type) {
            case 0:
                squad.add(new Scout(name, "Разведчик", 80, 60));
                break;
            case 1:
                squad.add(new Fighter(name, "Борец", 50, 150));
                break;
            case 2:
                squad.add(new Bomber(name, "Подрывник", 100, 50));
                break;
        }
    }

    void setSquadNameForWarriors() {
        for (Warrior warrior : squad) {
            warrior.setSquadName(squadName);
        }
    }

    Warrior getRandomWarrior() {
        int randomWarrior = (int) (Math.random() * (squad.size()));
        return squad.get(randomWarrior);
    }

    boolean hasAliveWarriors() {
        return !squad.isEmpty();
    }

    String needHimDeleteFromSquad(Warrior warrior) {
        if (!warrior.isAlive()) {
            squad.remove(warrior);
            return "Боец пал смертью храбрых!\n";
        } else {
            return "Его здоровье равно " + warrior.getHealth() + "\n";
        }
    }

    @Override
    public String toString() {
        String warriors = "Состав отряда:\n";
        for (int i = 0; i < squad.size(); i++){
            warriors += squad.get(i).toString() + "\n";
        }
        return warriors;
    }
}
