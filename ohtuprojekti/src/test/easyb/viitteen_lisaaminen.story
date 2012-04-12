import tarvittavat paketit

description 'Käyttäjä voi lisätä viitteen järjestelmään'


scenario "käyttäjän voi onnistuneesti lisätä viiteen järjestlmään", {
    given 'valitaan viitteen lisääminen', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("login", "pekka", "akkep") 
       app = new App(io, auth)
    }

    when 'Oikeat tiedot syötetään järjestelmään', {
       app.run()
    }

    then 'viite on lisätty järjestelmään', {
       io.getPrints().shouldHave("logged in")
    }

scenario "", {
    given 'valitaan viitteen lisääminen', {
    }

    when 'Oikeat tiedot syötetään järjestelmään', {
    }

    then 'viite on lisätty järjestelmään', {
    }
}

