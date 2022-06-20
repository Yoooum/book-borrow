package net.yoooum.bms.utils;

/**
 * @author Yoooum
 */
public class StringLimit {

    private final String str;
    private final int num;

    public StringLimit(String str, int num) {
        this.str = str;
        this.num = num;
    }

    public String limited() {
        //记录已经截取的字节
        StringBuilder stringBuilder = new StringBuilder();
        //记录已经截取的字节长度
        int len = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //记录单个字符的字节长度
            if ((int) c <= 127) {
                len += 1;
            } else {
                len += 2;
            }
            //如果已经截取的字节长度大于等于要截取的字节长度，则跳出循环
            if (len >= num) {
                return stringBuilder + "...";
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        StringLimit stringLimit = new StringLimit("阿八八阿八八八八八八八爸爸", 14);
        System.out.println(stringLimit.limited());
    }

}
