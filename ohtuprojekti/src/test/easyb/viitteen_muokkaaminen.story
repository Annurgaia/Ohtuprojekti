import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi muokata haluamaansa viitettä'


scenario "Käyttäjä voi muokata olemassa olevaa viitettä", {
    given 'valittaessa viitteen muokkaus', {
       sailo = new ViiteSailo()
       viite = new Viite("tyyppi", "id", new HashMap<String, String>(), new HashMap<String, String>())
    }

    when 'haetaan olemassa olevaa viitettä ja päivitetään sen tietoja', {
       sailo.addViite(viite)
       list = new HashMap<String, String>()
       list.put("kakkiainen", null)
       sailo.muokkaaViitetta("id", list, null)
    }

    then 'viitteen tiedot päivittyvät', {
       sailo.getViitteet().get(0).getPakollisetKentat().get(0).shouldBe "kakkiainen"
    }
}
scenario "Käyttäjä ei voi muokata viitettä, jota ei ole olemassa", {
    given 'valittaessa viitteen muokkaus', {
       sailo = new ViiteSailo()
       viite = new Viite("tyyppi", "id", new HashMap<String, String>(), new HashMap<String, String>())
    }

    when 'haetaan viitettä, jota ei ole olemassa', {
        value = sailo.muokkaaViitetta("kyrpakakka", null, null)
    }

    then 'tietoja ei voida päivittää', {
        value.shouldBe false
    }
}
