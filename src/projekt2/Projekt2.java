package projekt2;
import java.util.Scanner;
import java.util.Arrays;

public class Projekt2 {
    //Alla variabler som behövs i metoderna nedan
    static String fält[] = {"f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "0", "f0"};
    static double totpris = 0;
    
    static void totalt_pris(int födelsedatum){//Denna metod 
        if(födelsedatum < 20050000 && födelsedatum > 19540000){
            double pris = 299.9;
            double totpris = +pris;
            System.out.println(totpris);
        }
        if(födelsedatum > 20050000){
            double pris = 149.9;
            double totpris = +pris;
            System.out.println(totpris);
        }
        if(födelsedatum < 19540000){
            double pris = 200.0;
            double totpris = +pris;
            System.out.println(totpris);
        }
    }
    
    static void boka_plats(String plats, String fält[],int födelsedatum, String namn){
        int index = plats.indexOf("y");
        if(index!=-1){
            int fplats = Arrays.asList(fält).indexOf("f0");
            if(fplats>-1){
                fält[fplats] = födelsedatum+namn;
                System.out.println("Din bokning finns på plats " +fplats+1);
            }
        }
        if(index<0){
            int ifplats = Arrays.asList(fält).indexOf("0");
            if(ifplats>-1){
                fält[ifplats] = födelsedatum+namn;
                System.out.println("Din bokning finns på plats" +ifplats+1);
            }
        }
    }
    
    static void se_bokning(String fält[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ange ditt födelsedatum eller namn: ");
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
        System.out.println("Ange födelsedatum och namn på bokningen: ");
        String namn_bort = scan.nextLine();
        int plats_bort = Arrays.asList(fält).indexOf(namn_bort);
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
        
        do{
            System.out.println("----MENY----");
            System.out.println("1. Boka plats \n2. Se bokning \n3. Ta bort bokning \n4. Se intjänade pengar \nVad vill du göra? ");
            int meny = scan.nextInt();
            if(meny==1){
                System.out.println("Vad är ditt födelsedatum? (skriv datumet med år, månad och datum i följd): ");
                int födelsedatum = scan.nextInt();
                totalt_pris(födelsedatum);
                System.out.println("Vilket namn ska bokningen stå på?");
                String namn = scan.next();
                System.out.println("Vill du ha fönsterplats? y/n: ");
                String plats = scan.next(); 
                boka_plats(plats, fält, födelsedatum, namn);
            }
            if(meny==2){
                se_bokning(fält);
            }
            if(meny==3){
                ta_bort(fält);
            }
            if(meny==4){
                System.out.println("Det totala antalet intjänade pengar är " +totpris +"\nTack för att du betalar och stödjer fattiga barn i Antarktis.");
            }
            if(meny!=1 || meny!=2 || meny!=4){
                System.out.println("Det är inget alternativ, kontrollera att du skrivit rätt.");
            }
        }while(w==1);
      
    
}
}
