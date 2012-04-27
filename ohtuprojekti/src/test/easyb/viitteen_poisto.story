import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi poistaa viitteen järjestelmästä'


scenario "käyttäjän voi onnistuneesti poistaa viitteen järjestelmästä", {
    given 'valitaan viitteen poistaminen', {
       hallinta = new ViiteHallinta()
   }
    when 'Oikeat tiedot syötetään järjestelmään', {
     hallinta.poistaViite("asdf")
    }

    then 'viite on poistettu järjestelmästä', {
       hallinta.getViiteLista().values().size().shouldBe 1
    }
}

