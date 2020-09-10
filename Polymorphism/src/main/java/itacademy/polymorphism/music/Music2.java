package itacademy.polymorphism.music;

class Stringed extends Instrument {
  public void play(Note n) {

    System.out.println("Stringed.play() " + n);
  }
}

class Brass extends Instrument {
  public void play(Note n) {
    System.out.println("Brass.play() " + n);
  }
}

public class Music2 {

  public static void tune(Wind i) {
    i.play(Note.MIDDLE_C);
  }

  public static void tune(Stringed i) {
    i.play(Note.MIDDLE_C);
  }

  public static void tune(Brass i) {
    i.play(Note.MIDDLE_C);
  }

  //equivalente...
  public static void tune2 (Instrument i){
    i.play(Note.MIDDLE_C);
  }

  public static void main(String[] args) {

    Wind flute = new Wind();
    Stringed violin = new Stringed();
    Brass frenchHorn = new Brass();

    System.out.println("*****************************");

    tune(flute);
    tune(violin);
    tune(frenchHorn);

    System.out.println("*****************************");

    tune2(flute);
    tune2(violin);
    tune2(frenchHorn);

  }
}


