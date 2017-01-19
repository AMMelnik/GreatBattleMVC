package mvc.model;

/**
 * Created by pc on 11.12.2016.
 */
class Scout extends ModernWarrior {

    Scout(String warriorName, String classType, int warriorDamage, int warriorHealth) {
        super(warriorName, classType, warriorDamage, warriorHealth);
    }

    @Override
    public String getClassType() {
        return " Класс Разведчик";
    }

    @Override
    public Scout clone() throws CloneNotSupportedException {
        return (Scout) super.clone();
    }
}
