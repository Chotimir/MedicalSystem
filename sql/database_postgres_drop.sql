ALTER TABLE "przyjecie" DROP CONSTRAINT IF EXISTS "przyjecie_fk0";

ALTER TABLE "przyjecie" DROP CONSTRAINT IF EXISTS "przyjecie_fk1";

ALTER TABLE "przyjecie" DROP CONSTRAINT IF EXISTS "przyjecie_fk2";

ALTER TABLE "przyjecie" DROP CONSTRAINT IF EXISTS "przyjecie_fk3";

ALTER TABLE "przyjecie" DROP CONSTRAINT IF EXISTS "przyjecie_fk4";

ALTER TABLE "rodzaj_zabiegu" DROP CONSTRAINT IF EXISTS "rodzaj_zabiegu_fk0";

ALTER TABLE "rodzaj_zabiegu" DROP CONSTRAINT IF EXISTS "rodzaj_zabiegu_fk1";

ALTER TABLE "choroby_wspolistniejace" DROP CONSTRAINT IF EXISTS "choroby_wspolistniejace_fk0";

ALTER TABLE "choroby_wspolistniejace" DROP CONSTRAINT IF EXISTS "choroby_wspolistniejace_fk1";

ALTER TABLE "leki_stosowane_przed_zabiegiem" DROP CONSTRAINT IF EXISTS "leki_stosowane_przed_zabiegiem_fk0";

ALTER TABLE "leki_stosowane_przed_zabiegiem" DROP CONSTRAINT IF EXISTS "leki_stosowane_przed_zabiegiem_fk1";

ALTER TABLE "badania_przy_przyjeciu" DROP CONSTRAINT IF EXISTS "badania_przy_przyjeciu_fk0";

ALTER TABLE "badania_przy_przyjeciu" DROP CONSTRAINT IF EXISTS "badania_przy_przyjeciu_fk1";

ALTER TABLE "operacja" DROP CONSTRAINT IF EXISTS "operacja_fk0";

ALTER TABLE "operacja" DROP CONSTRAINT IF EXISTS "operacja_fk1";

ALTER TABLE "operacja" DROP CONSTRAINT IF EXISTS "operacja_fk2";

ALTER TABLE "powiklania_operacja" DROP CONSTRAINT IF EXISTS "powiklania_operacja_fk0";

ALTER TABLE "powiklania_operacja" DROP CONSTRAINT IF EXISTS "powiklania_operacja_fk1";

ALTER TABLE "troponiny" DROP CONSTRAINT IF EXISTS "troponiny_fk0";

ALTER TABLE "ponowna_wizyta" DROP CONSTRAINT IF EXISTS "ponowna_wizyta_fk0";

ALTER TABLE "ponowna_wizyta" DROP CONSTRAINT IF EXISTS "ponowna_wizyta_fk1";

ALTER TABLE "opis_choroby_s" DROP CONSTRAINT IF EXISTS "opis_choroby_s_fk0";

ALTER TABLE "opis_powiklania_s" DROP CONSTRAINT IF EXISTS "opis_powiklania_s_fk0";

ALTER TABLE "reoperacja" DROP CONSTRAINT IF EXISTS "reoperacja_fk0";

ALTER TABLE "reoperacja" DROP CONSTRAINT IF EXISTS "reoperacja_fk1";

DROP TABLE IF EXISTS "dane_osobowe";

DROP TABLE IF EXISTS "przyjecie";

DROP TABLE IF EXISTS "rodzaj_zabiegu";

DROP TABLE IF EXISTS "choroby_wspolistniejace";

DROP TABLE IF EXISTS "choroby_s";

DROP TABLE IF EXISTS "leki_stosowane_przed_zabiegiem";

DROP TABLE IF EXISTS "leki_s";

DROP TABLE IF EXISTS "badania_s";

DROP TABLE IF EXISTS "badania_przy_przyjeciu";

DROP TABLE IF EXISTS "operacja";

DROP TABLE IF EXISTS "powiklania_operacja";

DROP TABLE IF EXISTS "powiklania_s";

DROP TABLE IF EXISTS "troponiny";

DROP TABLE IF EXISTS "rodzaj_zabiegu_s";

DROP TABLE IF EXISTS "tryb_zabiegu_s";

DROP TABLE IF EXISTS "lek_znieczulajacy_s";

DROP TABLE IF EXISTS "znieczulenie_s";

DROP TABLE IF EXISTS "palenie_tytoniu_s";

DROP TABLE IF EXISTS "reoperacja";

DROP TABLE IF EXISTS "reoperacja_s";

DROP TABLE IF EXISTS "ponowna_wizyta";

DROP TABLE IF EXISTS "przyczyna_ponownego_przyjecia_s";

DROP TABLE IF EXISTS "opis_choroby_s";

DROP TABLE IF EXISTS "opis_powiklania_s";

DROP TABLE IF EXISTS "badanie_obrazowe_s";

DROP TABLE IF EXISTS "lokalizacja_tetniaka_s";