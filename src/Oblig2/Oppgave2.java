package Oblig2;

import static javax.swing.JOptionPane.*;

class Tallspill {
    public int nyttTall() {
        // Trekker og returnerer et slumptall mellom 0 og 200.
        // Tips bruk : (int) (Math.random() * 201), som gir verdier mellom 0 og 200
        return (int) (Math.random() * 201);
    }


    public void visMelding(String melding) {
        // Viser parameterens innhold i en meldingsboks.
        showMessageDialog(null, melding);
    }

    private void forLite(int tall) {
    /* Viser melding om at parameterens verdi er for
       lite tall og ber spilleren prøve igjen. */
        String melding = tall + " er for lite!\nPrøv igjen!";
        visMelding(melding);
    }

    private void forStort(int tall) {
    /* Viser melding om at parameterens verdi er for
      stort tall og ber spilleren prøve igjen. */
        String melding = tall + " er for stort!\nPrøv igjen!";
        visMelding(melding);
    }

    public void avsluttRunde(int antall, int gjetning) {
    /* Viser melding om at det ble gjettet riktig
      og antall gjetninger som ble brukt.
      Parametrene gir opplysninger om dette. */
        showMessageDialog(null, gjetning + " er riktig!\nDu gjettet riktig på " + antall + " forsøk.");
    }

    public void kjørSpill() {
    /* Kjører en spillrunde ved å trekke et tall,
      nullstille tellevariabel, innhente gjentatte
      gjetninger fra bruker inntil det gjettes riktig.
      Når det skjer, avsluttes runden med passe
      meldinger til spilleren. */
        int fasit = nyttTall();
        int antallForsok = 0;
        int input = 0;

        while (input != fasit) {
            antallForsok++;

            try {
                input = Integer.parseInt(showInputDialog("Jeg tenker på et tall mellom 0 og 200.\nPrøv å gjette " + "tallet"));
            } catch (Exception e) {
                continue;
            }

            if (input < fasit) {
                forLite(input);
            } else if (input > fasit) {
                forStort(input);
            } else /* (input == fasit) */{
                avsluttRunde(antallForsok, input);
            }
        }
    }
}

public class Oppgave2 {
    public static void main(String[] args) {

    Tallspill spill = new Tallspill();
    spill.kjørSpill();

    }
}
