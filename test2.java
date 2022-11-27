import java.io.File;
import java.util.Scanner;
public class test2 {
    public static void work(File dir, String FindFile) {
        File[] files = dir.listFiles();
        for(File file : files) {
            if(file.isDirectory()) {
                work(file, FindFile);
            } else {
                if(file.getName().equals(FindFile)) {
                    System.out.println("目录下要找的文件所在路径" + file.getAbsolutePath());
                    System.exit(0);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想要查找的文件名：");
        String FindFile = sc.next();

        File dir = new File("C:\\MinGW");
        work(dir, FindFile);
        System.out.println("目录下没有所要找的文件");
    }
}
