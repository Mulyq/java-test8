import java.io.File;
import java.util.Scanner;
public class test3 {
    public static boolean work(File dir) {
        boolean res = false;
        File[] files = dir.listFiles();
        for(File file : files) {
            if(file.isDirectory()) {
                work(file);
            } else {
                String FileName = file.getName();
                if(FileName.endsWith(".jpg") || FileName.endsWith(".java")) {
                    System.out.println("文件所在路径："+file.getAbsolutePath());
                    res = true;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\Moniq\\Desktop\\test");
        if(work(dir) == false) {
            System.out.println("目录下没有所要找的文件");
        }
    }
}
