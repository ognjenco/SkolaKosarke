package skola.model;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		
		Trener trener1= new Trener();
		Trener trener2 = new Trener();
		Trener trener3= new Trener();
		
		Clan clan;
		
		Sala sala1 = new Sala();
		Sala sala2 = new Sala();
		
		trener1.setImeIPrezime("Milan Milovic");
		trener1.setBrojTelefona("0216212188");
		
		trener2.setImeIPrezime("Nikola Rasic");
		trener2.setBrojTelefona("0113112321");
		
		trener3.setImeIPrezime("Petar Borak");
		trener3.setBrojTelefona("0644238421");
		
		
		
		Termin termin1 = new Termin();
		Termin termin2 = new Termin();
		Termin termin3 = new Termin();
		Termin termin4 = new Termin();
		
		
		
		
		Grupa pioniri = new Grupa();
		Grupa kadeti = new Grupa();
		Grupa juniori = new Grupa();
		
		Grupa pioniri2 = new Grupa();
		Grupa kadeti2 = new Grupa();
		Grupa juniori2 = new Grupa();
		
		pioniri.setNaziv("Pioniri");
		pioniri.setTrener(trener1);
		
		kadeti.setNaziv("Kadeti");
		kadeti.setTrener(trener2);
		
		juniori.setNaziv("Juniori");
		juniori.setTrener(trener3);
		
		pioniri2.setNaziv("Pioniri 2");
		pioniri2.setTrener(trener1);
		
		kadeti2.setNaziv("Kadeti 2");
		kadeti2.setTrener(trener2);
		
		juniori2.setNaziv("Juniori 2");
		juniori2.setTrener(trener3);
//		
//
//		trener1.getGrupe().add(pioniri);
//		trener2.getGrupe().add(kadeti);
//		trener3.getGrupe().add(juniori);
//		
//		trener1.getGrupe().add(pioniri2);
//		trener2.getGrupe().add(kadeti2);
//		trener3.getGrupe().add(juniori2);
//		
		sala1.setNaziv("OS Vuk Karadzic");
		sala2.setNaziv("OS Jovan Ducic");
		
		termin1.setGrupa(pioniri);
		termin1.setSala(sala1);
		termin1.setPocetak(new Date());
		
		termin2.setGrupa(juniori);
		termin2.setSala(sala2);
		termin2.setPocetak(new Date());
		
		termin3.setGrupa(kadeti2);
		termin3.setSala(sala2);
		termin3.setPocetak(new Date());
		
		termin4.setGrupa(pioniri2);
		termin4.setSala(sala2);
		termin4.setPocetak(new Date());
		
		sala1.getTerminiUSali().add(termin1);
		sala1.getTerminiUSali().add(termin2);
		
		sala2.getTerminiUSali().add(termin3);
		sala2.getTerminiUSali().add(termin4);
		
//		sesija.beginTransaction();

		Trener[] treneri={trener1,trener2,trener3};
		for(Trener novi : treneri){
			System.out.println(HibernateSetup.dodajTrenera(novi));
		}
		System.out.println(HibernateSetup.dodajTrenera(trener2));
		Grupa[] grupe={pioniri,kadeti,juniori,pioniri2,kadeti2,juniori2};
		for(Grupa grupa : grupe){
			HibernateSetup.dodajGrupu(grupa);
		}
		HibernateSetup.dodajGrupu(pioniri2);
		/*
		sesija.save(sala1);
		sesija.save(sala2);
		
		sesija.save(termin1);
		sesija.save(termin2);
		sesija.save(termin3);
		sesija.save(termin4);
		
		for(int i=0; i<5;i++)
		{
			clan = new Clan();
			clan.setImeIPrezime("Clan "+i);
			clan.setBrojTelefona("000000"+i);
			clan.setGrupa(pioniri);
			clan.setDatumRodjenja(new Date());
			pioniri.getClanovi().add(clan);
			sesija.save(clan);
		}
		
		for(int i=5; i<10;i++)
		{
			clan = new Clan();
			clan.setImeIPrezime("Clan "+i);
			clan.setBrojTelefona("000000"+i);
			clan.setGrupa(kadeti);
			clan.setDatumRodjenja(new Date());
			kadeti.getClanovi().add(clan);
			sesija.save(clan);
		}
		
		for(int i=10; i<15;i++)
		{
			clan = new Clan();
			clan.setImeIPrezime("Clan "+i);
			clan.setBrojTelefona("000000"+i);
			clan.setGrupa(juniori);
			clan.setDatumRodjenja(new Date());
			juniori.getClanovi().add(clan);
			sesija.save(clan);
		}

		for(int i=15; i<20;i++)
		{
			clan = new Clan();
			clan.setImeIPrezime("Clan "+i);
			clan.setBrojTelefona("000000"+i);
			clan.setGrupa(pioniri2);
			clan.setDatumRodjenja(new Date());
			pioniri2.getClanovi().add(clan);
			sesija.save(clan);
		}
		
		for(int i=20; i<25;i++)
		{
			clan = new Clan();
			clan.setImeIPrezime("Clan "+i);
			clan.setBrojTelefona("000000"+i);
			clan.setGrupa(kadeti2);
			clan.setDatumRodjenja(new Date());
			kadeti2.getClanovi().add(clan);
			sesija.save(clan);
		}
		
		for(int i=25; i<30;i++)
		{
			clan = new Clan();
			clan.setImeIPrezime("Clan "+i);
			clan.setBrojTelefona("000000"+i);
			clan.setGrupa(juniori2);
			clan.setDatumRodjenja(new Date());
			juniori2.getClanovi().add(clan);
			sesija.save(clan);
		}



		
		
		
//		sesija.getTransaction().commit();
		sesija.close();
		
		Session sesija2=HibernateSetup.novaSesija();
		sesija2.getTransaction().begin();
//		List<Clan> clanovi=sesija2.createCriteria(Clan.class).list();
//		for(Clan klinac : clanovi){
//			System.out.println("-------Clan: "+klinac);
//			System.out.println("Grupa clana: "+klinac.getGrupa());
//			System.out.println("Trener: "+klinac.getGrupa().getTrener());
//		}
//		List<Grupa> grupe=sesija2.createCriteria(Grupa.class).list();
//		for(Grupa group : grupe){
//			System.out.println("Grupa: "+group);
//			System.out.println("Clanova: "+group.getClanovi().size());
//		}
		
		List<Trener> treneri=sesija2.createCriteria(Trener.class).list();
		sesija2.getTransaction().commit();
		
		sesija2.close();
		
		for(Trener tren : treneri){
			System.out.println("--Trener: "+tren);
			System.out.println("clanovi koje trenira: ");
			for(Grupa njegova : tren.getGrupe()){
				for(Clan klinac : njegova.getClanovi()){
					System.out.println(klinac);
				}
			}
		}
		*/
		System.out.println("Svi treneri");
		for(Trener a : HibernateSetup.sviTreneri()){
			System.out.println(a);
		}
		
		System.out.println("Trener imena Petar Borak 2: "+HibernateSetup.trenerPoImenu("petar borak 2"));
		System.out.println("Grupe trenera 1: ");
		for(Grupa a : HibernateSetup.grupeTrenera(trener1.getImeIPrezime()))
			System.out.println(a);
		System.out.println("Sve grupe");
		for(Grupa a : HibernateSetup.sveGrupe())
			System.out.println(a);
		HibernateSetup.close();
		
	}

}
