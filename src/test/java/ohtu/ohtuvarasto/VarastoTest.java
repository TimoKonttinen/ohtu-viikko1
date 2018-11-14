package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
//************ konstruktoritestit *****************
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
        @Test
    public void uudellaVarastollaOikeaTilavuusNegatiivisellaTilavuudella() {
        varasto = new Varasto(-10.0);//tilavuus, alkusaldo
        assertEquals(0.0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    
        @Test
    public void uudellaVarastollaOikeaTilavuusMyosNollatilanteessa() {
        varasto = new Varasto(0.0);
        assertEquals(0.0, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
            @Test
    public void uudellaVarastollaOikeaSaldoNollatilanteessa() {
        varasto = new Varasto(0.0, 0.0);//tilavuus, alkusaldo
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
                @Test
    public void uudellaVarastollaOikeaSaldoYlitaytossa() {
        varasto = new Varasto(10.0, 12.0);//tilavuus, alkusaldo
     
        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
                    @Test
    public void uudellaVarastollaOikeaSaldoNegatiivisellaTaytolla() {
        varasto = new Varasto(10.0, -12.0);//tilavuus, alkusaldo
     
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
//*********** lisäytestit ***************

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoaVainMaxTilavuuteen() {
        varasto.lisaaVarastoon(100);

        // saldon pitäisi olla maksimissaan varaston tilavuus
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    public void negatiivinenLisaysEiMuutaSaldoa() {
        varasto.lisaaVarastoon(8.0);
        varasto.lisaaVarastoon(-2.0);
//         double tilavuus = varasto.getTilavuus();
        double saldo = varasto.getSaldo();
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8.0, saldo, vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
        @Test
    public void negatiivinenLisaysEiMuutaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
        varasto.lisaaVarastoon(-2.0);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
//************ varastosta ottamiset *******************'
    @Test
    public void OtetaanEnemmanKuinTilavuus() {
        varasto.lisaaVarastoon(10.0);
        varasto.otaVarastosta(11.0);
//         double saatuMaara = varasto.otaVarastosta(11);
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void OtetaanNegatiivinenMaara() {
         varasto.lisaaVarastoon(10.0);
        varasto.otaVarastosta(-11.0);
        // saldon pitäisi olla sama kuin ennen ottoa
        assertEquals(10.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
       @Test
    public void OtetaanKaikkiMitaVarastossaOn() {
         varasto.lisaaVarastoon(10.0);
        varasto.otaVarastosta(10.0);
        // saldon pitäisi olla 0.0
        assertEquals(0.0, varasto.getSaldo(), vertailuTarkkuus);
    }
    

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
        @Test
    public void negatiivinenOottaminenEiMuutaTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(-2.0);

        // varastossa pitäisi olla tilaa 10 - 8 eli 4
        assertEquals(2.0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

            @Test
    public void toStringTesti() {
        varasto.lisaaVarastoon(8);
        varasto.otaVarastosta(-2.0);

              double saldo=8.0;
              double mahtuu = 2.0;
              
        // varastossa pitäisi olla tilaa 10 - 8 eli 4
        assertEquals("saldo = 8.0, vielä tilaa 2.0",varasto.toString());
    }
    
    
}
