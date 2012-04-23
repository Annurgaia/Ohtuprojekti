import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä saa halutessaan listauksen järjestelmään lisätyistä viitteistä'

scenario "Käyttäjä saa listauksen järjestelmän viitteistä", {
    given 'valitessa viitteiden listaus', {
       sailo = new ViiteSailo()
       viite = new Viite("tyyppi", "id", new LinkedHashMap<String, String>() , new LinkedHashMap<String, String>())
    }

    when 'pyydetään listausta viitteistä', {
        sailo.addViite(viite)
    }

    then 'saadaan listamuotoinen selkeä esitys viitteistä', {
        sailo.listaaViitteet().shouldBe "Tyyppi: tyyppi\nId: id\n\n"
    }
}

