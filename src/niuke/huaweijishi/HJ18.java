package niuke.huaweijishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<IPClass> list = new ArrayList<>();
        int countA=0,countB=0,countC=0,countD=0,countSIYOU=0,countE=0,countErr = 0;
        while(in.hasNextLine()){
            String[] str = in.nextLine().split("~");
            if (str.length == 1){
                break;
            }
            IPClass ipClass = new IPClass();
            try {
                ipClass.IP = StringArrayToIntArray(str[0].split("\\."));
            }catch (Exception e){
                countErr++;
                ipClass.Status = false;
            }
            try {
                ipClass.Yanma = StringArrayToIntArray(str[1].split("\\."));
            }catch (Exception e){
                countErr++;
                ipClass.Status = false;
            }
            if (!ipClass.Status){
                continue;
            }
            switch (ipClass.isABCD()) {
                case "A" -> countA++;
                case "B" -> countB++;
                case "C" -> countC++;
                case "D" -> countD++;
                case "E" -> countE++;
                case "IPERR" -> countErr++;
                case "YANMAERR" -> countErr++;
                default -> {
                }
            }
            if (ipClass.isSiYou()){
                countSIYOU++;
            }
        }
        System.out.println(countA + " " + countB + " " + countC + " " + countD + " "+ countE + " " + countErr + " " + countSIYOU);

    }
    public static int[] StringArrayToIntArray(String[] str){
        int[] arr = new int[str.length];
        for(int i = 0;i < str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }
}

class IPClass{
    int[] IP;
    int[] Yanma;
    boolean Status;
    String yanma;

    public IPClass() {
        Status = true;
    }

    public String isABCD(){
        if (this.IP[0] == 0 || this.IP[0] == 127){
            return "BAOLIU";
        }
        if(!this.isIPErr()){
            this.Status = false;
            System.out.println(this);
            return "IPERR";
        }
        if(!this.isYanmaErr()){
            this.Status = false;
            System.out.println(this);
            return "YANMAERR";
        }
        if (this.IP[0] >= 1 && this.IP[0] <= 126){
            return "A";
        }
        if (this.IP[0] >= 128 && this.IP[0] <= 191){
            return "B";
        }
        if (this.IP[0] >= 192 && this.IP[0] <= 223){
            return "C";
        }
        if (this.IP[0] >= 224 && this.IP[0] <= 239){
            return "D";
        }
        if (this.IP[0] >= 240 && this.IP[0] <= 255){
            return "E";
        }

        return "ERR";
    }
    public boolean isSiYou(){
        if (!this.Status){
            return false;
        }
        if (this.IP[0] == 10 ){
            return true;
        }
        if (this.IP[0] == 172 && this.IP[1] >= 16 && this.IP[1] <= 31){
            return true;
        }
        return this.IP[0] == 192 && this.IP[1] == 168;
    }
    public boolean isIPErr(){
        for (int i :
                this.IP) {
            if (i < 0 || i > 255) {
                return false;
            }
        }
        return this.IP.length == 4 && this.IP[3] != 255;
    }
    public boolean isYanmaErr(){
        StringBuilder yanma = new StringBuilder();
        for (int i :
                this.Yanma) {
            String temp = Integer.toBinaryString(i);
            if (temp.length() < 8){
                for (int j = 0;j < 8-temp.length();j++){
                    yanma.append("0");
                }
            }
            yanma.append(temp);
            if (i < 0 || i > 255){
                return false;
            }
        }
        this.yanma = yanma.toString();
        if (yanma.indexOf("0") == -1 || yanma.indexOf("1") == -1){
            return false;
        }
        if (yanma.indexOf("0") == 0){
            return false;
        }
//        System.out.println(t);
        return this.Yanma.length == 4 && !yanma.toString().contains("01");
    }

    @Override
    public String toString() {
        return "IPClass{" +
                "IP=" + Arrays.toString(IP) +
                ", Yanma=" + Arrays.toString(Yanma) +
                ", Status=" + Status +
                ", yanma='" + yanma + '\'' +
                '}';
    }
}
