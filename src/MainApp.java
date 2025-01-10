/*
O firmă comercializează echipamente electronice. Fiecare echipament este înregistrat cu o
denumire, un număr de inventar nr_inv, are un preţ pret şi este plasat într-o anumită zonă din
magazie zona_mag. Orice echipament poate fi într-una din situaţiile:
• achiziţionat
• expus
• vândut
Firma comercializează următoarele tipuri de echipamente: imprimante, copiatoare şi
sisteme de calcul.
Imprimantele sunt caracterizate numărul de pagini scrise pe minut ppm, rezoluţie
(număr de puncte per inch dpi) şi număr de pagini/cartuş p_car şi modul de tipărire (color sau
alb negru).
Copiatoarele sunt caracterizate de numărul de pagini/toner p_ton şi formatul de
copiere (A3 sau A4).
Sistemele de calcul au un monitor de un anumit tip tip_mon, un procesor de o anumită
viteză vit_proc, o capacitate a HDD c_hdd şi li se poate instala unul din sistemele de operare
Windows sau Linux
Să se realizeze ierarhia de clase corespunzătoare modelului prezentat, utilizând tipul
enumerare pentru câmpurile potrivite; Să se documenteze clasele şi metodele şi să se genereze
documentația proiectului.
Să se creeze O SINGURĂ COLECȚIE DE OBIECTE DE TIP LIST în care să fie
preluate datele din fişierul de intrare electronice.txt. Se va dezvolta un meniu care va oferi
următoarele facilităţi:
• Afişarea tuturor echipamentelor
• Afişarea imprimantelor
• Afişarea copiatoarelor
• Afişarea sistemelor de calcul
• Modificarea stării în care se află un echipament
• Setarea unui anumit mod de scriere pentru o imprimantă
• Setarea unui format de copiere pentru copiatoare
• Instalarea unui anumit sistem de operare pe un sistem de calcul
• Afişarea echipamentelor vândute
• Să se realizeze două metode statice pentru serializarea / deserializarea colecției de
obiecte în fișierul echip.bin
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        List<Echipament> echipamente = new ArrayList<>();


        echipamente.add(new Imprimanta("HP LaserJet", 101, 750.0, "Zona 1", Echipament.StareEchipament.ACHIZITIONAT, 20, 600, 1000, Imprimanta.ModTiparire.COLOR));
        echipamente.add(new Copiator("Canon A4 Copier", 102, 500.0, "Zona 2", Echipament.StareEchipament.EXPUS, 3000, Copiator.FormatCopiere.A4));
        echipamente.add(new SistemCalcul("Dell Inspiron", 103, 2500.0, "Zona 3", Echipament.StareEchipament.ACHIZITIONAT, "LED", 3.5, 512, SistemCalcul.SistemOperare.WINDOWS));

        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {

            System.out.println("1. Afisare toate echipamentele");
            System.out.println("2. Afisare imprimante");
            System.out.println("3. Afisare copiatoare");
            System.out.println("4. Afisare sisteme de calcul");
            System.out.println("5. Modificare stare echipament");
            System.out.println("6. Setare mod tiparire imprimanta");
            System.out.println("7. Setare format copiere copiator");
            System.out.println("8. Instalare sistem operare pe sistem de calcul");
            System.out.println("0. Iesire");
            System.out.print("Alege o optiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune)
            {
                case 1 -> afisareEchipamente(echipamente);
                case 2 -> afisareImprimante(echipamente);
                case 3 -> afisareCopiatoare(echipamente);
                case 4 -> afisareSistemeCalcul(echipamente);
                case 5 -> modificareStareEchipament(echipamente, scanner);
                case 6 -> setareModTiparire(echipamente, scanner);
                case 7 -> setareFormatCopiere(echipamente, scanner);
                case 8 -> instalareSistemOperare(echipamente, scanner);
                case 0 -> System.out.println("Iesire");
                default -> System.out.println("Optiune nu e valida  ");
            }
        } while (optiune != 0);

        scanner.close();
    }

    //afis echipamente
    private static void afisareEchipamente(List<Echipament> echipamente)
    {
        System.out.println("\nLista a echipamnetea: ");
        echipamente.forEach(System.out::println);
    }

    //afis imprimante
    private static void afisareImprimante(List<Echipament> echipamente)
    {
        System.out.println("\nImprimante:");
        echipamente.stream().filter(e -> e instanceof Imprimanta).forEach(System.out::println);
    }

    //afis copiatoare
    private static void afisareCopiatoare(List<Echipament> echipamente)
    {
        System.out.println("\nCopiatoare:");
        echipamente.stream().filter(e -> e instanceof Copiator).forEach(System.out::println);
    }

    //afis sistCalcul
    private static void afisareSistemeCalcul(List<Echipament> echipamente)
    {
        System.out.println("\nSisteme de calcul:");
        echipamente.stream().filter(e -> e instanceof SistemCalcul).forEach(System.out::println);
    }

    //modificare stare echip
    private static void modificareStareEchipament(List<Echipament> echipamente, Scanner scanner)
    {
        System.out.print("Introdu nrinventar: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        Echipament echipament = echipamente.stream().filter(e -> e.getNrInv() == nrInv).findFirst().orElse(null);

        if (echipament != null)
        {
            System.out.print("Introdu starea dorita pt produs: ");
            String stareNoua = scanner.nextLine().toUpperCase();
            try {
                echipament.setStare(Echipament.StareEchipament.valueOf(stareNoua));

            } catch (IllegalArgumentException e)
            {
                System.out.println("Nu se poate ontroduce starea orita.");
            }
        } else {
            System.out.println("Echipamentul nu este in lista");
        }
    }

    //setare modTiparireImprimanta
    private static void setareModTiparire(List<Echipament> echipamente, Scanner scanner)
    {
        System.out.print("Introdu nr de inventar al imprimantei: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        Imprimanta imprimanta = (Imprimanta) echipamente.stream().filter(e -> e instanceof Imprimanta && e.getNrInv() == nrInv).findFirst().orElse(null);

        if (imprimanta != null)
        {
            System.out.print("Introdu modul de tiparire (COLOR, ALB_NEGRU): ");
            String modNou = scanner.nextLine().toUpperCase();
            try
            {
                imprimanta.setModTiparire(Imprimanta.ModTiparire.valueOf(modNou));

            } catch (IllegalArgumentException e)
            {
                System.out.println("Optiune gresita");
            }
        }


    }

    //setare format copiat
    private static void setareFormatCopiere(List<Echipament> echipamente, Scanner scanner)
    {
        System.out.print("Introdu nr de inventar al copiatorului: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        Copiator copiator = (Copiator) echipamente.stream().filter(e -> e instanceof Copiator && e.getNrInv() == nrInv).findFirst().orElse(null);

        if (copiator != null)
        {
            System.out.print("Introdu format copiere: ");
            String formatNou = scanner.nextLine().toUpperCase();
            try
            {
                copiator.setFormat(Copiator.FormatCopiere.valueOf(formatNou));

            } catch (IllegalArgumentException e)
            {
                System.out.println("Format invalid!");
            }
        }
    }

    //instalare sist operare
    private static void instalareSistemOperare(List<Echipament> echipamente, Scanner scanner)
    {
        System.out.print("Introdu nr de inventar al sist de calcul: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        SistemCalcul sistem = (SistemCalcul) echipamente.stream().filter(e -> e instanceof SistemCalcul && e.getNrInv() == nrInv).findFirst().orElse(null);

        if (sistem != null)
        {
            System.out.print("Introdu sistemul de operare: ");
            String sistemNou = scanner.nextLine().toUpperCase();
            try {
                sistem.setSistemOperare(SistemCalcul.SistemOperare.valueOf(sistemNou));

            } catch (IllegalArgumentException e) {
                System.out.println("Sistem de operare invalid!");
            }
        }
    }
}
