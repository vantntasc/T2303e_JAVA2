package org.aptech.t2303e.file;

import org.aptech.t2303e.lombok.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.ServerError;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileLab {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String header = "ID|Name|Address|BirthDay";
    public static void main(String[] args) {
        readFile();
    }
    public static void lab1(){
//        File file = new File("F:/aptech/t2303e/T2303e-java2/etc/Demo1.txt");  // absolute path
        File file = new File("./etc/Demo.txt"); // relative path
        System.err.println("File exists : "+ file.exists());
        if(file.isFile()){
            // có phải 1 thư mục hay ko
            System.err.println("is Directory : "+ file.isDirectory());
            // thư mục hay file ẩn
            System.err.println("is Hiden : "+ file.isHidden());
            // check size
            System.err.println("size : "+ file.length()); // bytes
            // last edit
            System.err.println("lasModified : "+ new Date(file.lastModified()));
        }
    }

    public static void lab2(){
//        File etcDir = new File("./etc");
//        System.err.println("Folder exists :" + etcDir.exists()
//                            + " ,absolute path  : " + etcDir.getAbsolutePath()
//                    + " ,parent folder : "+ etcDir.getParentFile().getAbsolutePath()
//        );
        // Tạp folder :
        File f = new File("./etc/demo");
//        boolean createdFile  = f.mkdirs();
//        System.err.println("Created file success ? :  "+ createdFile);
        f.delete();
    }

    public  static void readFile(){
        List<Student> students = new ArrayList<>();
        String url = "./etc/Demo.txt";
        // read data from file with Scanner
        FileInputStream inputStream = null;
        Scanner scanner = null;
        try {
            inputStream = new FileInputStream(url);
            scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line  = scanner.nextLine();
                Student s = Student.convert(dateFormat,header,line);
                if(!Objects.isNull(s)){
                    students.add(s);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found"+e.getMessage());
        } catch (ParseException e) {
            System.err.println("Parse student error :"+e.getMessage());
        } finally {
            scanner.close();
            try {
                inputStream.close();
            } catch (IOException e) {
                System.err.println("IOE exception"+e.getMessage());
            }
        }
        students.forEach(System.err::println);
    }

}
