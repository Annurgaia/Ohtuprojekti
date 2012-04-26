import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi lisätä viitteen järjestelmään'


scenario "käyttäjän voi onnistuneesti lisätä viitteen järjestelmään", {
    given 'valitaan viitteen lisääminen', {
       hallinta = new ViiteHallinta()
   }
    when 'Oikeat tiedot syötetään järjestelmään', {
     hallinta.lisaaViite("asdf", "", new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>())
    }

    then 'viite on lisätty järjestelmään', {
       hallinta.getViiteLista().values().size().shouldBe 1
    }
}