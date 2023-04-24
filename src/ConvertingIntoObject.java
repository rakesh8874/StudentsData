import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertingIntoObject {
    public static int countRecords(String fileName){
        int count = 0;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line=bufferedReader.readLine())!=null){
                count++;
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        return count;
        }
        public Student[] readRecords(String fileName, int count){
        int countLines = 0;
        Student []myData = new Student[count];
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                myData[countLines] = new Student(data[0],Integer.parseInt(data[1]),data[2],
                        Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]));
                countLines++;
            }
            }catch(FileNotFoundException e){
            System.out.println(e);
        }
        catch(IOException e){
                System.out.println(e);
            }
        return myData;
        }
     List addRecord(Student [] student){
        List <Student>  list = new ArrayList<>();
        for(Student stu:student){
            list.add(stu);
        }
        return list;
     }
     boolean checkName(List<Student> list, String name){
        int found  = 0;
        for(Student stu:list){
            if(name.equalsIgnoreCase(stu.getName())){
                if(stu.getName().startsWith("S"))
                    System.out.println(stu);
                found = 1;
                System.out.println(stu);
                break;
            }
        }
        if(found==1)
            return true;
            else
                return false;
    }

    public static void main(String[] args) {
        ConvertingIntoObject convertingIntoObject = new ConvertingIntoObject();
        int count = countRecords("d:\\JavaProgrammingWithIntelliJ\\StudentsData.txt");
        Student []studentsData = convertingIntoObject.readRecords("d:\\JavaProgrammingWithIntelliJ\\StudentsData.txt", count);
//        for(int i = 0; i<studentsData.length; i++){
//            System.out.println(studentsData[i]);
//        }

        List <Student>list = new ArrayList<>();
        list = convertingIntoObject.addRecord(studentsData);
        System.out.println(list.get(1));
        boolean found = convertingIntoObject.checkName(list,"Jack");
        System.out.println(found);
    }

}
