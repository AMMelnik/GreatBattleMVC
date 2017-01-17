package mvc.model;

/**
 * Created by pc on 11.12.2016.
 */
class Fighter extends ModernWarrior {

    Fighter(String warriorName, String classType, int warriorDamage, int warriorHealth) {
        super(warriorName, classType, warriorDamage, warriorHealth);
    }

    @Override
    public String getClassType() {
        return " Класс Борец";
    }

    @Override
    public String toString() {
        return super.getNameOnly() + "." + getClassType();
    }

    @Override
    public Fighter clone() throws CloneNotSupportedException {
        return (Fighter) super.clone();
    }
}
