import ohtu.*
import ohtu.viitteidenHallinta.*
import java.util.*

description 'Käyttäjä voi lisätä tagin viitteeseen'


scenario "käyttäjän voi onnistuneesti lisätä viitteisiin tageja järjestelmään", {
    given 'valitaan tagin lisaaminen', {
       taginhallinta = new TaginHallinta()
   }
    when 'Oikeat tiedot syötetään järjestelmään', {
     taginhallinta.lisaaTageihinViite ("asdf","")
    }

    then 'tagi on lisätty viitteeseen', {
       taginhallinta.getViiteLista()tagit.get(viiteTagi).containsKey(viite.getId().shouldBe true
    }
}


scenario "käyttäjän voi onnistuneesti poistaa tagin viitteesta", {
    given 'valitaan tagin poistaminen', {
       taginhallinta = new TaginHallinta()
   }
    when 'Oikeat tiedot syötetään järjestelmään', {
     poistaTageistaViite("asdf", "")
    }

    then 'viite on poistettu järjestelmästä', {
       taginhallinta.getViiteLista()tagit.get(viiteTagi).containsKey(viite.getId().shouldBe false
    }
}