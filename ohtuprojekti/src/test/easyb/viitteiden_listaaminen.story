import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä saa halutessaan listauksen järjestelmään lisätyistä viitteistä'

scenario "Käyttäjä saa listauksen järjestelmän viitteistä", {
    given 'valitessa viitteiden listaus', {
       sailo = new ViiteSailo()
<<<<<<< HEAD
       viite = new Viite("tyyppi", "id", new LinkedHashMap<String, String>() , new LinkedHashMap<String, String>())
=======


       viite = new Viite("tyyppi", "id", new LinkedHashMap<String, String>() , new LinkedHashMap<String, String>())

>>>>>>> 4bd598180ddf6c89487e3ec71aadda68c6c6e7a0
    }

    when 'pyydetään listausta viitteistä', {
        sailo.addViite(viite)
    }

    then 'saadaan listamuotoinen selkeä esitys viitteistä', {
        sailo.listaaViitteet().shouldBe "Tyyppi: tyyppi\nId: id\n\n"
    }
}

