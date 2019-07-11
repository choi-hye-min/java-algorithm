package etc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://seolhun.github.io/Java-Elevators/
 * 목표는 엘리베이터가 멈추는 총 횟수를 세는 것입니다.
 */
public class ElevatorTest {
    public static void main(String[] args) {
        ElevatorTest elevatorTest = new ElevatorTest();

        int[] peopleWeight = {40, 40, 100, 80, 20}; // 사람몸무게
        int[] destnation = {3, 3, 2, 2, 3}; // 목적층수
        int maxFloor = 3; // 총층수
        int capacity = 5; // 수용공간
        int weightLimit = 200; // 몸무게제한

        int stop = elevatorTest.stop(peopleWeight, destnation, maxFloor, capacity, weightLimit);
        System.out.println("STOP : " + stop);
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

    public int stop(int[] peopleWeight, int[] destnation, int maxFloor, int maxCapacity, int weightLimit) {
        int stopCnt = 0;

        Queue<Person> queue = new LinkedList<>();
        initPersonSetting(peopleWeight, destnation, queue);

        while (!queue.isEmpty()) {
            Set<Integer> targetFloor = new HashSet<>();
            int currentWeight = 0; // 현재 총 몸무게
            int currentCapacity = 0; // 현재 사람수

            while (maxCapacity > currentCapacity) {
                Person person = queue.peek();
                if (queue.isEmpty() || weightLimit < person.getWeight() + currentWeight) break;

                currentWeight += person.getWeight();
                currentCapacity++;

                targetFloor.add(person.getFloor());
                queue.remove();
            }

            stopCnt += targetFloor.size() + 1;
        }

        return stopCnt;
    }

    private void initPersonSetting(int[] peopleWeight, int[] destnation, Queue<Person> queue) {
        for (int i = 0; i < peopleWeight.length; i++) {
            queue.add(new Person(peopleWeight[i], destnation[i]));
        }
    }
}
