import tarvittavat paketit

description 'Käyttäjä saa järjestelmään lisäämistään viitteistä Bibtex-muotoisen tiedoston'


scenario "käyttäjä saa järjestelmän viitteet halutessaan bibtex-muodossa", {
    given 'valitaan viitteiden muuttamaminen bibtex-muotoon', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("login", "pekka", "akkep") 
       app = new App(io, auth)
    }

    when 'kysytään bibtex-muotoista viitelistaa', {
       app.run()
    }

    then 'saadaan bibtex-muotoinen viitelista', {
       io.getPrints().shouldHave("logged in")
    }

scenario "käyttäjän ääkköset toimivat bibtex-mudoossa", {
    given 'valitaan viitteiden muuttamaminen bibtex-muotoon', {
    }

    when 'kysytään bibtex-muotoista viitelistaa ja osassa viitteistä on ääkkösiä', {
    }

    then 'saadaan bibtex-muotoinen viitelista, jossa ääkköset näkyvät oikein', {
    }
}

