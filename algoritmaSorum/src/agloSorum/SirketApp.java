package agloSorum;


 class Sirket
 {
     int sirketId;
     private String sirketAd;
     String sirketKonum;
     
     public Sirket(int sirketId,String sirketAd,String sirketKonum)
     {
         this.sirketId=sirketId;
         this.sirketAd=sirketAd;
         this.sirketKonum=sirketKonum;
     }
      abstract class Kisi
     {
         int cinsiyet;
         int medenidurum;
         String ad;
         String soyad;
      
         public Kisi(int cinsiyet,int medenidurum,String ad,String soyad)
         {
             this.ad=ad;
             this.cinsiyet=cinsiyet;
             this.medenidurum=medenidurum;
             this.soyad=soyad;
             
         }
         public int getSirketId()
         {
             return sirketId; 
         }
                  
         public String getSirketAd()
         {
             return sirketAd; 
         }
         public String getSirketKonum()
         {
             return sirketKonum; 
         }
     }
      class Calisan extends Kisi
     {
         int SicilNo;
         String Departman;
         String Meslek;
         int OdemeTipi;
         int birimUcret;
     
         public Calisan(int cinsiyet,int medenidurum,String ad,String soyad,int SicilNo,String Departman,String Meslek,int OdemeTipi,int birimUcret )
         {
             super(cinsiyet,medenidurum,ad,soyad);
             this.SicilNo=SicilNo;
             this.OdemeTipi=OdemeTipi;
             this.Departman=Departman;
             this.Meslek=Meslek;
             this.birimUcret=birimUcret;
         }
         public double yillikMaasMiktari()
         {
             double t;
             if(OdemeTipi==0)   //çalısan ücreti haftalık alıyorsa 52 aylık ise 12 ile çarpıyoruz.
             {
                 t= 12*birimUcret;
             }else
             {
                 t= 52*birimUcret;
             }
             return t;
         }
         public double yillikVergi()    //vergi alma olayıda kişinin mesleğine göre yapılıyor.
         {
              double t;
             if(Meslek=="Sef")      
             {
                 t=0.1*yillikMaasMiktari();
             }else if(Meslek=="Yardimci")
             {
                 t=0.15*yillikMaasMiktari();
             }else
             {
                 t=0.18*yillikMaasMiktari();
             }
             return t;
         }
     }
     public class Patron extends Kisi
     {
         int servetMiktari;
         public Patron(int cinsiyet,int medenidurum,String ad,String soyad,int servetMiktari)
         {
             super(cinsiyet,medenidurum,ad,soyad);
             this.servetMiktari=servetMiktari;
         }
         
     }
 
 }
public class SirketApp {

    public static void main(String[] args) {
        
      Sirket Lokanta = new Sirket(1, "Kebabistan Ltd Şti","Van/İpekyolu");
      Sirket.Patron p= Lokanta.new Patron(1,1,"Hasan","Varyemez",1000000);
      Sirket.Calisan c= Lokanta.new Calisan(1,1, "Adem","Levi",1,"Mutfak Dept.","Yardimci",0,6100);
      Sirket.Calisan c1= Lokanta.new Calisan(1,1, "Hakkı","Kaya",1,"İnsan Kaynakları","Sef",1,1700);
      
      System.out.println(" "+ p.ad +" "+ p.soyad+" "+ p.servetMiktari+" "+p.getSirketAd()+" "+p.getSirketKonum());

      System.out.print(" "+ c.ad +" "+ c.soyad+" "+ c.Meslek+" "+c.getSirketAd());
      System.out.print(" Senelik Verginiz :"+c.yillikVergi());
      System.out.println(" Senelik Maas toplamı :"+c.yillikMaasMiktari());
      
      System.out.print(" "+ c1.ad +" "+ c1.soyad+" "+ c1.Meslek+" "+c.getSirketAd());
      System.out.print(" Senelik Verginiz :"+c1.yillikVergi());
      System.out.println(" Senelik Maas toplamı :"+c1.yillikMaasMiktari());
    }
}
