import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi lisätä viitteen järjestelmään'


scenario "käyttäjän voi onnistuneesti lisätä viiteen järjestlmään", {
    given 'valitaan viitteen lisääminen', {
       sailo = new ViiteSailo()
       viite = new Viite("tyyppi", "id", new HashMap<String, String>(), new HashMap<String, String>())
    }
    when 'Oikeat tiedot syötetään järjestelmään', {
       sailo.addViite(viite)
    }

    then 'viite on lisätty järjestelmään', {
       sailo.getViitteet().get(0).getType().shouldBe "tyyppi"
    }
}

