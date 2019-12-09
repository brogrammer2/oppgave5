import java.util.Iterator;
import java.util.Arrays;

public abstract class Rute {
  Labyrint labyrint;
  int[] nord = new int[2];
  int[] soer = new int[2];
  int[] oest = new int[2];
  int[] vest = new int[2];
  public int x;
  public int y;

  public Rute(Labyrint labyrint, int x, int y) {
    this.labyrint = labyrint;
    this.x = x;
    this.y = y;
    nord[0] = x;
    nord[1] = y - 1;
    soer[0] = x;
    soer[1] = y + 1;
    oest[0] = x + 1;
    oest[1] = y;
    vest[0] = x - 1;
    vest[1] = y;
  }

  abstract char tilTegn();

  public void gaa(int[] komFra, String utvei) {
    utvei += "("+ (x+1) + ", "+ (y+1) +" ) --> ";
    if(!Arrays.equals(komFra, nord)) {
      sjekkNabo(nord, utvei);
    }
    if(!Arrays.equals(komFra, soer)) {
      sjekkNabo(soer, utvei);
    }
    if(!Arrays.equals(komFra, oest)) {
      sjekkNabo(oest, utvei);
    }
    if(!Arrays.equals(komFra, vest)) {
      sjekkNabo(vest, utvei);
    }

  }

  public int[] minPosisjon() {
    int[] minPosisjon = new int[2];
    minPosisjon[0] = x;
    minPosisjon[1] = y;
    return minPosisjon;
  }

  private void sjekkNabo(int[] naboKoordinater, String utvei) {
    Rute rute = labyrint.hentRute(naboKoordinater);

    if(rute instanceof HvitRute) {
      rute.gaa(minPosisjon(), utvei);
    }

  }

  public void finnUtvei() {
    String utvei = "";
       gaa(minPosisjon(), utvei);
  }
}
