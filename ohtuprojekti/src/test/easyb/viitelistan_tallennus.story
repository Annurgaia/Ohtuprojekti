import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi tallentaa viitelistan järjestelmään'


scenario "käyttäjänvoi onnistuneesti tallentaa viitelistan järjestelmään", {
    given 'valitaan viitteiden tallentaminen', {
       hallinta = new ViiteHallinta()
   }
    when 'Oikeat tiedot syötetään järjestelmään', {
     hallinta.lisaaViite("asdf", "", new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>())
    }

    then 'viitteet on tallennettu järjestelmään', {
       hallinta.tallennaViitteet().values().size().shouldBe 1
    }
}