package mvc.model;

/**
 * Created by pc on 11.12.2016. Changed on 20.01.17
 */
public class Battle {

    private Squad squad1 = new Squad();
    private Squad squad2 = new Squad();
    private StringBuilder battleInfo = new StringBuilder();
    private boolean isBattleEnd = false;
    private Warrior warrior1 = null;
    private Warrior warrior2 = null;

    private static final Battle instance = new Battle();

    private Battle() {
    }

    public static Battle getInstance() {
        return instance;//непонятно, зачем вы вообще решили сделать битву одиночкой.
        // из-за неуместного использования одиночку иногда даже называют антипаттерном.
        /*Ответ
        я несколько вечеров провел, пытаясь добиться работы, перекидывая экземпляры Battle из метода в метод, из класса в класс,
        и все равно не получалось сделать то, что хочу. Просмотрев ваш пример с паттернами, и найдя Синглтон, почитав о нем, мне удалось
        решить проблему буквально за 2 минуты. Я посчитал, что на правильном пути. Теперь я в замешательстве. Неужели это настолько
        плохо для применения в таком проекте?
        */
    }

    public void createSquads(String name1, String name2) {
        squad1.setSquadName(name1);
        squad2.setSquadName(name2);
    }

    public String getFirstSquadName() {
        return squad1.getSquadName();
    }

    public String getSecondSquadName() {
        return squad2.getSquadName();
    }

    public void addWarriorToSquad1(String name, int type) {
        squad1.addToSquad(name, type);
    }

    public void addWarriorToSquad2(String name, int type) {
        squad2.addToSquad(name, type);
    }

    public void startBattle() {
        squad1.setSquadNameForWarriors();
        squad2.setSquadNameForWarriors();
        DateHelper dateHelper = new DateHelper();
        // пока есть живые в обоих отрядах
        while (!isBattleEnd) {
            //выбор бойцов для первого раунда
            warrior1 = squad1.getRandomWarrior();
            warrior2 = squad2.getRandomWarrior();
            // описание раунда
            prepareToShowBattleInfo(showRoundAd(warrior1, warrior2));
            // удар и потеря здоровья
            warrior2.takeDamage(warrior1.attack());
            prepareToShowBattleInfo(squad2.needHimDeleteFromSquad(warrior2));
            // пропускаем время раунда 20мин
            dateHelper.skipTime();
            // если есть живые в первом и нет живых во втором
            if (showResults(squad1, squad2)) {
                continue;
            }
            //выбор бойцов для второго раунда
            warrior1 = squad1.getRandomWarrior();
            warrior2 = squad2.getRandomWarrior();
            prepareToShowBattleInfo(showRoundAd(warrior2, warrior1));
            warrior1.takeDamage(warrior2.attack());
            prepareToShowBattleInfo(squad1.needHimDeleteFromSquad(warrior1));
            dateHelper.skipTime();
            showResults(squad2, squad1);
        }
        // выводим текущую дату-время -1500 лет
        prepareToShowBattleInfo("\n" + dateHelper.getFormattedStartDate() + "\n");
        // вывести время сражения
        prepareToShowBattleInfo(dateHelper.getFormattedDiff());
    }

    private boolean showResults(Squad attacksSquad, Squad attackedSquad) {
        if (!attackedSquad.hasAliveWarriors()) {
            String squadDown = "Отряд " + attackedSquad.getSquadName() +
                    " полностью разбит!!!\nПобеду одержал отряд " + attacksSquad.getSquadName() + " ! УРА!!!\n";
            prepareToShowBattleInfo(squadDown);
            return isBattleEnd = true;
        }
        return false;
    }

    private void prepareToShowBattleInfo(String newInfo) {
        battleInfo.append(newInfo);
    }

    public String showBattleInfo() {
        return battleInfo.toString();
    }

    public String showSquad(int squad) {
        if (squad == 1) {
            return squad1.toString();
        } else return squad2.toString();
    }

    private String showRoundAd(Warrior attacksWarrior, Warrior attackedWarrior) {
        return "\n  =*=*=*=*=*=*=*=*=*=*=*=*=*=*=\n       На бой вызываются: \n" + attacksWarrior.toString() + ", " +
                attacksWarrior.getSquadName() + "\nи " + attackedWarrior.toString() + ", " + attackedWarrior.getSquadName() +
                "\nАтакует боец " + attacksWarrior.getNameOnly() + "\nБоец " + attackedWarrior.getNameOnly() + "  принимает удар!\n";
    }
}
