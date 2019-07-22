package com.javarush.task.task21.task2113;
/*
Сегодня мы напишем небольшую игру под названием "Ипподром".
Когда я говорю мы - я имею ввиду тебя. Я же буду работать наставником.
 */

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public static void main(String[] args) {
        Hippodrome.game = new Hippodrome(new ArrayList<>( ));

        Horse horse1 = new Horse("Loshadka", 3, 0);
        Horse horse2 = new Horse("Loko", 3, 0);
        Horse horse3 = new Horse("DeadLock", 3, 0);

        game.getHorses( ).add(horse1);
        game.getHorses( ).add(horse2);
        game.getHorses( ).add(horse3);

        game.run( );
        game.printWinner( );
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move( );
            print( );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }

        }

    }

    public void move() {
        for (Horse horse : horses) {
            horse.move( );
        }

    }

    public void print() {
        for (Horse horse : horses) {
            horse.print( );
        }
        for (int i = 0; i < 5; i++) {
            System.out.println( );
        }
    }

    public Horse getWinner() {
        double maxDistance = 0;
        Horse horseWinner = null;
        for (Horse horse : horses) {
            if (horse.getDistance( ) > maxDistance) {
                maxDistance = horse.getDistance( );
                horseWinner = horse;
            }
        }
        return horseWinner;

    }

    public void printWinner() {
        Horse horseWinner = getWinner( );
        System.out.println("Winner is " + horseWinner.getName( ) + "!");

    }


}


package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void setName(String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return this.distance;
    }
    public void move() {
        distance += speed * Math.random();
    }
    public void print() {
        for (int i = 0; i < Math.floor(distance); i++) {
            System.out.print(".");
        }
        System.out.println(this.name);
    }

}
