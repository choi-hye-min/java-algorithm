package etc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://seolhun.github.io/Java-Elevators/
 * 목표는 엘리베이터가 멈추는 총 횟수를 세는 것입니다.
 */
public class Elevator_test {
    public static void main(String[] args) {
        Elevator_test elevatorTest = new Elevator_test();

        int[] peopleWeight = {40, 40, 100, 80, 20}; // 사람몸무게
        int[] destnation = {3, 3, 2, 2, 3}; // 목적층수
        int maxFloor = 3; // 총층수
        int capacity = 5; // 수용공간
        int weightLimit = 200; // 몸무게제한

        int stop = elevatorTest.solution(peopleWeight, destnation, maxFloor, capacity, weightLimit);
        System.out.println(stop);
    }

    class Person {
        private int weight;
        private int floor;

        public Person(int weight, int floor) {
            this.weight = weight;
            this.floor = floor;
        }

        public int getWeight() {
            return weight;
        }

        public int getFloor() {
            return floor;
        }
    }

    private int solution(int[] peopleWeight, int[] destnation, int maxFloor, int capacityLimit, int weightLimit) {
        Queue<Person> personQueue = new LinkedList<>();
        for (int i = 0; i < peopleWeight.length; i++) {
            personQueue.add(new Person(peopleWeight[i], destnation[i]));
        }

        int stop = 0;
        while (!personQueue.isEmpty()) {
            int totalWeight = 0;
            int totalCapacity = 0;
            Set<Integer> targetFloor = new HashSet<>();

            while (capacityLimit > totalCapacity) {
                Person person = personQueue.peek();

                if (personQueue.isEmpty() || weightLimit < person.weight + totalWeight) break;

                totalWeight += person.weight;
                totalCapacity++;
                targetFloor.add(person.getFloor());

                personQueue.remove();
            }

            stop += targetFloor.size() + 1;
        }

        return stop;
    }
}
