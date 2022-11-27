import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class test4 {
    public static void work(File A, File TO) {
        TO.mkdir();
        File[] files = A.listFiles();
        for(File file : files) {
            if(file.isDirectory()) {
                work(file, new File (TO.getPath(), file.getName()));
            } else {
                try {
                    Files.copy(file.toPath(), (new File (TO.getPath(), file.getName())).toPath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        File OddDir = new File("C:\\Users\\Moniq\\Desktop\\coding");
        File NewDir = new File("C:\\Users\\Moniq\\Desktop\\a");
        NewDir = new File (NewDir.getPath(), OddDir.getName());
        work(OddDir, NewDir);
    }
}
