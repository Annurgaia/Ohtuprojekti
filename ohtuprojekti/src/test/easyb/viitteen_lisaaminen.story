import tarvittavat paketit

description 'Käyttäjä voi lisätä viitteen järjestelmään'


scenario "käyttäjän voi onnistuneesti lisätä viiteen järjestlmään", {
    given 'valitaan viitteen lisääminen', {
       ViiteSailo sailo = new ViiteSailo();
       Viite viite = new Viite("tyyppi", "id", new ArrayList<String>, new ArrayList<String>);
    }

    when 'Oikeat tiedot syötetään järjestelmään', {
       sailo.add(viite);
    }

    then 'viite on lisätty järjestelmään', {
       sailo.getViitteet().get(0).getType().ShouldBe "tyyppi"
    }
}

