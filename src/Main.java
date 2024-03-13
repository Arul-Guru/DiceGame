import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] dice1 = {1,2,3,4,5,6};
        int[] dice2 = {1,2,3,4,5,6};
        List<ArrayList<Integer>> outcomes = getOutcomes(dice1,dice2);
        for(int i = 0; i<outcomes.size();i++){
            for(int j =0; j < outcomes.get(i).size();j++){
                System.out.print(outcomes.get(i).get(j)+", ");
            }
            System.out.println();
        }

        startGame(dice1,dice2,  outcomes);

    }

    public static void startGame(int[] dice1, int[] dice2, List<ArrayList<Integer>> outcomes){
        Scanner scanner = new Scanner(System.in);
        float player1 = 0;
        float player2 = 0;
        while(true){
            System.out.println("Ready.. Player One? y/n");
            String input =scanner.nextLine().toLowerCase();
            String input2;

            if(input.equals("y")) {
                player1 = getProbality(outcomes,dice1,dice2);
                if(player1 > 0 && player2 > 0){
                    declareResults(player1, player2);
                    player1 = 0;
                    player2 = 0;
                }
            } else {
                System.out.println("Ready.. Player Two? y/n");
                input2 = scanner.nextLine().toLowerCase();
                if(input2.equals("y")){
                    player2 = getProbality( outcomes,dice1,dice2);
                    if(player1 > 0 && player2 > 0){
                        declareResults(player1, player2);
                        player1 = 0;
                        player2 = 0;
                    }
                }
                continue;
            }

            System.out.println("Ready.. Player Two? y/n");//n
            input2 = scanner.nextLine().toLowerCase();
            if(input2.equals("y")){
                player2 = getProbality(outcomes,dice1,dice2);
                if(player1 > 0 && player2 > 0){
                    declareResults(player1,player2);
                    player1 = 0;
                    player2 = 0;
                }
            }else {
                System.out.println("Ready.. Player Two? y/n");
                 String input1 = scanner.nextLine().toLowerCase();
                if(input1.equals("y")){
                    player1 = getProbality( outcomes,dice1,dice2);
                    if(player1 > 0 && player2 > 0){
                        declareResults(player1, player2);
                        player1 = 0;
                        player2 = 0;
                    }
                }
            }


        }
    }

    public static void declareResults(float player1, float player2){
        if(player1 > player2){
            System.out.println("Player 2 Won!!!");
        }else {
            System.out.println("Player 1 Won!!!");
        }
    }

    public static List<ArrayList<Integer>>  getOutcomes(int[] dice1,int[] dice2 ){
        List<ArrayList<Integer>> outcomes = new ArrayList<>();
        for(int i=0; i < dice1.length; i++){

            for(int j = 0; j < dice2.length; j++){
                ArrayList<Integer> arr = new ArrayList<>();
               arr.add(dice1[i]);
               arr.add(dice2[j]);
               outcomes.add(arr);
            }

        }
        return outcomes;
    }

    public static float getProbality(List<ArrayList<Integer>> outcomes,int[] dice1, int[] dice2){
        Random r = new Random();
        int x = r.nextInt(dice1.length);
        int y = r.nextInt(dice2.length);
        System.out.printf("%d,%d \n",dice1[x],dice2[y]);
        int value = dice1[x] + dice2[y];
        int no_of_favourables = 0;
        for (int i = 0; i < outcomes.size(); i++){
                if(outcomes.get(i).get(0)+outcomes.get(i).get(1) == value) {
                    no_of_favourables++;
                }
        }

        return (float) no_of_favourables/outcomes.size();
    }
}