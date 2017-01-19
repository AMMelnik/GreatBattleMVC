package mvc.model;

/**
 * Created by pc on 11.12.2016.
 */
class Fighter extends ModernWarrior {

    Fighter(String warriorName, int warriorDamage, int warriorHealth) {
        super(warriorName, warriorDamage, warriorHealth);
    }

    @Override
    public String getClassType() {
        return " Класс Борец";
    }

    @Override
    public Fighter clone() throws CloneNotSupportedException {
        return (Fighter) super.clone();
    }
}
