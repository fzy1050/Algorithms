package src.com.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fzy on 17-3-18.
 *
 * 10涓鐢熻�冨畬鏈熸湯鑰冭瘯璇勫嵎瀹屾垚鍚庯紝A鑰佸笀闇�瑕佸垝鍑哄強鏍肩嚎锛岃姹傚涓嬶細
 (1)聽鍙婃牸绾挎槸10鐨勫�嶆暟锛�
 (2)聽淇濊瘉鑷冲皯鏈�60%鐨勫鐢熷強鏍硷紱
 (3)聽濡傛灉鎵�鏈夌殑瀛︾敓閮介珮浜�60鍒嗭紝鍒欏強鏍肩嚎涓�60鍒�
 鎬濊矾锛�
 瀵瑰垎鏁版帓搴忥紝鍒嗘暟绾挎槸姣旂浜斾釜鏁板皬鐨勬暣鏁般��
 */
public class Pass_Line {

    public Pass_Line(){}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Pass_Line tmp = new Pass_Line();
        tmp.getPassLine(str);
    }

    private void getPassLine(String str){
        String[] arr = str.split(" ");
        int size = arr.length;
        int[] scores = new int[size];

        for(int i = 0; i < size; i++){
            scores[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(scores);

        int pass_line = 60;
        if(scores[0] < 60)
            pass_line = scores[4] - scores[4] % 10;

        System.out.println(pass_line);
    }
}
