package Day1;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day1 {
    
    public static void main(String[] args) throws IOException{
        
        byte[] raw = Files.readAllBytes(Path.of(Day1.class.getResource("Day1Input.txt").getPath()));
        //int result = countTurns(new String(raw, StandardCharsets.UTF_8));
        int result = countTurns("L68\n" + // - 18 | - 1 rotation over 0
                        "L30\n" + // -48
                        "R48\n" + // 0
                        "L5\n" + // -95
                        "R60\n" + // 55 | 1 rotation over 0
                        "L55\n" + // 0
                        "L1\n" + // 99
                        "L99\n" + // 0
                        "R14\n" + // 14
                        "L82"); // 62 | 1 rotation
        
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
            if (i == 0){
                if(turn == 'L'){
                    current = ((initial - turns) + total) % 100;
                    zeroCount += (((turns))) / 50;
                    if (current == 0) {
                        zeroCount +=1;
                    };
                } else {
                    current = ((initial + turns) + total) % 100;
                    zeroCount += (((turns))) / 50;
                    if (current == 0) {
                        zeroCount +=1;
                    }
                }
                System.out.println(s+" first turn rotated times : "+zeroCount);
                continue;
            }
            if(turn == 'L'){
                current = ((current - turns) + total) % 100;
                zeroCount += (Math.abs((current - turns))) / 50;
                if (current == 0) {
                    zeroCount +=1;
                }
            } else {
                current = ((current + turns)) % 100;
                zeroCount += (Math.abs((current - turns))) / 50;
                if (current == 0){
                    zeroCount +=1;
                }
            }
            System.out.println(s+" rotated times : "+zeroCount);
        }
        return zeroCount;
    }
}
