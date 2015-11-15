package skola.model;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HibernateSetup {
	private static SessionFactory sessionFactory;

	 static{

		Configuration conf=new Configuration();
		conf.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		conf.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
		File tren=new File(".");
		String userDir=System.getProperty("user.home");
		String putanja=userDir+File.separator+"Feniks Basket"+File.separator+"nova";
		conf.setProperty("hibernate.connection.url", "jdbc:h2:"+putanja);
		conf.setProperty("hibernate.connection.username", "ognjen");
		conf.setProperty("hibernate.connection.password", "");
		conf.setProperty("hibernate.hbm2ddl.auto", "update");
		conf.setProperty("hibernate.connection.autocommit","true");
		conf.addAnnotatedClass(Clan.class).addAnnotatedClass(Clanarina.class).addAnnotatedClass(Grupa.class);
		conf.addAnnotatedClass(Sala.class).addAnnotatedClass(Termin.class).addAnnotatedClass(Trener.class);
		sessionFactory=conf.buildSessionFactory();

	}
	public static Session novaSesija(){
		Session sesija=sessionFactory.openSession();
		sesija.beginTransaction();
		return sesija;
	}

	public static void zatvoriSesiju(Session s){
		try{
		s.getTransaction().commit();
		}
		catch(Exception e){

		}
		finally{
			s.close();
		}
	}
	public static int dodajTrenera(Trener novi){
		Session s=novaSesija();
		List<Trener> postoji=s.createCriteria(Trener.class).add(Restrictions.and(Restrictions.eq("imeIPrezime", novi.getImeIPrezime()),Restrictions.eq("brojTelefona", novi.getBrojTelefona()))).list();
		if(postoji.size()>0){
			s.close();
			return -1;
		}
		Integer broj=(Integer)s.save(novi);
		zatvoriSesiju(s);
		return broj;
	}
	public static Trener[] sviTreneri(){
		Session s=novaSesija();
		List<Trener> svi=s.createCriteria(Trener.class).list();
		zatvoriSesiju(s);

		return svi.toArray(new Trener[]{});
	}
	public static Trener trenerPoImenu(String imeIPrezime){
		Session s=novaSesija();
		Trener trazeni=null;
		try{
			trazeni=(Trener) s.createCriteria(Trener.class).add(Restrictions.eq("imeIPrezime", imeIPrezime).ignoreCase()).list().get(0);
		}
		catch(IndexOutOfBoundsException e){
			s.close();
			return null;
		}
		zatvoriSesiju(s);
		return trazeni;
	}
	public static List<Grupa> grupeTrenera(String imeIPrezime){
		Session s=novaSesija();
		Trener izBaze=null;
		try{
		izBaze=(Trener)s.createCriteria(Trener.class).add(Restrictions.eq("imeIPrezime", imeIPrezime).ignoreCase()).list().get(0);
		}
		catch(IndexOutOfBoundsException e){
			return null;
		}
		List<Grupa> traz=s.createCriteria(Grupa.class).add(Restrictions.eq("trener", izBaze)).list();
		zatvoriSesiju(s);
		return traz;
	}

	public static boolean dodajGrupu(Grupa nova){
		Session s=novaSesija();
		try{
			s.save(nova);
		}
		catch(Exception e){
			return false;
		}
		finally{
			zatvoriSesiju(s);
		}
		return true;
	}
	public static Grupa[] sveGrupe(){
		Session s=novaSesija();
		List<Grupa> sve=s.createCriteria(Grupa.class).list();
		zatvoriSesiju(s);
		return sve.toArray(new Grupa[]{});
	}

	public static Clan[] sviClanovi(){
		Session s=novaSesija();
		List<Clan> svi=s.createCriteria(Clan.class).list();
		zatvoriSesiju(s);
		return svi.toArray(new Clan[]{});
	}
	public static void close(){
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}
