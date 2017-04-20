package src.com.test;

import java.util.Scanner;

/**
 * @Author: fzy (zy.fu01@zuche.com)
 * @Date: 2017/3/17 15:35
 * @Description:
 *
Word Maze 鏄竴涓綉缁滃皬娓告垙锛屼綘闇�瑕佹壘鍒颁互瀛楁瘝鏍囨敞鐨勯鐗╋紝浣嗚姹備互缁欏畾鍗曡瘝瀛楁瘝鐨勯『搴忓悆鎺夈�傚涓婂浘锛屽亣璁剧粰瀹氬崟璇峣f锛屼綘蹇呴』鍏堝悆鎺塱鐒跺悗鎵嶈兘鍚冩帀f銆�
浣嗙幇鍦ㄤ綘鐨勪换鍔″彲娌℃湁杩欎箞绠�鍗曪紝浣犵幇鍦ㄥ浜庝竴涓猰铆瀹玀aze锛坣脳m鐨勭煩闃碉級褰撲腑锛岄噷闈㈠埌澶勯兘鏄互瀛楁瘝鏍囨敞鐨勯鐗╋紝浣嗕綘鍙兘鍚冩帀鑳借繛鎴愮粰瀹氬崟璇峎鐨勯鐗┿��
濡備笅鍥撅紝鎸囧畾W涓衡�淪OLO鈥濓紝鍒欏湪鍦板浘涓孩鑹叉爣娉ㄤ簡鍗曡瘝鈥淪OLO鈥濄��
娉ㄦ剰鍖哄垎鑻辨枃瀛楁瘝澶у皬鍐�,浣犲彧鑳戒笂涓嬪乏鍙宠璧般��
杩愯鏃堕棿闄愬埗:  鏃犻檺鍒�
鍐呭瓨闄愬埗:  鏃犻檺鍒�
杈撳叆:
杈撳叆绗竴琛屽寘鍚袱涓暣鏁皀銆乵(0<n, m<21)鍒嗗埆琛ㄧずn琛宮鍒楃殑鐭╅樀锛岀浜岃鏄暱搴︿笉瓒呰繃100鐨勫崟璇峎锛屼粠绗�3琛屽埌搴昻+3琛屾槸鍙寘鍚ぇ灏忓啓鑻辨枃瀛楁瘝鐨勯暱搴︿负m鐨勫瓧绗︿覆銆�
杈撳嚭:
濡傛灉鑳藉湪鍦板浘涓繛鎴愮粰瀹氱殑鍗曡瘝锛屽垯杈撳嚭鈥淵ES鈥濓紝鍚﹀垯杈撳嚭鈥淣O鈥濄�傛敞鎰忥細姣忎釜瀛楁瘝鍙兘鐢ㄤ竴娆°��
鏍蜂緥杈撳叆:
    5 5
    SOLO
    CPUCY
    EKLQH
    CRSOL
    EKLQO
    PGRBC
鏍蜂緥杈撳嚭:yes
 */

public class Word_Maze {

    private Word_Maze(){}

    public static void main(String[] args) {

        Word_Maze tmp = new Word_Maze();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String ans = scanner.next();
        String[] str = new String[n];

        for(int i = 0; i < n; i++){
            str[i] = scanner.next();
        }

        tmp.findWord(str, n, m, ans);

    }

    private void findWord(String[]str, int n, int m, String ans){

        char[][] matrix = new char[n][m];
        int ans_index = 0;
        int ans_length = ans.length();
        int flag = -1;

        for(int i =0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = str[i].charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                int a = i;
                int b = j;
                while(ans_index < ans_length){
                    if(ans_index == ans_length - 1){
                        flag = towards(matrix, a , b , ans.charAt(ans_index), '0');
                    }else{
                        flag = towards(matrix, a , b , ans.charAt(ans_index), ans.charAt(ans_index + 1));
                    }

                    switch(flag){
                        case 0: ans_index = ans_length;break;
                        case 1: ans_index++; a--; break;
                        case 2: ans_index++; a++; break;
                        case 3: ans_index++; b--; break;
                        case 4: ans_index++; b++; break;
                        case 5:
                            System.out.println("yes");return;
                    }
                }

                ans_index = 0;
            }
        }

    }

    private int towards(char[][]matrix, int i , int j, char ans, char next){

        int row = matrix.length;
        int col = matrix[0].length;

        if(matrix[i][j] == ans){
            //left
            if((i - 1 > 0) && (matrix[i-1][j] == next)){
                return 1;
            }else if((i + 1 < row) && (matrix[i+1][j] == next)){//right
                return 2;
            }else if((j - 1 > 0) && (matrix[i][j-1] == next)){//up
                return 3;
            }else if((j + 1 < col) && (matrix[i][j+1] == next)){//down
                return 4;
            }

            return 5;
        }

        return 0;
    }


}
