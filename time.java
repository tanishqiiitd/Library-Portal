package assignment1;
import java.util.*;
import java.time.LocalTime;

public class time {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        LocalTime currentTime = LocalTime.now();
        int minutes = currentTime.getMinute();
        int second = currentTime.getSecond();
        int timeinseconds = minutes*60 + second;

        System.out.println("Time is: "+timeinseconds);
    
}

}