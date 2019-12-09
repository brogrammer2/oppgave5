public class Aapning extends HvitRute {

  public Aapning(Labyrint labyrint, int x, int y) {
    super(labyrint, x, y);
  }
  public void gaa(int[] komFra, String utvei) {
    try {Thread.sleep(5000);} catch (Exception ex) {}
    utvei += "(" + (x+1) + ", " + (y+1) + ") MAAL!";
    labyrint.liste.settInn(utvei);
  }
}
