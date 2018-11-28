package main;

import ohtu.ohtuvarasto.*;

public class Main {

    public static void main(String[] args) {
        final double ALKUTILAVUUS = 100.0;

        double oluenAlkusaldo = 20.2;

        Varasto mehua = new Varasto(ALKUTILAVUUS);
        Varasto olutta = new Varasto(ALKUTILAVUUS, oluenAlkusaldo);

        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("getTilavuus    = " + olutta.getTilavuus());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());

        System.out.println("Mehusetterit:");
        System.out.println("Lisätään 50.7");
        double lisays = 50.7;
        mehua.lisaaVarastoon(lisays);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Otetaan 3.14");
        double otto = 3.14;
        mehua.otaVarastosta(otto);
        System.out.println("Mehuvarasto: " + mehua);

        System.out.println("Virhetilanteita:");
        System.out.println("new Varasto(-100.0);");
        final double NEGATIIVINEN_TILAVUUS = -100.0;
        Varasto huono = new Varasto(NEGATIIVINEN_TILAVUUS);
        System.out.println(huono);

        System.out.println("new Varasto(100.0, -50.7)");
        otto = -50.7;
        huono = new Varasto(ALKUTILAVUUS, otto);
        System.out.println(huono);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.lisaaVarastoon(1000.0)");
        lisays = 1000.0;
        olutta.lisaaVarastoon(lisays);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.lisaaVarastoon(-666.0)");
        lisays = -666.0;
        mehua.lisaaVarastoon(lisays);
        System.out.println("Mehuvarasto: " + mehua);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.otaVarastosta(1000.0)");
        otto = 1000.0;
        double saatiin = olutta.otaVarastosta(otto);
        System.out.println("saatiin " + saatiin);
        System.out.println("Olutvarasto: " + olutta);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.otaVarastosta(-32.9)");
        otto = -39.2;
        saatiin = mehua.otaVarastosta(otto);
        System.out.println("saatiin " + saatiin);
        System.out.println("Mehuvarasto: " + mehua);
    }


}

