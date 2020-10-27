package Oblig2;

import static javax.swing.JOptionPane.*;

public class Oppgave1 {
    //Lag et program som beregner og skriver ut summen av
    //alle tall mellom to grenser som brukeren skrive.

    //Dersom innlest øvre grense er mindre enn eller lik nedre grense,
    //skal programmet skrive ut en melding til brukeren om dette og foreta ny innlesing.
    public static void main(String[] args) {
        String innNedreGrense;
        String innOvreGrense;

        int nedreGrense = 0;
        int ovreGrense = 0;

        //Sjekker om nedre grense og øvre grense er tall, og deretter om øvre grense er større enn nedre.
        boolean gyldigInput = false;
        while (!gyldigInput) {
            innNedreGrense = showInputDialog("Skriv inn nedre grense");
            innOvreGrense = showInputDialog("Skriv inn øvre grense");

            try {
                nedreGrense = Integer.parseInt(innNedreGrense);
                ovreGrense = Integer.parseInt(innOvreGrense);

                if (nedreGrense < ovreGrense) {
                    gyldigInput = true;
                } else {
                    showMessageDialog(null, "Øvre grense er mindre eller lik nedre grense.\nSkriv inn ny verdi.");
                }

            } catch (Exception e) {
                showMessageDialog(null, "Du skrev inn et ugyldig tall.\nSkriv inn ny verdi.");
            }
        }

        //Når godkjente grenser er lest inn, skal programmet
        //beregne nevnte sum og summen skal så skrive den ut som en sum.
        //Legg inn et linjeskift for hvert 10. tall i summen.

        int sum = 0;
        for (int i = nedreGrense; i <= ovreGrense; i++) {
            sum += i;
            if (i < ovreGrense) {
                System.out.print(i + " + ");
            } else {
                //Gjør at den ikke skriver " + " på siste tallet
                System.out.print(i + " ");
            }
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.print("= " + sum);
    }
}
