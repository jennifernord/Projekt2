package projekt2;
import java.util.Scanner;

public class Projekt2 {
    double totpris = 0;
    double pris = 0;
    static void totalt_pris(int födelsedatum){
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
    
    static String bokningsnamn(int födelsedatum, String namn){
        String bokningsnamn=födelsedatum+namn;
        System.out.println(bokningsnamn);
        return bokningsnamn;
    }
    
    static void boka_plats(String plats){
        if(plats=="y"){
            for(int i=0; i < 22; i++){
                System.out.println(fält[i].indexOf("f0"));
            }
        }
    }
    
    public static void main(String[] args) {
        String fält[]= {"f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "f0", "f0", "0", "0", "0", "f0"};
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Vad är ditt födelsedatum? (skriv datumet med år, månad och datum i följd): ");
        int födelsedatum = scan.nextInt();
        totalt_pris(födelsedatum);
        
        System.out.println("Vilket namn ska bokningen stå på?");
        String namn = scan.next();
        bokningsnamn(födelsedatum, namn);
        
        System.out.println("Vill du ha fönsterplats? y/n: ");
        String plats = scan.nextLine();
        
        
    }
    
}
