package mvc.model;

import mvc.controller.WarriorsController;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by pc on 11.12.2016. Changed on 20.01.17
 */
public class Battle extends Observable {

    private WarriorsFactory factory = new WarriorsFactory();
    private Squad squad1 = new Squad(factory);
    private Squad squad2 = new Squad(factory);
    private StringBuilder battleInfo = new StringBuilder();
    private boolean isBattleEnd = false;
    private Warrior warrior1 = null;
    private Warrior warrior2 = null;
    List<Observer> observers = new ArrayList();

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

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void createSquads(String name1, String name2) {
        squad1.setSquadName(name1);
        squad2.setSquadName(name2);
    }

    public int getSquadSize(int squadNum) {
        if (squadNum == 1) {
            return squad1.getSize();
        } else return squad2.getSize();
    }

    public String getFirstSquadName() {
        return squad1.getSquadName();
    }

    public String getSecondSquadName() {
        return squad2.getSquadName();
    }

    public void addWarriorToSquad(int squadNum, String name, int type) {
        if (squadNum == 1) {
            squad1.addToSquad(name, type);
            updateObservers("New warrior added to Squad 1");
        } else {
            squad2.addToSquad(name, type);
            updateObservers("New warrior added to Squad 2");
        }
    }

    private void updateObservers(String name) {
        for (Observer observer : this.observers) {
            observer.update(this, name);
        }
    }

  /* (если нельзя использовать свои произвольные event для Наблюдателя, то можно ли этот метод?)
    public boolean check(int squadNum, String name) {
        if (squadNum == 1) {
            return squad1.getWarrior(name);
        } else return squad2.getWarrior(name);
    }*/

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

    public void needInfo() {
        updateObservers("The Great Battle is finished");
    }
}
