package site.laoc.test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String args[]){
        for(int i = 55;i <= 55;i++){
            String name = "E:\\files\\" + "yyxm_" + i + ".txt";

            getYuanHosItemFileData(name);
        }
    }

    public static void getYuanHosItemFileData(String name)
    {
        try {
            //FileReader isr = new FileReader(name);
            InputStreamReader fs = new InputStreamReader(new FileInputStream(name),"UTF-8");
            BufferedReader bf = new BufferedReader(fs);
            String content;
            // 按行读取字符串
            while ((content = bf.readLine()) != null) {
                //content = new String(getUTF8BytesFromGBKString(content),"UTF-8");
                System.out.println(content);
                if (content.contains("yyxmbm"))
                {
                    // 说明是第一行，不做任何处理
                }
                else
                {
                    String[] datas = content.split("\t");

                    if (datas.length != 22)
                    {
                        continue;
                    }


                    String 地纬编码 = datas[0];
                    String 医院项目名称 = datas[1];
                    String 自付比例 = datas[2];
                    String 自付比例说明 = datas[3];
                    String 医疗项目编码 = datas[4];
                    String 规格 = datas[5];
                    String 单位 = datas[6];
                    String 医保最高价 = datas[7];
                    String 剂型 = datas[8];
                    String 生产企业 = datas[9];
                    String 最小规格 = datas[10];
                    String 包装数量 = datas[11];
                    String 更新时间 = datas[12];
                    String 起始日期 = datas[13];
                    String 终止日期 = datas[14];
                    String 人群类别 = datas[15];
                    String 待遇人员类别 = datas[16];
                    String 医疗统筹类别 = datas[17];
                    String 限价 = datas[18];
                    String 审批标志 = datas[19];
                    String 险种标志 = datas[20];
                    String 适应症 = datas[21];

                    if(医院项目名称.contains("艾叶")){
                        System.out.println("-----------------------------");
                        System.out.println(医院项目名称);
                        System.out.println(name);
                        System.out.println("-----------------------------");
                    }
                }
            }
            bf.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * GBK转UTF-8
     * @param gbkStr
     * @return
     */
    public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = gbkStr.charAt(i);
            if (m < 128 && m >= 0) {
                utfBytes[k++] = (byte) m;
                continue;
            }
            utfBytes[k++] = (byte) (0xe0 | (m >> 12));
            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            return tmp;
        }
        return utfBytes;
    }
}
