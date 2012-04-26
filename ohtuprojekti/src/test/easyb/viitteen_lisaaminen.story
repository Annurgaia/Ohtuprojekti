import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi lisätä viitteen järjestelmään'


scenario "käyttäjän voi onnistuneesti lisätä viiteen järjestelmään", {
    given 'valitaan viitteen lisääminen', {
       hallinta = new ViiteHallinta()
       viite = new Viite("tyyppi", "id", new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>())
    }
    when 'Oikeat tiedot syötetään järjestelmään', {
     hallinta.lisaaViite(viite)
    }

    then 'viite on lisätty järjestelmään', {
       hallinta.getViitteet().get(0).getType().shouldBe "tyyppi"
    }
}

