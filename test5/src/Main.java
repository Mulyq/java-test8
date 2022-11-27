import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    final static int EOF = -1;
    public static void main(String[] args) {
        Map<String ,Integer> mp = new HashMap<>();
        try {
            File Stopword = new File("data/dictionary/stopwords.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(Stopword));
            ArrayList<String> stopword = new ArrayList<>();
            String string1 = null;
            while ((string1 = br1.readLine()) != null) {
                stopword.add(string1);
            }
            byte[] bytes = new byte[1000000];
            File inputStream = new File("三国演义(罗贯中).txt");
            try {
                Scanner sc = new Scanner(inputStream);
                while(sc.hasNextLine()) {
                    String s = sc.nextLine();
//                    List<Term> terms = StandardTokenizer.segment(s);
                    bytes = s.getBytes("UTF-8");
                    s = new String(bytes, StandardCharsets.UTF_8);
                    HanLP.Config.ShowTermNature = false;
                    ArrayList<String> TermList = new ArrayList<>();
                    List<Term> termList = HanLP.segment(s);
                    for(int i = 0;i < termList.size(); i++){
                        TermList.add(termList.get(i).toString());
                    }
                    TermList.removeAll(stopword);
                    StringBuffer sb = new StringBuffer();
                    for(int i = 0; i < TermList.size(); i++) {
                        String x = termList.get(i).word;
                        int count = (mp.containsKey(x) ? mp.get(x) : 0);
                        mp.put(x, count + 1);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ArrayList<String> a = new ArrayList<>();
            for(String x : mp.keySet()) {
                a.add(x);
            }
            Collections.sort(a, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return mp.get(o2) - mp.get(o1);
                }
            });
            FileOutputStream outputStream = new FileOutputStream("三国演义词频.txt");
            StringBuffer stringBuffer = new StringBuffer();
            for(String x : a) {
                stringBuffer.append(x + "\t" + mp.get(x) + "\n");
            }
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}