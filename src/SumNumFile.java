import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SumNumFile {
    // doc file text va tinh tong cac so nguyen;

    // 1 - doc file text truyen vao duong dan file;

    public void readFileText(String filePath) {
        try {
            // doc file theo duong dan;
            File file = new File(filePath);

            // kiem tra neu file ko ton tai thi nem ra ngoai le;
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            // doc tung dong file va tien hanh cong tong;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();

            // hien thi ra man hinh tong cac so nguyen trong file;
            System.out.println("Tong = " + sum);
        } catch (Exception e) {
            // file ko ton tai hoac noi dung loi thi hien thi loi;
            System.err.println("File ko ton tai or noi dung co loi !");
        }
    }

    public static void main(String[] args) {
//        File f = new File("number.text");
//        System.out.println("Nhap duong dan file: ");
////        Scanner sc = new Scanner(System.in);
//        File f = new File("file.number");
//        System.out.println(f.getAbsoluteFile());
//
        SumNumFile sumNumFile = new SumNumFile();
        sumNumFile.readFileText("/Users/thaodangxuan/IdeaProjects/M2_L16_FILE_IO/src/num.text");

    }

}
