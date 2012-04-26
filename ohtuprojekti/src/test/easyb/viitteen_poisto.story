import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*


scenario "käyttäjän voi onnistuneesti poistaa viitteen järjestelmästä", {
    given 'valitaan viitteen poistaminen', {
       hallinta = new ViiteHallinta()
       viite = new Viite("tyyppi", "id", new ArrayList<String>, new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>())
    }
    when 'Oikeat tiedot syötetään järjestelmään', {
     hallinta.poistaViite(viite)
    }

    then 'viite on lisätty järjestelmään', {
       hallinta.getViitteet().get(id).getType().shouldBe true

    }
}

scenario "kayttaja ei voi poistaa viitetta jota ei ole", {
    given 'komento "poista" valittu', {
        mockTietokanta = mock(Viitehallinta.class) 
        io = new StubIO("poista", "V2012", "lopeta")
        vp = new Viitepalvelu(mockTietokanta, null, null)
        ui = new TekstiUI(io, vp) 
    }
    when 'tietokannasta puuttuva tunniste syotetty', {
        when(mockTietokanta.poistaViite(anyString())).thenReturn(false)
        ui.run()
    }
    then 'viitetta ei poisteta tietokannasta', {
        io.getPrintit().shouldHave("Poistoa ei tehty, tarkista tunniste.")
    }
}