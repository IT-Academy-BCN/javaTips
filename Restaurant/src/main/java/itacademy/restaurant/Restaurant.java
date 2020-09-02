package itacademy.restaurant;
import java.util.concurrent.*;

/**
 * Un Restaurante tiene un cocinero y un camarero. El camarero tiene que esperar a que el cocinero prepare un plato.
 * cuando el cocinero tiene un plato preparado, se lo notifica al camarero, que toma el plato y lo entrega al cliente y
 * vuelve a quedar en espera. Éste es un ejemplo de cooperación entre tareas: el cocinero representa al productor y el
 * camarero representa al consumidor. Ambas tareas deben negociar a medida que se producen y consumen los platos y el
 * sistema tiene que ser capaz de terminar de una manera ordenada.
 *
 */

//Técnica productor-consumidor para cooperación entre tareas
class Meal {

    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null)
                        wait(); // ... para que el cocinero prepare un plato
                }
                System.out.println("Waitperson got " + restaurant.meal);

                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Listo para otro
                }
            }
        } catch(InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable {

    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
        restaurant = r;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal != null)
                        wait(); // ... para que se lleven el plato
                }
                if(++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                synchronized(restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}

public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}


