import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä saa halutessaan listauksen järjestelmään lisätyistä viitteistä'

scenario "Käyttäjä saa listauksen järjestelmän viitteistä", {
    given 'valitessa viitteiden listaus', {
        hallinta = new ViiteHallinta()
       viite = new Viite("tyyppi", "id", new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>())
    }

    when 'pyydetään listausta viitteistä', {
        hallinta.lisaaViite("asdf", "", new LinkedHashMap<String, String>(), new LinkedHashMap<String, String>())
    }

    then 'saadaan listamuotoinen selkeä esitys viitteistä', {
        hallinta.getViitteetTekstina().shouldBe "Tyyppi: tyyppi\nId: id\n\n"
    }
}

