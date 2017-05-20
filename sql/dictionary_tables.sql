-- Rodzaj Zabiegu
DELETE FROM "rodzaj_zabiegu_s";
Insert into "rodzaj_zabiegu_s" (id_rodzaju_zabiegu, nazwa_rodzaju_zabiegu) VALUES
  ('1', 'Otwarta operacja wycięcia tętniaka aorty brzusznej'),
  ('2', 'Endowaskularne zaopatrzenie tętniaka aorty (EVAR)'),
  ('3', 'Przęsło aortalno dwuudowe (ABF)'),
  ('4', 'Przęsło aortalno-udowe'),
  ('5', 'Przęsło aortalno-biodrowe'),
  ('6', 'Przęsło aortalno-dwubiodrowe'),
  ('7', 'Plastyka aorty');

-- Znieczulenie
DELETE FROM "znieczulenie_s";
INSERT INTO "znieczulenie_s" (znieczulenie, nazwa_znieczulenia) VALUES
  ('1', 'Ogólne'),
  ('2', 'Miejscowe'),
  ('3', 'Podpajęczynówkowe'),
  ('4', 'Ogólne plus zewnątrzoponowe'),
  ('5', 'Ogólne plus podpajęczynówkowe');

-- Lek znieczulajacy
DELETE FROM "lek_znieczulajacy_s";
INSERT INTO "lek_znieczulajacy_s" (lek_znieczulajacy, nazwa_leku_znieczulajacego) VALUES
  ('1', 'Propofol'),
  ('2', 'Etomidat'),
  ('3', 'Tiopental'),
  ('4', 'Ketamina'),
  ('5', 'brak danych/nic');

-- Tryb zabiegu
DELETE FROM "tryb_zabiegu_s";
INSERT INTO "tryb_zabiegu_s" (tryb_zabiegu, nazwa_trybu_zabiegu) VALUES
  ('1', 'Planowy'),
  ('2', 'Pilny/Naglący');

-- Tetniak?
-- Badanie obrazowe na podstawie ktorego okreslono srednice tetniaka
-- Lokalizacja tetniaka

-- Palenie tytoniu
DELETE FROM "palenie_tytoniu_s";
INSERT INTO "palenie_tytoniu_s" (palenie_tytoniu, wartosc_tekstowa) VALUES
  ('0', 'nie palący'),
  ('1', 'palący'),
  ('2', 'palący w przeszłości');

-- PAD - choroba tetnic obwodowych
-- Skala ASA

-- Choroby wspolistneijace
DELETE FROM "opis_choroby_s";
DELETE FROM "choroby_s";
INSERT INTO "choroby_s" (id_choroby, nazwa_choroby) VALUES
  ('1', 'HT'), -- nadciśnienie tętnicze
  ('2', 'CAD'), -- choroba wieńcowa
  ('3', 'CAD wysokiego ryzyka'),
  ('4', 'MI/ACS przebyty'), -- Zawał serca/ostry zespół wieńcowy
  ('5', 'Stenoza aortalna'),
  ('6', 'CVE przebyty'), -- incydent naczyniowo-mózgowy
  ('7', 'CHF'), -- przewlekla niewydolnosc krazenia
  ('8', 'DM'), -- cukrzyca
  ('9', 'COPD'), -- przewlekla obturacyjna choroba pluc
  ('10', 'EKG przymęciowe'); -- EKG przy przyjęciu

DELETE FROM "opis_choroby_s";
INSERT INTO "opis_choroby_s" (id_opis_choroby, id_choroby, nazwa_opis_powiklania, wartosc_w_excelu) VALUES
  ('1', '1', 'nie', '0'), -- HT
  ('2', '1', 'tak', '1'),
  ('3', '2', 'nie', '0'), -- CAD
  ('4', '2', 'tak', '1'),
  ('5', '3', 'nie', '0'), -- CAD wysokiego ryzyka
  ('6', '3', 'tak', '1'),
  ('7', '4', 'nie', '0'), -- MI/ACS
  ('8', '4', 'tak', '1'),
  ('9', '5', 'brak', '0'), -- Stenoza aortalna
  ('10', '5', 'łagodna', '1'),
  ('11', '5', 'umiarkowana', '2'),
  ('12', '5', 'ciężka', '3'),
  ('13', '5', 'sztuczna zastawka', '4'),
  ('14', '6', 'nie', '0'), -- CVE przebyty
  ('15', '6', 'tak', '1'),
  ('16', '7', 'nie', '0'), -- CHF
  ('17', '7', 'tak', '1'),
  ('18', '8', 'nie', '0'), -- DM
  ('19', '8', 'tak', '1'),
  ('20', '8', 'w trakcie insulinoterapii', '2'),
  ('21', '9', 'nie', '0'), -- COPD
  ('22', '9', 'tak', '1'),
  ('23', '10', 'rytm zatokowy', '1'), -- EKG
  ('24', '10', 'AF', '2'),
  ('25', '10', 'rytm zatokowy + obecność VE', '3'),
  ('26', '10', 'AF + obecność VE', '4'),
  ('27', '10', 'rytm z rozrusznika', '5'),
  ('28', '10', 'AF + rytm z rozrusznika', '6');

-- Badania
DELETE FROM "badania_s";
INSERT INTO "badania_s" (id_badania, nazwa_badania, jednostka) VALUES
  ('1', 'PShN w stadium 5 (dializoterapia)', 'brak'),
  ('2', 'Kreatynina', 'umol/l'),
  ('3', 'eGFR', 'MDRD'),
  ('4', 'Hb', 'g/dl'),
  ('5', 'WBC', 'tys/ul'),
  ('6', 'fibrynogen', 'g/l');

-- Leki w okresie przedoperacyjnym
DELETE FROM "leki_s";
INSERT INTO "leki_s" (id_leku, nazwa_leku) VALUES
  ('1', 'Aspiryna'),
  ('2', 'Statyna'),
  ('3', 'ACE-I'),
  ('4', 'ARB'),
  ('5', 'β-bloker'),
  ('6', 'Ca-bloker'),
  ('7', 'werapamil, dilitiazem'),
  ('8', 'Diuretyk'),
  ('9', 'Doustne antykoagulanty'),
  ('10', 'HDCz'),
  ('11', 'klopidogrel'),
  ('12', 'fibrat');

--powiklania
DELETE FROM "opis_powiklania_s" WHERE id_powiklania BETWEEN '1' AND '30';
DELETE FROM "powiklania_s" WHERE id_powiklania BETWEEN '1' AND '30';
INSERT INTO "powiklania_s" (id_powiklania, nazwa_powiklania) VALUES -- DODAC NA POCZATKU
  ('1', 'MINS'),
  ('2', 'MI'),
  ('3', 'Zmiany w EKG'),
  ('4', 'Nowe zaburzenia kurczliwości w ECHO'),
  ('5', 'Dolegliwości stenodardialne'),
  ('6', 'Obrzęk płuc'),
  ('7', 'Nowy epizod AF'),
  ('8', 'Udar mózgu'),
  ('9', 'Zapalenie płuc'),
  ('10', 'Sepsa'),
  ('11', 'Pooperacyjna niewydolnośc nerek(AKI)'),
  ('12', 'Leczenie nerkozastępcze'),
  ('13', 'Krwawienie z pp'),
  ('14', 'Krwawienie z rany pooperacyjnej'),
  ('15', 'Przetoczenie KKCz na OIT/naczyniówce'),
  ('16', 'Zatorowość płucna'),
  ('17', 'DVT'),
  ('18', 'Zakrzepica żył powierzchownych'),
  ('19', 'Niedokrwienie jelit'),
  ('20', 'Zakażenie miejsca operowanego'),
  ('21', 'Niedokrwienie kończyn dolnych'),
  ('22', 'Uszkodzenie wątroby'),
  ('23', 'Ostre zapalenie trzustki'),
  ('24', 'Niedrożność protezy'),
  ('25', 'Zakażenie C. difficile'),
  ('26', 'Niewydolnosć wielonarządowa'),
  ('27', 'Zatrzymanie krążenia nie zakończone zgonem'),
  ('28', 'Zgon wewnątrzszpitalny'),
  ('29', 'Zgon-doba po operacji'),
  ('30', 'Zgon z przyczyn naczyniowych');

--powiklania opis
DELETE FROM "opis_powiklania_s" WHERE id_powiklania BETWEEN '1' AND '30';
INSERT INTO "opis_powiklania_s" (id_opis_powiklania, id_powiklania, nazwa_opis_powiklania, wartosc_w_excelu) VALUES
  ('1', '1', 'nie', '0'), -- MINS
  ('2', '1', 'tak', '1'),
  ('3', '2', 'nie', '0'), -- MI
  ('4', '2', 'NSTEMI ACS', '1'), -- (nowe poziome lub skośne do dołu obniżenie odcinka ST o min. 0,5 mm lub obecność ujemnego załamka T o głębokości min. 1 mm lub zmiana załamków ujemnych na dodatnie)
  ('5', '2', 'STEMI', '2'), --(uniesienia odcinka ST o min. 2 mm w V2-V3 lub o min. 1 mm w pozostałych odprowadzeniach lub pojawienie się patologicznych załamków Q lub świeży LBBB)
  ('6', '3', 'nie', '0'), -- Zmiany w EKG
  ('7', '3', 'tak', '1'),
  ('8', '3', 'nie wykonywano badania', '2'),
  ('9', '4', 'nie', '0'), -- Nowe zaburzenia kurzczliwosci
  ('10', '4', 'tak', '1'),
  ('11', '4', 'nie wykonywano badania', '2'),
  ('12', '5', 'nie', '0'), -- dolegliwosci stenokardialne
  ('13', '5', 'tak', '1'),
  ('14', '5', 'brak danych (pacjent nieprzytomny)', '2'),
  ('15', '6', 'nie', '0'), -- obrzek pluc
  ('16', '6', 'tak', '1'),
  ('17', '6', 'brak danych (pacjent nieprzytomny)', '2'),
  ('18', '7', 'nie', '0'), -- Nowy epizod AF
  ('19', '7', 'tak', '1'),
  ('20', '8', 'nie', '0'), -- Udar mozgu
  ('21', '8', 'tak', '1'),
  ('22', '9', 'nie', '0'), -- Zapalenie pluc
  ('23', '9', 'tak', '1'),
  ('24', '10', 'nie', '0'), -- Sepsa
  ('25', '10', 'tak', '1'),
  ('26', '11', 'nie', '0'), -- Pooperacyjna niewydolnośc nerek(AKI)
  ('27', '11', 'tak', '1'),
  ('28', '12', 'nie', '0'), -- Leczenie nerkozastępcze
  ('29', '12', 'tak', '1'),
  ('30', '13', 'nie', '0'), -- Krwawienie z pp
  ('31', '13', 'tak', '1'),
  ('32', '14', 'nie', '0'), -- Krwawienie z rany pooperacyjnej
  ('33', '14', 'tak', '1'),
  ('34', '15', 'nie', '0'), -- Przetoczenie KKCz na OIT/naczyniówce
  ('35', '15', 'tak', '1'),
  ('36', '16', 'nie', '0'), -- Zatorowość płucna
  ('37', '16', 'tak', '1'),
  ('38', '17', 'nie', '0'), -- DVT
  ('39', '17', 'tak', '1'),
  ('40', '18', 'nie', '0'), -- Zakrzepica żył powierzchownych
  ('41', '18', 'tak', '1'),
  ('42', '19', 'nie', '0'), -- Niedokrwienie jelit
  ('43', '19', 'tak', '1'),
  ('44', '20', 'nie', '0'), -- Zakażenie miejsca operowanego
  ('45', '20', 'tak', '1'),
  ('46', '21', 'nie', '0'), -- Niedrożność protezy
  ('47', '21', 'tak', '1'),
  ('48', '22', 'nie', '0'), -- Uszkodzenie watroby
  ('49', '22', 'tak', '1'),
  ('50', '23', 'nie', '0'), -- Ostre zapalenie trzustki
  ('51', '23', 'tak', '1'),
  ('52', '24', 'nie', '0'), -- Zakażenie C. difficile
  ('53', '24', 'tak', '1'),
  ('54', '25', 'nie', '0'), -- Niedokrwienie kończyn dolnych
  ('55', '25', 'tak', '1'),
  ('56', '26', 'nie', '0'), -- Niewydolność wielonarządowa
  ('57', '26', 'tak', '1'),
  ('58', '27', 'nie', '0'), -- Zatrzymanie krążenia nie zakończone zgonem
  ('59', '27', 'tak', '1'),
  ('60', '28', 'nie', '0'), -- Zgon wewnątrzszpitalny
  ('61', '28', 'tak', '1'),
  ('62', '29', 'nie', '0'), -- Zgon-doba po operacji
  ('63', '29', 'tak', '1'),
  ('64', '30', 'nie', '0'), -- Zgon z przyczyn naczyniowych
  ('65', '30', 'tak', '1'),
  ('66', '30', 'brak danych', '2'),
  ('67', '30', 'nie dotyczy', '3'); -- !!! tymczasowo 3, powinno być 'x' !!!

-- Reoperacja
DELETE FROM "reoperacja_s";
INSERT INTO "reoperacja_s" (reoperacja, nazwa_reoperacji) VALUES
  ('0', 'nie'),
  ('1', 'z powodu krwawienia z rany'),
  ('2', 'z powodu niedrożności wszczepionej protezy i niedokrwienia kończyn/kończyny dolnej'),
  ('3', 'z powodu zakażenia'),
  ('4', 'z powodu niedokrwienia kończyn dolnych'),
  ('5', 'amputacja z powodu niedokrwienia kończyn dolnych'),
  ('6', 'z powodu niedokrwienia jelit'),
  ('7', 'z powodu wytrzewienia'),
  ('8', 'laparotomia zwiadowcza');

-- Przyczyna ponownego przyjecia
DELETE FROM "przyczyna_ponownego_przyjecia_s";
INSERT INTO "przyczyna_ponownego_przyjecia_s" (przyczyna_ponownego_przyjecia, nazwa_przyczyny) VALUES
  ('1', 'zakażenie miejsca operowanego'),
  ('2', 'niedrożność protezy i niedokrwienie kończyn dolnych'),
  ('3', 'inne');
