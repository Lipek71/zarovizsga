package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {
    public String minWork(String file) {
        String minWorkerDay;
        Path filePath = Path.of(file);
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(filePath))) {
            String line = br.readLine();
            System.out.println(line);
            minWorkerDay = line.split(",")[0] + ": " + line.split(",")[2];
            int minHours = Integer.parseInt(line.split(",")[1]);
            System.out.println(minHours + ";" + minWorkerDay);
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if(Integer.parseInt(line.split(",")[1]) < minHours){
                    minWorkerDay = line.split(",")[0] + ": " + line.split(",")[2];
                    minHours = Integer.parseInt(line.split(",")[1]);
                    System.out.println(minHours + ";" + minWorkerDay);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't open the file!", ioe);
        }
        System.out.println(minWorkerDay);
        return minWorkerDay;
    }
}
