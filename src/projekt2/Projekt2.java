package projekt2;
import java.util.Scanner;
import java.util.Arrays;

public class Projekt2 {
    //Alla variabler som behövs i metoderna nedan
    static String fält[] = {"f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "0", "f0"};//Fält med alla platser
    
    static void boka_plats(String plats, String fält[],int födelsedatum){//metod för att boka plats
        int index = plats.indexOf("y");//Om du svarat ja på om du vill ha fönsterplats får index-variabeln ett positivt värde
        if(index!=-1){//Om du svarat ja, alltså att index-variabeln är >/= 0, följer koden nedan
            int fplats = Arrays.asList(fält).indexOf("f0");//Här letas första möjliga fönsterplats i fältet upp
            if(fplats>-1){//Har fönsterplatsen hittats följer koden nedan
                String födelsedatum_string=Integer.toString(födelsedatum);//Gör om variabeln födelsedatum från int till String för att vara kompatibel
                fält[fplats] = födelsedatum_string;//Byter ut "f0" till den bokades födelsedatum
                System.out.println("Din bokning finns på plats " +fplats+1);
            }
        }
        
        if(index<0){//Om "y" inte hittats på ditt svar om fönsterplats eller inte följer koden nedan
            int ifplats = Arrays.asList(fält).indexOf("0");//Här letas första möjliga plats som inte är en fönsterplats
            if(ifplats>-1){//Om en plats hittas, alltså att variabeln ifplats>-1
                String födelsedatum_string=Integer.toString(födelsedatum);//GÖr om födelsedatum till String
                fält[ifplats] = födelsedatum_string;//Gör om värdet i platsen till födelsedatum
                System.out.println("Din bokning finns på plats" +ifplats+1);
            }
        }
    }
    
    static void se_bokning(String fält[]){//metod för att se om en bokning finns elle inte
        Scanner scan = new Scanner(System.in);
        System.out.println("Ange ditt födelsedatum: ");
        String bokning_sök = scan.nextLine();
        int sök = Arrays.asList(fält).indexOf(bokning_sök);//Letar efter det sökta födelsedatumet i fältet
        
        if(sök!=-1){//Om födelsedatumet finns...
            System.out.println("Din bokning finns på plats " +sök+1);//Skriv ut på vilken plats i fältet
        }
        else{//Om födelsedatumet inte finns...
            System.out.println("Du har ingen bokning.");//Skriv att bokningen inte finns
        }
    }
    
    static void ta_bort(String fält[]){//metod för att ta bort en bokning som redan finns
        Scanner scan = new Scanner(System.in);
        System.out.println("Ange födelsedatum på bokningen: ");
        String bokning_bort = scan.nextLine();
        int plats_bort = Arrays.asList(fält).indexOf(bokning_bort);//Leta efter bokning som person vill ta bort
        if(plats_bort!=-1){//Om bokning finns...
            fält[plats_bort] = "0";//Ändra bokning med födelsedatum till "0" som indikerar en ledig plats
            System.out.println("Din bokning är borttagen.");
        }
        if(plats_bort==-1){//Om bokning inte finns...
            System.out.println("Din bokning finns inte.");//Skriv att bokning inte finns
        }
        
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int w = 1;//Variabel så att while-loopen nedan aldrig tar slut
        double totpris = 0;//Det totala priset av alla bokningar från början
        
        do{
            System.out.println("----MENY----");
            System.out.println("1. Boka plats \n2. Se bokning \n3. Ta bort bokning \n4. Se intjänade pengar \nVad vill du göra? ");
            int meny = scan.nextInt();
            if(meny==1){//Om man valt 1 i menyn...
                System.out.println("Vad är ditt födelsedatum? (skriv datumet med år, månad och datum i följd): ");
                int födelsedatum = scan.nextInt();
                
                if(födelsedatum < 20050000 && födelsedatum > 19540000){//Är du född mellan 1954 och 2005 betalar du 299,9
                    double pris = 299.9;
                    totpris = +pris;
                    System.out.println(totpris);
                }
                if(födelsedatum > 20050000){//Är du född efter 2005 betalar du 149,9
                    double pris = 149.9;
                    totpris = +pris;
                    System.out.println(totpris);
                }
                if(födelsedatum < 19540000){//Är du född innan 1954 betalar du 200
                    double pris = 200.0;
                    totpris = +pris;
                    System.out.println(totpris);
                }
                
                System.out.println("Vill du ha fönsterplats? y/n: ");
                String plats = scan.next(); 
                boka_plats(plats, fält, födelsedatum);
                
                continue;//continue för att hoppa tillbaka till början av loopen
            }
            if(meny==2){//förklaras ovan
                se_bokning(fält);
                continue;//continue för att hoppa tillbaka till början av loopen
            }
            if(meny==3){
                ta_bort(fält);//förklaras ovan
                continue;//continue för att hoppa tillbaka till början av loopen
            }
            if(meny==4){
                System.out.println("Det totala antalet intjänade pengar är " +totpris +"\nTack för att du betalar och stödjer fattiga barn i Antarktis.");
                continue;//continue för att hoppa tillbaka till början av loopen
            }
            if(meny!=1 || meny!=2 ||meny!=3 || meny!=4){//Ifall man angett ett alternativ som inte finns...
                System.out.println("Det är inget alternativ, kontrollera att du skrivit rätt.");//Skriv ut att du ska försöka igen
            }
        }while(w==1);
      
    
}
}
