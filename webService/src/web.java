import com.mysql.jdbc.Connection;

import java.security.acl.LastOwnerException;
import java.sql.*;

public class web {
	static java.sql.Connection con = null;
    static String url = "jdbc:mysql://studsrv.uni-mb.si/";
    static String db = "Tabletar";
    static String driver = "com.mysql.jdbc.Driver";
    static String user = "tabletar";
    static String pass = "tabletar";
    static Statement st = null;
	
    
    public static String DobiKolicinaZdravila()
	{
		String tmp="";
		try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, user, pass);
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT NAZIV, KOLICINA FROM zdravila");
            while ( rs.next() ) {
            	tmp =tmp + rs.getString("NAZIV")+",";
                tmp = tmp+rs.getString("KOLICINA")+",";
               
            }
            con.close();
        } catch (Exception e) {

        }
		return tmp;
	}
	public static String DobiImeZdravila()
	{
		String tmp="";
		try {
		Class.forName(driver);
        con = DriverManager.getConnection(url + db, user, pass);
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT NAZIV FROM zdravila");
        while ( rs.next() ) {
        	tmp = tmp + rs.getString("NAZIV")+ ",";
      

        }
        con.close();
		 } catch (Exception e) {

	        }
			return tmp;
	}
	public static String DobiOpomnike()
	{
		String tmp="";
		try {
		Class.forName(driver);
        con = DriverManager.getConnection(url + db, user, pass);
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT NAME, TIME, VALUE FROM opomniki");
        while ( rs.next() ) {
        	tmp = tmp + rs.getString("NAME")+ ",";
        	tmp = tmp + rs.getString("TIME")+ ",";
        	
        	
        		tmp = tmp + rs.getString("VALUE")+ ",";
        	

        }
        con.close();
		 } catch (Exception e) {

	        }
			return tmp;
	}
	public static void DodajOpomnike(String naz ,String Time, int kol)
	{
		String tmp="";
		int aa=0;
		String a=naz;
		try {
		Class.forName(driver);
        con = DriverManager.getConnection(url + db, user, pass);
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM opomniki");
        while ( rs.next() ) {
        	tmp = rs.getString("ID");
        	if(aa < (Integer.parseInt(tmp)))
        	{
        		aa=Integer.parseInt(tmp);
        	}
        }
        aa++;
        a = "'" + a + "'";
        Time = "'" + Time + "'";
        stmt.executeUpdate("INSERT INTO opomniki VALUES(" + aa + "," + a + "," + Time + ","+ kol + ")");
        con.close();
		 } catch (Exception e) {
//	            System.out.println(e);
	        }
	
	}
	
	public static void VstaviZdravilaKolicina(String naz, int kol)
	{
		String tmp="";
		int aa=0;
		String a=naz;
		try {
		Class.forName(driver);
        con = DriverManager.getConnection(url + db, user, pass);
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT * FROM zdravila");
        while ( rs.next() ) {
        	tmp = rs.getString("ID");
        	if(aa < (Integer.parseInt(tmp)))
        	{
        		aa=Integer.parseInt(tmp);
        	}
        }
        aa++;
        a = "'" + a + "'";

        stmt.executeUpdate("INSERT INTO zdravila (ID,NAZIV,KOLICINA) VALUES("+ aa +","+ a +","+ kol +")");
        con.close();
		 } catch (Exception e) {

	        }
		
	}
	
	public static void brisanje(String zdr)
	{
		String a="'" + zdr + "'";
		try {
		Class.forName(driver);
        con = DriverManager.getConnection(url + db, user, pass);
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM zdravila WHERE NAZIV=" + a);
        con.close();
		 } catch (Exception e) {

	        }
			
	}
	public static void DodajZalogoZdravil(String zdr, int kol)
	{
		String id="";
		int koli=0;
		int aa=0;
		String a="'" + zdr + "'";
		try {
		Class.forName(driver);
        con = DriverManager.getConnection(url + db, user, pass);
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT ID,KOLICINA FROM zdravila WHERE NAZIV="+ a);
        while ( rs.next() ) {
        	id = rs.getString("ID");
        	koli=Integer.parseInt(rs.getString("KOLICINA"));
        }
        aa++;

        koli=koli+kol;
        brisanje(zdr);
        stmt.executeUpdate("INSERT INTO zdravila (ID,NAZIV,KOLICINA) VALUES(" + id + ","+ a +"," + koli + ")");
        con.close();
		 } catch (Exception e) {

	        }
			
	}
	public static void ZmanjsajZalogoZdravil(String zdr, int kol)
	{
		String id="";
		int koli=0;
		int aa=0;
		String a="'" + zdr + "'";
		try {
		Class.forName(driver);
        con = DriverManager.getConnection(url + db, user, pass);
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery("SELECT ID,KOLICINA FROM zdravila WHERE NAZIV="+ a);
        while ( rs.next() ) {
        	id = rs.getString("ID");
        	koli=Integer.parseInt(rs.getString("KOLICINA"));
        }
        aa++;

        koli=koli-kol;
        brisanje(zdr);
        stmt.executeUpdate("INSERT INTO zdravila (ID,NAZIV,KOLICINA) VALUES(" + id + ","+ a +"," + koli + ")");
        con.close();
		 } catch (Exception e) {

	        }
			
	}
}

