import tarvittavat paketit

description 'Käyttäjä voi muokata haluamaansa viitettä'


scenario "Käyttäjä voi muokata olemassa olevaa viitettä", {
    given 'valittaessa viitteen muokkaus', {
    }

    when 'haetaan olemassa olevaa viitettä ja päivitetään sen tietoja', {
    }

    then 'viitteen tiedot päivittyvät', {
    }

scenario "Käyttäjä ei voi muokata viitettä, jota ei ole olemassa", {
    given 'valittaessa viitteen muokkaus', {
    }

    when 'haetaan viitettä, jota ei ole olemassa', {
    }

    then 'tietoja ei voida päivittää', {
    }

scenario "Käyttäjän muokatessa yhtä viitteen kenttää muut pysyvät ennallaan", {
    given 'valittaessa viitteen muokkaus', {
    }

    when 'haetaan olemassa olevaa viitettä ja päivitetään yhtä sen kenttää', {
    }

    then 'viitteen tiedot päivittyvät vain siihen kenttään, jota on muutettu', {
    }

}

