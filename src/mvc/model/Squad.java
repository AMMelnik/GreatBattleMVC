package mvc.model;

import java.util.ArrayList;

/**
 * Created by pc on 11.12.2016.
 */
class Squad {

    private String squadName;
    private ArrayList<Warrior> squad = new ArrayList<>();
    private WarriorsFactory factory;

    Squad(WarriorsFactory factory) {
        this.factory = factory;
    }

    void setSquadName(String name) {
        squadName = name;
    }

    String getSquadName() {
        return squadName;
    }

    // добавление бойцов в отряд
    void addToSquad(String name, int type) {
        Warrior warrior;
        warrior = factory.createWarrior(name, type);
        squad.add(warrior);
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
        StringBuilder warriors = new StringBuilder("Состав отряда:\n");
        for (int i = 0; i < squad.size(); i++) {
            warriors.append(squad.get(i).toString() + "\n");
        }
        return warriors.toString();
    }
}
