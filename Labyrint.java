import java.util.Scanner;
import java.io.*;

public class Labyrint {
  public Rute[][] ruteArray;
  int lengde;
  int hoeyde;
  Stabel<String> liste = new Stabel<String>();

  public Rute hentRute(int x, int y) {
    return ruteArray[x][y];
  }

  public Rute hentRute(int[] koordinater) {
    return ruteArray[koordinater[0]][koordinater[1]];
  }

  public void settMinimalUtskrift() {

  }

  private Labyrint(int lengde, int hoeyde) {
      this.lengde = lengde;
      this.hoeyde = hoeyde;
  }

  private void setLabyrint(Rute[][] ruteArray) {
    this.ruteArray = ruteArray;
  }

  public static Labyrint lesFraFil(File fil) throws FileNotFoundException {
    Scanner leser = new Scanner(fil);
    int linjeTeller = 0;
    String linje = leser.nextLine();

    String[] splittTallet = linje.split(" ");
    int x, y;
    y = Integer.parseInt(splittTallet[0]); //endret slik at korrekt hoeyde tas inn
    x = Integer.parseInt(splittTallet[1]); //endret slik at korrekt lengde tas inn
    Rute[][] ruteArray = new Rute[x][y];

    Labyrint l = new Labyrint(x, y);

    while (leser.hasNextLine()) {
      linje = leser.nextLine();
      for (int i = 0; i < linje.length(); i++) {
        if (String.valueOf(linje.charAt(i)).equals(".")) {
          if (i == 0 || linjeTeller == 0 || i == x - 1 || linjeTeller == y - 1) {
            Aapning aapen = new Aapning(l, i, linjeTeller);
            ruteArray[i][linjeTeller] = aapen;
          } else {
          HvitRute hvit = new HvitRute(l, i, linjeTeller);
          ruteArray[i][linjeTeller] = hvit;
        }
        } else {
          SortRute sort = new SortRute(l, i, linjeTeller);
          ruteArray[i][linjeTeller] = sort;
        }
      }
      linjeTeller++;
    }
    l.setLabyrint(ruteArray);
    return l;
  }

  @Override
  public String toString() {
    String labyrintStreng = "";

    for(int y = 0; y < hoeyde; y++) {
      for(int x = 0; x < lengde; x++) {
        labyrintStreng += Character.toString(ruteArray[x][y].tilTegn());
      }
      labyrintStreng += "\n";
    }
    return labyrintStreng;
  }

  public Stabel<String> finnUtveiFra(int kol, int rad) {
      kol -= 1;
      rad -= 1;
      hentRute(kol, rad).finnUtvei();
      return liste;
  }
}
