import tarvittavat paketit

description 'Käyttäjä voi lisätä viitteen järjestelmään'


scenario "user can login with correct password", {
    given 'command login selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("login", "pekka", "akkep") 
       app = new App(io, auth)
    }

    when 'a valid username and password are entered', {
       app.run()
    }

    then 'user will be logged in to system', {
       io.getPrints().shouldHave("logged in")
    }
}

