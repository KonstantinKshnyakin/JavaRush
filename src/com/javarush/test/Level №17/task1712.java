package com.javarush.task.task17.task1712;

import java.util.ArrayList;
import java.util.List;

/* 
Ресторан
1.Разберись, что делает программа. Официант почему-то не относит приготовленные блюда назад к столам :(

2.Исправь ошибку.

Подсказка: это одна строчка

Требования:
•	Класс Restaurant должен содержать список поваров и официантов (public static поле threads типа List<Thread>).
•	Класс Manager должен содержать очередь с заказами (private final поле orderQueue типа Queue<Order>).
•	Класс Manager должен содержать очередь с готовыми блюдами (private final поле dishesQueue типа Queue<Dishes>).
•	Класс Manager должен реализовывать паттерн Singleton.
•	Класс Waiter должен реализовывать интерфейс Runnable.
•	Класс Cook должен реализовывать интерфейс Runnable.
•	Если нет готовых блюд в очереди, нить класса Waiter должна получать заказ от столика и добавлять его в очередь заказов.
•	Если есть готовые блюда в очереди, нить класса Waiter должна брать блюдо из очереди и относить заказ для столика.
•	Если нет заказов в очереди с заказами, нить класса Cook должна отдыхать (повар отдыхает).
•	Если есть заказы в очереди с заказами, нить класса Cook должна готовить блюдо и добавлять его в очередь с готовыми блюдами.
*/

public class Restaurant {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter();
        Thread waiter = new Thread(waiterTarget);
        threads.add(waiter);

        Cook cookTarget = new Cook();
        Thread cook = new Thread(cookTarget);
        threads.add(cook);

        waiter.start();
        cook.start();

        Thread.sleep(2000);
        cookTarget.continueWorking = false;
        Thread.sleep(500);
        waiterTarget.continueWorking = false;
    }
}


package com.javarush.task.task17.task1712;

public class Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cook();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cook() throws InterruptedException {
        Manager manager = Manager.getInstance();
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
        Thread.sleep(order.getTime());     // готовим блюдо
        Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо
        manager.getDishesQueue().add(dishes);
        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));
    }
}

package com.javarush.task.task17.task1712;

public class Order {
    private long time;
    private byte tableNumber;

    public Order(byte tableNumber) {
        time = (long) (Math.random() * 200);
        this.tableNumber = tableNumber;
    }

    public long getTime() {
        return time;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}


package com.javarush.task.task17.task1712;

public class Table {
    private static byte tableNumber;
    private byte number = ++tableNumber;

    public Order getOrder () {
        return new Order(number);
    }
}


package com.javarush.task.task17.task1712;

public class Dishes {
    private byte tableNumber;

    public Dishes(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}
