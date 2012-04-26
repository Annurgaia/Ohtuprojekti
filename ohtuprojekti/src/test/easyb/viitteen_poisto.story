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

    then 'viite on poistettu järjestelmästä', {
       hallinta.getViitteet().get(id).getType().shouldBe true

    }
}

