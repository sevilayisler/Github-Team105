

import java.sql.*;

        public class JDBC01_Query01 {

            public static void main(String[] args) throws ClassNotFoundException, SQLException {

                // 1 - Ilgili Driver' i yuklemeliyiz - MySQL kullandigimizi bildiriyoruz
                // Driver'i bulamama ihtimaline karsi forName methodu benden 'ClassNotFoundException'
                // icin main methoda exception firlatmami istiyor
                Class.forName("com.mysql.cj.jdbc.Driver");

                // 2 - Baglantiyi olusturmak icin username ve password girisi yapmaliyiz
                // Burada da username ve password'un yanlis olmasi ihtimaline karsi getConnection metodu
                // SQLException firlatmami istiyor

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");

                // 3 - SQL Query'leri icin bir Statement objesi olusturup , javada kendimize SQL sorgulari icin bir alan acacagiz.

                Statement st = con.createStatement();

                // 4 - SQL sorgularini yazip, calistirabiliriz

                ResultSet veri =st.executeQuery("SELECT * FROM calisanlar");

                // 5 - Sonuclari gormek icin Iteration ile Set icerisindeki elemanlari while dongusu icerisinde yazdiracagiz

        /*
        CREATE TABLE calisanlar
	(
		id INT PRIMARY KEY,
		isim VARCHAR(50),
		sehir VARCHAR(50),
		maas INT,
		sirket VARCHAR(20)
	);
         */

                //  while (veri.next()){
                //      System.out.println(veri.getInt("id")+ " " + veri.getString("isim")+ " " + veri.getString("sehir")+ " "
                //      + veri.getInt("maas")+ " " + veri.getString("sirket"));
                //  }

                while (veri.next()){
                    System.out.println(veri.getInt(1) + " " + veri.getString(2) + " " + veri.getString(3) + " "
                            + veri.getInt(4) + " " + veri.getString(5));
                }

                // 6 - Olusturulan nesneleri close() ile kapatiyoruz ki bellekten kaldiralim

                con.close();
                st.close();
                veri.close();
                /*

                          git remote add origin https://github.com/sevilayisler/Github-Team105.git
                           git add -A
                           git commit -m "first commit"
                           git push -u origin main

                           şimdi yapın
                 */
            }
        }



