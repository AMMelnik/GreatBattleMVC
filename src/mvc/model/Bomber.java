package mvc.model;

/**
 * Created by pc on 11.12.2016.
 */
class Bomber extends ModernWarrior {

    Bomber(String warriorName, String classType, int warriorDamage, int warriorHealth) {
        super(warriorName, classType, warriorDamage, warriorHealth);
    }

    @Override
    public String getClassType() {
        return " Класс Подрывник";
    }

    @Override
    public String toString() {
        return super.getNameOnly() + "." + getClassType(); //метод одинаковый у всех бойцов - вынести в ModernWarrior
    }

    @Override
    public Bomber clone() throws CloneNotSupportedException {
        return (Bomber) super.clone();
    }
}
