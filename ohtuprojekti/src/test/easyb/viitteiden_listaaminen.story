import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä saa halutessaan listauksen järjestelmään lisätyistä viitteistä'

scenario "Käyttäjä saa listauksen järjestelmän viitteistä", {
    given 'valitessa viitteiden listaus', {
       sailo = new ViiteSailo()
       list1 = new ArrayList<String>()
       list1.add("koira")
       list2 = new ArrayList<String>()
       list2.add("kissa")
       viite = new Viite("tyyppi", "id", new ArrayList<String>() , new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>())
    }

    when 'pyydetään listausta viitteistä', {
        sailo.addViite(viite)
    }

    then 'saadaan listamuotoinen selkeä esitys viitteistä', {
        sailo.listaaViitteet().shouldBe "Tyyppi: tyyppi\nId: id\n\n"
    }
}

