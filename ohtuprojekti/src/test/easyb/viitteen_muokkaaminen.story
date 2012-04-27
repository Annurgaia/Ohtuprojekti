import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi muokata haluamaansa viitettä'


scenario "Käyttäjä voi muokata olemassa olevaa viitettä", {
    given 'valittaessa viitteen muokkaus', {
       hallinta = new ViiteHallinta()
       viite = new Viite("tyyppi", "id", new ArrayList<String> tagit, new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>())
    }

    when 'haetaan olemassa olevaa viitettä ja päivitetään sen tietoja', {
       hallinta.lisaaViite(viite)
       list = new LinkedHashMap<String, String>()
       list.put("kakkiainen", null)
       hallinta.muokkaaViitetta("id", "", list, null)
    }

    then 'viitteen tiedot päivittyvät', {
     hallinta.getViitteet().get(id).getPakollisetKentat().containsKey("kakkiainen").shouldBe true
    }
}
scenario "Käyttäjä ei voi muokata viitettä, jota ei ole olemassa", {
    given 'valittaessa viitteen muokkaus', {
       hallinta = new ViiteHallinta()
       viite = new Viite("tyyppi", "id", new ArrayList<String> tagit, new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>())
    }

    when 'haetaan viitettä, jota ei ole olemassa', {
        value = hallinta.muokkaaViitetta("trol", "", null, null)
    }

    then 'tietoja ei voida päivittää', {
        value.shouldBe false
    }
}
