package Day1;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day1 {
    
    public static void main(String[] args) throws IOException{
        
        byte[] raw = Files.readAllBytes(Path.of(Day1.class.getResource("Day1Input.txt").getPath()));
        int result = countTurns(new String(raw, StandardCharsets.UTF_8));
        // ("L68\n" + //
        //                 "L30\n" + //
        //                 "R48\n" + //
        //                 "L5\n" + //
        //                 "R60\n" + //
        //                 "L55\n" + //
        //                 "L1\n" + //
        //                 "L99\n" + //
        //                 "R14\n" + //
        //                 "L82");
        
        System.out.println(result);
    }

    static int countTurns(String input){
        int initial = 50;
        int total = 100;

        String [] splits = input.split("\n");
        int zeroCount = 0;
        int current = 0;

        for(int i = 0; i < splits.length ; i ++){
            String s = splits[i];
            char turn = s.charAt(0);
            int turns = Integer.valueOf(s.substring(1).trim());
            System.out.println("turns : "+s);
            if (i == 0){
                if(turn == 'L'){
                    current = ((initial - turns) + total) % 100;
                    System.out.println("1st L's current "+current);
                    if (current == 0) zeroCount +=1;
                } else {
                    current = ((initial + turns) + total) % 100;
                    System.out.println("1st R's current "+current);
                    if (current == 0) zeroCount +=1;
                }
                continue;
            }
            if(turn == 'L'){
                current = ((current - turns) + total) % 100;
                System.out.println("L's current "+current);
                if (current == 0) zeroCount +=1;
            } else {
                current = ((current + turns)) % 100;
                System.out.println("R's current "+current);
                if (current == 0){ zeroCount +=1;}
            }
        }
        return zeroCount;
    }
}
