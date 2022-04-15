package problemsolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        LinkedList<Integer> ranks = new LinkedList<>();
        int j = 0;
        int rank = 1;
        for(int i = player.size()-1; i >= 0; i--){
            for(; j < ranked.size(); j++){
                if( player.get(i) >= ranked.get(j) ){
                    ranks.addFirst(rank); break;
                }
//                else if( player.get(i) == ranked.get(j) ){
//                    ranks.addFirst(rank); break;
//                }
                else if( j < ranked.size()-1 && ranked.get(j+1) < ranked.get(j)) rank++;
            }
            if( j == ranked.size() ) ranks.addFirst(rank+1);
        }
        return ranks;
    }


}

public class ClimbingLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        System.out.println(result);

        bufferedReader.close();
    }
}

