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
        //hkdsajdh
        if(index<0){//Om "y" inte hittats på ditt svar om fönsterplats eller inte följer koden nedan
            int ifplats = Arrays.asList(fält).indexOf("0");//Här letas första möjliga plats som inte är en fönsterplats
            if(ifplats>-1){//Om en plats hittas, alltså att variabeln ifplats>-1
                String födelsedatum_string=Integer.toString(födelsedatum);
                fält[ifplats] = födelsedatum_string;
                System.out.println("Din bokning finns på plats" +ifplats+1);
            }
        }
    }
    
    static void se_bokning(String fält[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ange ditt födelsedatum: ");
        String bokning_sök = scan.nextLine();
        int sök = Arrays.asList(fält).indexOf(bokning_sök);
        
        if(sök!=-1){
            System.out.println("Din bokning finns på plats " +sök+1);
        }
        else{
            System.out.println("Du har ingen bokning.");
        }
    }
    
    static void ta_bort(String fält[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ange födelsedatum på bokningen: ");
        String bokning_bort = scan.nextLine();
        int plats_bort = Arrays.asList(fält).indexOf(bokning_bort);
        if(plats_bort!=-1){
            fält[plats_bort] = "0";
            System.out.println("Din bokning är borttagen.");
        }
        if(plats_bort==-1){
            System.out.println("Din bokning finns inte.");
        }
        
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int w = 1;
        double totpris = 0;
        
        do{
            System.out.println("----MENY----");
            System.out.println("1. Boka plats \n2. Se bokning \n3. Ta bort bokning \n4. Se intjänade pengar \nVad vill du göra? ");
            int meny = scan.nextInt();
            if(meny==1){
                System.out.println("Vad är ditt födelsedatum? (skriv datumet med år, månad och datum i följd): ");
                int födelsedatum = scan.nextInt();
                
                if(födelsedatum < 20050000 && födelsedatum > 19540000){
                    double pris = 299.9;
                    totpris = +pris;
                    System.out.println(totpris);
                }
                if(födelsedatum > 20050000){
                    double pris = 149.9;
                    totpris = +pris;
                    System.out.println(totpris);
                }
                if(födelsedatum < 19540000){
                    double pris = 200.0;
                    totpris = +pris;
                    System.out.println(totpris);
                }
                
                System.out.println("Vill du ha fönsterplats? y/n: ");
                String plats = scan.next(); 
                boka_plats(plats, fält, födelsedatum);
                
                continue;
            }
            if(meny==2){
                se_bokning(fält);
                continue;
            }
            if(meny==3){
                ta_bort(fält);
                continue;
            }
            if(meny==4){
                System.out.println("Det totala antalet intjänade pengar är " +totpris +"\nTack för att du betalar och stödjer fattiga barn i Antarktis.");
                continue;
            }
            if(meny!=1 || meny!=2 ||meny!=3 || meny!=4){
                System.out.println("Det är inget alternativ, kontrollera att du skrivit rätt.");
            }
        }while(w==1);
      
    
}
}
