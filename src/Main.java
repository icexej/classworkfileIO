import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        File empFile = new File("/Users/iceej/IdeaProjects/claasssss/src/emp.txt");
        File sortedFile = new File("/Users/iceej/IdeaProjects/claasssss/src/sorted emp. txt");

        Map<Integer, Employee> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(empFile));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double salary = Double.parseDouble(parts[2]);
                Department dept = Department.valueOf(parts[3]);

                Employee emps = new Employee(id, name, salary, dept);
                map.put(id, emps);

                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("File is not find");
        } catch (NumberFormatException e) {
            System.out.println("File isn wrong");
        }


        List<Employee> list = new ArrayList<>(map.values());
        Collections.sort(list);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("sortedFile"));
            for (Employee emps : list) {
                bw.write(emps.toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("Ready");
        } catch (IOException e) {
            System.out.println("Can't to fill the file");
        }
    }
}