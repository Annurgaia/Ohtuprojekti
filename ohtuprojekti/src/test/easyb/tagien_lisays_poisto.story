import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi lisätä viitteen järjestelmään'


scenario "käyttäjän voi onnistuneesti lisätä viitteisiin tageja järjestelmään", {
    given 'valitaan tagin lisaaminen', {
       taginhallinta = new TaginHallinta()
   }
    when 'Oikeat tiedot syötetään järjestelmään', {
     taginhallinta.lisaaTageihinViite (ViiteInterface viite,"")
    }

    then 'tagi on lisätty viitteeseen', {
       taginhallinta.getViiteLista()tagit.get(viiteTagi).containsKey(viite.getId().shouldBe true
    }
}


