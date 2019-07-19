package etc;

/**
 * 보트가 사람들을 실어나르는 총 왕복횟수
 *
 * [70,50,80,50] w=100 stop=3 (70)(80)(50,50)
 * [70,80,50] w=100 stop=3
 *
 * not collection
 */
public class BoatMaxStop {
    public static void main(String[] args) {
        BoatMaxStop boatMaxStop = new BoatMaxStop();
//        boatMaxStop.solution(new int[]{70, 50, 80, 50}, 100);
//        boatMaxStop.solution(new int[]{70, 90,10,50}, 100);
        boatMaxStop.solution(new int[]{70, 240, 45, 90,10,50}, 240);
    }

    private int solution(int[] person, int limitWeight) {
        int stop = 0;
        int personSize = person.length;
        int loopCount = 0;
        while(personSize != 0){
            int currentWeight = 0;

            for (int i = 0; i < person.length; i++) {
                loopCount++;
                if(person[i] == 0){
                    continue;
                }

                if(limitWeight < (person[i] + currentWeight)){
                    continue;
                }

                System.out.println("POP : "+person[i]);
                currentWeight += person[i];
                person[i] = 0;
                personSize--;
            }

            if(currentWeight > 0){
                stop++;
                System.out.println("--------------");
            }
        }

        System.out.println("Total Stop : "+stop);
        return stop;
    }
}
