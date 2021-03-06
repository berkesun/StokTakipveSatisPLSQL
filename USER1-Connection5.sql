
DROP TABLE kategori;
DROP TABLE musteri;
DROP TABLE personel;
DROP TABLE satis;
DROP TABLE stok;
DROP TABLE urunler;
DROP TABLE yetkiler;
DROP TABLE yonetici;

DROP SEQUENCE seq_kategori;
DROP SEQUENCE seq_musteri;
DROP SEQUENCE seq_personel;
DROP SEQUENCE seq_satis;
DROP SEQUENCE seq_stok;
DROP SEQUENCE seq_urunler;
DROP SEQUENCE seq_yetkiler;
DROP SEQUENCE seq_yonetici;


-- Kategori Tablosu 
CREATE TABLE kategori (
  id INTEGER NOT NULL PRIMARY KEY,
  Adi varchar(255) DEFAULT NULL,
  ParentId INTEGER DEFAULT NULL
);

CREATE SEQUENCE seq_kategori
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;

INSERT INTO kategori (Id, Adi, ParentId) VALUES (seq_kategori.nextval, 'Bilgisayar', 0);
INSERT INTO kategori (Id, Adi, ParentId) VALUES (seq_kategori.nextval, 'K???k Ev Aletleri', 0);
INSERT INTO kategori (Id, Adi, ParentId) VALUES (seq_kategori.nextval, '?t?', 2);
INSERT INTO kategori (Id, Adi, ParentId) VALUES (seq_kategori.nextval, 'Elektrik S?p?rgesi', 2);


-- Musteri Tablosu
CREATE TABLE musteri (
  id INTEGER NOT NULL PRIMARY KEY,
  AdiSoyadi varchar(255),
  Telefon varchar(255),
  Adres varchar(255)
);

CREATE SEQUENCE seq_musteri
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 44;

INSERT INTO musteri (Id, AdiSoyadi, Telefon, Adres) VALUES (seq_musteri.nextval, 'Ahmet Dursun', '5413967678', 'izmir');
INSERT INTO musteri (Id, AdiSoyadi, Telefon, Adres) VALUES (seq_musteri.nextval, 'Kaz?m ?leri', '5544465566', 'bursa');
INSERT INTO musteri (Id, AdiSoyadi, Telefon, Adres) VALUES (seq_musteri.nextval, 'G?rkan ?z', '5533312492', 'bursa');
INSERT INTO musteri (Id, AdiSoyadi, Telefon, Adres) VALUES (seq_musteri.nextval, 'Duhan ??er', '5515464578', 'istanbul');



-- Personel Tablosu
CREATE TABLE personel (
   Id INTEGER NOT NULL PRIMARY KEY,
   AdiSoyadi varchar(255),
   Email varchar(255)
);

CREATE SEQUENCE seq_personel
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 11;


INSERT INTO personel (Id, AdiSoyadi, Email) VALUES (seq_personel.nextval, 'Berke G?ne?', 'berkeleexd@gmail.com');
INSERT INTO personel (Id, AdiSoyadi, Email) VALUES (seq_personel.nextval, 'Selim Sava?', 'selimsavas16@gmail.com');
INSERT INTO personel (Id, AdiSoyadi, Email) VALUES (seq_personel.nextval, 'Sat?? Personeli', 'satispersonel@gmail.com');
INSERT INTO personel (Id, AdiSoyadi, Email) VALUES (seq_personel.nextval, 'Erdinc Solmaz', 'erdincSolmazF@gmail.com');




-- Satis Tablosu
CREATE TABLE satis (
  Id INTEGER NOT NULL PRIMARY KEY,
  UrunId INTEGER DEFAULT NULL,
  MusteriId INTEGER DEFAULT NULL,
  Tarih varchar2(20) DEFAULT NULL,
  Adet INTEGER DEFAULT NULL,
  PersonelId INTEGER DEFAULT NULL,
  CONSTRAINT fk_urun_satis FOREIGN KEY (UrunId) REFERENCES urunler(Id),
  CONSTRAINT fk_musteri_satis FOREIGN KEY (MusteriId) REFERENCES musteri(Id),
  CONSTRAINT fk_personel_satis FOREIGN KEY (PersonelId) REFERENCES personel(Id)
);


CREATE SEQUENCE seq_satis
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 30;

INSERT INTO satis (Id, UrunId, MusteriId, Tarih, Adet, PersonelId) VALUES (seq_satis.nextval, 2, 2, '19MAR21', 1, 1);
INSERT INTO satis (Id, UrunId, MusteriId, Tarih, Adet, PersonelId) VALUES (seq_satis.nextval, 2, 3, '20MAR21', 1, 1);
INSERT INTO satis (Id, UrunId, MusteriId, Tarih, Adet, PersonelId) VALUES (seq_satis.nextval, 1, 2, '21MAR21', 5, 1);
INSERT INTO satis (Id, UrunId, MusteriId, Tarih, Adet, PersonelId) VALUES (seq_satis.nextval, 1, 3, '21MAR21', 3, 1);
INSERT INTO satis (Id, UrunId, MusteriId, Tarih, Adet, PersonelId) VALUES (seq_satis.nextval, 1, 4, '21MAR21', 5, 1);
INSERT INTO satis (Id, UrunId, MusteriId, Tarih, Adet, PersonelId) VALUES (seq_satis.nextval, 2, 3, '22MAR21', 3, 1);



-- Stok Tablosu
CREATE TABLE stok (
  Id INTEGER NOT NULL PRIMARY KEY,
  UrunId INTEGER DEFAULT NULL,
  PersonelID INTEGER DEFAULT NULL,
  Tarih varchar2(20) DEFAULT NULL,
  Adet INTEGER DEFAULT NULL,
  CONSTRAINT fk_urun_stok FOREIGN KEY (UrunId) REFERENCES urunler(Id),
  CONSTRAINT fk_personel_stok FOREIGN KEY (PersonelId) REFERENCES personel(Id)
);

CREATE SEQUENCE seq_stok
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 80;

INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES (seq_stok.nextval, 1, 1, '2021-01-13', 4);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 2, '2021-01-13', 6);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 2, '2021-01-13', 5);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 2, '2021-01-13', 5);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 2, 4, '2021-01-13', 32);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 2, 4, '2021-01-13', 5);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 2, 1, '2021-01-13', 5);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 2, 1, '2021-01-13', -1);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 2, 1, '2021-01-13', -1);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 1, '2021-01-13', -5);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 1, '2021-01-13', -3);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 1, '2021-01-13', -5);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 1, '2021-01-13', 5);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 2, 1, '2021-01-13', 3);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 2, 1, '2021-01-13', -3);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 2, '2021-01-13', 3);
INSERT INTO stok (Id, UrunId, PersonelId, Tarih, Adet) VALUES(seq_stok.nextval, 1, 2, '2021-01-13', 3);


-- Urunler Tablosu
CREATE TABLE urunler (
  Id INTEGER NOT NULL PRIMARY KEY,
  Adi varchar(255) DEFAULT NULL,
  KategoriId INTEGER DEFAULT NULL,
  Tarih varchar2(20) DEFAULT NULL,
  Fiyat INTEGER DEFAULT NULL,
  CONSTRAINT fk_kategori_urunler FOREIGN KEY (KategoriId) REFERENCES kategori(Id)
);

CREATE SEQUENCE seq_urunler
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 40;

INSERT INTO urunler (Id, Adi, KategoriId, Tarih, Fiyat) VALUES (seq_urunler.nextval, 'Acer A315', 1, '03MAR97', 30);
INSERT INTO urunler (Id, Adi, KategoriId, Tarih, Fiyat) VALUES (seq_urunler.nextval, 'Fakir ?t?', 3, '04MAR22', 44);
INSERT INTO urunler (Id, Adi, KategoriId, Tarih, Fiyat) VALUES (seq_urunler.nextval, 'Asus ROG', 1, '03MAR98', 4000);


-- Yetkiler Tablosu
CREATE TABLE yetkiler (
  Id INTEGER NOT NULL PRIMARY KEY,
  Adi varchar(255) DEFAULT NULL
);

CREATE SEQUENCE seq_yetkiler
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 3;

INSERT INTO yetkiler (Id, Adi) VALUES (seq_yetkiler.nextval, 'admin');
INSERT INTO yetkiler (Id, Adi) VALUES (seq_yetkiler.nextval, 'Sat?? Eleman?');

-- Yonetici Tablosu
CREATE TABLE yonetici (
  Id INTEGER NOT NULL PRIMARY KEY,
  YetkiId INTEGER DEFAULT NULL,
  PersonelId INTEGER DEFAULT NULL,
  Sifre varchar(255) DEFAULT NULL,
  CONSTRAINT fk_yetki_yonetici FOREIGN KEY (YetkiId) REFERENCES yetkiler(Id),
  CONSTRAINT fk_personel_yonetici FOREIGN KEY (PersonelId) REFERENCES personel(Id)
  );

CREATE SEQUENCE seq_yonetici
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 4;

INSERT INTO yonetici (Id, YetkiId, PersonelId, Sifre) VALUES (seq_yonetici.nextval, 1, 1, 'kamyon');
INSERT INTO yonetici (Id, YetkiId, PersonelId, Sifre) VALUES (seq_yonetici.nextval, 1, 2, '123');
INSERT INTO yonetici (Id, YetkiId, PersonelId, Sifre) VALUES (seq_yonetici.nextval, 2, 4, '123');
















