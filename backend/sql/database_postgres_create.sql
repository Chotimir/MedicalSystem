CREATE TABLE "dane_osobowe" (
	"id_pacjenta" serial NOT NULL,
	"imie" varchar(50) NOT NULL,
	"nazwisko" varchar(50) NOT NULL,
	"plec" varchar(1) NOT NULL,
	"wiek" integer NOT NULL,
	CONSTRAINT dane_osobowe_pk PRIMARY KEY ("id_pacjenta")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "przyjecie" (
	"id_przyjecia" serial NOT NULL,
	"id_pacjenta" integer NOT NULL,
	"id_operacji" integer NOT NULL,
	"data_przyjecia" DATE NOT NULL,
	"data_zabiegu" DATE NOT NULL,
	"objawy_aa" integer NOT NULL,
	"wymiary_aa" integer NOT NULL,
	"maks_wymiary_tetniaka" integer NOT NULL,
	"badanie_obrazowe" integer NOT NULL,
	"lokalizacja_tetniaka" integer NOT NULL,
	"palenie_tytoniu" integer NOT NULL DEFAULT '0',
	"skala_asa" integer NOT NULL,
	"lee_rcri" integer NOT NULL,
	"p_possum" integer NOT NULL,
	"utrata_przytomnosci" integer NOT NULL,
	"uwagi" text,
	CONSTRAINT przyjecie_pk PRIMARY KEY ("id_przyjecia")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "rodzaj_zabiegu" (
	"id_przyjecia" integer NOT NULL,
	"rodzaj_zabiegu" integer NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "choroby_wspolistniejace" (
	"id_pacjenta" integer NOT NULL,
	"id_choroby" integer NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "choroby_s" (
	"id_choroby" serial NOT NULL,
	"nazwa_choroby" varchar(50) NOT NULL,
	CONSTRAINT choroby_s_pk PRIMARY KEY ("id_choroby")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "leki_stosowane_przed_zabiegiem" (
	"id_przyjecia" integer NOT NULL,
	"id_leku" integer NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "leki_s" (
	"id_leku" serial NOT NULL,
	"nazwa_leku" varchar(50) NOT NULL,
	CONSTRAINT leki_s_pk PRIMARY KEY ("id_leku")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "badania_s" (
	"id_badania" serial NOT NULL,
	"nazwa_badania" varchar(50) NOT NULL,
	"jednostka" varchar(10) NOT NULL,
	CONSTRAINT badania_s_pk PRIMARY KEY ("id_badania")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "badania_przy_przyjeciu" (
	"id_przyjecia" integer NOT NULL,
	"id_badania" integer NOT NULL,
	"wynik_badania" FLOAT(10) NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "operacja" (
	"id_operacji" serial NOT NULL,
	"tryb_zabiegu" integer NOT NULL,
	"znieczulenie" integer NOT NULL,
	"lek_znieczulajacy" integer NOT NULL,
	"czas_trwania" integer NOT NULL,
	"czas_klemacji_aorty" integer NOT NULL,
	"noradrenalina" BOOLEAN NOT NULL,
	"adrenalina" BOOLEAN NOT NULL,
	"dopamina" BOOLEAN NOT NULL,
	"dobutamina" BOOLEAN NOT NULL,
	"efedryna" BOOLEAN NOT NULL,
	"utracona_krew" integer NOT NULL,
	"wydalony_mocz" integer NOT NULL,
	"przetoczony_kkcz" integer NOT NULL,
	"czas_pobytu_icu" integer,
	"czas_pobytu_szpital" integer,
	"przedluzona_wentylacja" BOOLEAN,
	"dni_na_respiratorze" integer,
	CONSTRAINT operacja_pk PRIMARY KEY ("id_operacji")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "powiklania_operacja" (
	"id_operacji" integer NOT NULL,
	"id_powiklania" integer NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "powiklania_s" (
	"id_powiklania" serial NOT NULL,
	"nazwa_powiklania" varchar(50) NOT NULL,
	CONSTRAINT powiklania_s_pk PRIMARY KEY ("id_powiklania")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "troponiny" (
	"id_przyjecia" integer NOT NULL,
	"tnt" FLOAT(5) NOT NULL,
	"tnl_ultra" FLOAT(5) NOT NULL,
	"tnl" FLOAT(5) NOT NULL,
	"tnt_doba" FLOAT(5) NOT NULL,
	"tnl_doba" FLOAT(5) NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "rodzaj_zabiegu_s" (
	"id_rodzaju_zabiegu" serial NOT NULL,
	"nazwa_rodzaju_zabiegu" varchar(50) NOT NULL,
	CONSTRAINT rodzaj_zabiegu_s_pk PRIMARY KEY ("id_rodzaju_zabiegu")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "tryb_zabiegu_s" (
	"tryb_zabiegu" serial NOT NULL,
	"nazwa_trybu_zabiegu" varchar(50) NOT NULL,
	CONSTRAINT tryb_zabiegu_s_pk PRIMARY KEY ("tryb_zabiegu")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "lek_znieczulajacy_s" (
	"lek_znieczulajacy" serial NOT NULL,
	"nazwa_leku_znieczulajacego" varchar(50) NOT NULL,
	CONSTRAINT lek_znieczulajacy_s_pk PRIMARY KEY ("lek_znieczulajacy")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "znieczulenie_s" (
	"znieczulenie" serial NOT NULL,
	"nazwa_znieczulenia" varchar(50) NOT NULL,
	CONSTRAINT znieczulenie_s_pk PRIMARY KEY ("znieczulenie")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "palenie_tytoniu_s" (
	"palenie_tytoniu" serial NOT NULL,
	"wartosc_tekstowa" varchar(50) NOT NULL,
	CONSTRAINT palenie_tytoniu_s_pk PRIMARY KEY ("palenie_tytoniu")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "reoperacja" (
	"id_przyjecia" integer NOT NULL,
	"reoperacja" integer NOT NULL
) WITH (
  OIDS=FALSE
);

CREATE TABLE "reoperacja_s" (
	"reoperacja" serial NOT NULL,
	"nazwa_reoperacji" varchar(100) NOT NULL,
	CONSTRAINT reoperacja_s_pk PRIMARY KEY ("reoperacja")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "ponowna_wizyta" (
	"id_przyjecia" integer NOT NULL UNIQUE,
	"kontrolna_wizyta" integer,
	"data_ponownego_przyjecia" DATE,
	"przyczyna_ponownego_przyjecia" integer
) WITH (
  OIDS=FALSE
);

CREATE TABLE "przyczyna_ponownego_przyjecia_s" (
	"przyczyna_ponownego_przyjecia" serial NOT NULL,
	"nazwa_przyczyny" varchar(60) NOT NULL,
	CONSTRAINT przyczyna_ponownego_przyjecia_s_pk PRIMARY KEY ("przyczyna_ponownego_przyjecia")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "opis_choroby_s" (
	"id_opis_choroby" serial NOT NULL,
	"id_choroby" integer NOT NULL,
	"nazwa_opis_powiklania" varchar(50) NOT NULL,
	"wartosc_w_excelu" integer NOT NULL,
	CONSTRAINT opis_choroby_s_pk PRIMARY KEY ("id_opis_choroby")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "opis_powiklania_s" (
	"id_opis_powiklania" serial NOT NULL,
	"id_powiklania" integer NOT NULL,
	"nazwa_opis_powiklania" varchar(50) NOT NULL,
	"wartosc_w_excelu" integer NOT NULL,
	CONSTRAINT opis_powiklania_s_pk PRIMARY KEY ("id_opis_powiklania")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "badanie_obrazowe_s" (
	"id_badania_obrazowego" serial NOT NULL,
	"nazwa_badania_obrazowego" varchar(50) NOT NULL,
	CONSTRAINT badanie_obrazowe_s_pk PRIMARY KEY ("id_badania_obrazowego")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "lokalizacja_tetniaka_s_s" (
	"id_lokalizacji_tetniaka" serial NOT NULL,
	"nazwa_lokalizacji_tetniaka" varchar(50) NOT NULL,
	CONSTRAINT lokalizacja_tetniaka_s_pk PRIMARY KEY ("id_lokalizacji_tetniaka")
) WITH (
  OIDS=FALSE
);


ALTER TABLE "przyjecie" ADD CONSTRAINT "przyjecie_fk0" FOREIGN KEY ("id_pacjenta") REFERENCES "dane_osobowe"("id_pacjenta");
ALTER TABLE "przyjecie" ADD CONSTRAINT "przyjecie_fk1" FOREIGN KEY ("id_operacji") REFERENCES "operacja"("id_operacji");
ALTER TABLE "przyjecie" ADD CONSTRAINT "przyjecie_fk2" FOREIGN KEY ("palenie_tytoniu") REFERENCES "palenie_tytoniu_s"("palenie_tytoniu");
ALTER TABLE "przyjecie" ADD CONSTRAINT "przyjecie_fk3" FOREIGN KEY ("badanie_obrazowe") REFERENCES "badanie_obrazowe_s"("id_badania_obrazowego");
ALTER TABLE "przyjecie" ADD CONSTRAINT "przyjecie_fk4" FOREIGN KEY ("lokalizacja_tetniaka") REFERENCES "lokalizacja_tetniaka_s"("id_lokalizacji_tetniaka");

ALTER TABLE "rodzaj_zabiegu" ADD CONSTRAINT "rodzaj_zabiegu_fk0" FOREIGN KEY ("id_przyjecia") REFERENCES "przyjecie"("id_przyjecia");
ALTER TABLE "rodzaj_zabiegu" ADD CONSTRAINT "rodzaj_zabiegu_fk1" FOREIGN KEY ("rodzaj_zabiegu") REFERENCES "rodzaj_zabiegu_s"("id_rodzaju_zabiegu");

ALTER TABLE "choroby_wspolistniejace" ADD CONSTRAINT "choroby_wspolistniejace_fk0" FOREIGN KEY ("id_pacjenta") REFERENCES "dane_osobowe"("id_pacjenta");
ALTER TABLE "choroby_wspolistniejace" ADD CONSTRAINT "choroby_wspolistniejace_fk1" FOREIGN KEY ("id_choroby") REFERENCES "choroby_s"("id_choroby");

ALTER TABLE "leki_stosowane_przed_zabiegiem" ADD CONSTRAINT "leki_stosowane_przed_zabiegiem_fk0" FOREIGN KEY ("id_przyjecia") REFERENCES "przyjecie"("id_przyjecia");
ALTER TABLE "leki_stosowane_przed_zabiegiem" ADD CONSTRAINT "leki_stosowane_przed_zabiegiem_fk1" FOREIGN KEY ("id_leku") REFERENCES "leki_s"("id_leku");

ALTER TABLE "badania_przy_przyjeciu" ADD CONSTRAINT "badania_przy_przyjeciu_fk0" FOREIGN KEY ("id_przyjecia") REFERENCES "przyjecie"("id_przyjecia");
ALTER TABLE "badania_przy_przyjeciu" ADD CONSTRAINT "badania_przy_przyjeciu_fk1" FOREIGN KEY ("id_badania") REFERENCES "badania_s"("id_badania");

ALTER TABLE "operacja" ADD CONSTRAINT "operacja_fk0" FOREIGN KEY ("tryb_zabiegu") REFERENCES "tryb_zabiegu_s"("tryb_zabiegu");
ALTER TABLE "operacja" ADD CONSTRAINT "operacja_fk1" FOREIGN KEY ("znieczulenie") REFERENCES "znieczulenie_s"("znieczulenie");
ALTER TABLE "operacja" ADD CONSTRAINT "operacja_fk2" FOREIGN KEY ("lek_znieczulajacy") REFERENCES "lek_znieczulajacy_s"("lek_znieczulajacy");

ALTER TABLE "powiklania_operacja" ADD CONSTRAINT "powiklania_operacja_fk0" FOREIGN KEY ("id_operacji") REFERENCES "operacja"("id_operacji");
ALTER TABLE "powiklania_operacja" ADD CONSTRAINT "powiklania_operacja_fk1" FOREIGN KEY ("id_powiklania") REFERENCES "powiklania_s"("id_powiklania");

ALTER TABLE "troponiny" ADD CONSTRAINT "troponiny_fk0" FOREIGN KEY ("id_przyjecia") REFERENCES "przyjecie"("id_przyjecia");

ALTER TABLE "ponowna_wizyta" ADD CONSTRAINT "ponowna_wizyta_fk0" FOREIGN KEY ("id_przyjecia") REFERENCES "przyjecie"("id_przyjecia");
ALTER TABLE "ponowna_wizyta" ADD CONSTRAINT "ponowna_wizyta_fk1" FOREIGN KEY ("przyczyna_ponownego_przyjecia") REFERENCES "przyczyna_ponownego_przyjecia_s"("przyczyna_ponownego_przyjecia");

ALTER TABLE "opis_choroby_s" ADD CONSTRAINT "opis_choroby_s_fk0" FOREIGN KEY ("id_choroby") REFERENCES "choroby_s"("id_choroby");

ALTER TABLE "opis_powiklania_s" ADD CONSTRAINT "opis_powiklania_s_fk0" FOREIGN KEY ("id_powiklania") REFERENCES "powiklania_s"("id_powiklania");

ALTER TABLE "reoperacja" ADD CONSTRAINT "reoperacja_fk0" FOREIGN KEY ("id_przyjecia") REFERENCES "przyjecie"("id_przyjecia");
ALTER TABLE "reoperacja" ADD CONSTRAINT "reoperacja_fk1" FOREIGN KEY ("reoperacja") REFERENCES "reoperacja_s"("reoperacja");
