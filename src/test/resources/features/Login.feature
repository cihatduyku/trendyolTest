@login_sayfası
Feature: Login Test Senaryoları

  Scenario: Başarılı login testi
    Given Trendyol anasayfada cinsiyet popupı açıldığı kontrol edilir
    When Trendyol anasayfada cinsiyet popupı kapatılır
    And Trendyol anasayfada giriş yap butonuna tıklanır
    And Giriş popupında eposta alanına "linktestotomasyon@gmail.com" yazılır
    And Giriş popupında şifre alanına "Asdqwe123" yazılır
    And Giriş popupında giriş yap butonuna tıklanır
    When Giriş popupının kapanması beklenir
    Then Giriş yapmış kullanıcı için ana ekran kontrol edilir

  Scenario Outline: Login sonrası butik kontrolleri
    Given Trendyol anasayfada cinsiyet popupı açıldığı kontrol edilir
    When Trendyol anasayfada cinsiyet popupı kapatılır
    And Trendyol anasayfada giriş yap butonuna tıklanır
    And Giriş popupında eposta alanına "linktestotomasyon@gmail.com" yazılır
    And Giriş popupında şifre alanına "Asdqwe123" yazılır
    And Giriş popupında giriş yap butonuna tıklanır
    And Giriş popupının kapanması beklenir
    Then Giriş yapmış kullanıcı için ana ekran kontrol edilir
    When Trendyol anasayfasında <tabName> tabına tıklanır
    Then <tabName> tabının butik imajları kontrol edilir

    Examples:
      | tabName          |
      | KADIN            |
      | ERKEK            |
      | ÇOCUK            |
      | AYAKKABI & ÇANTA |
      | SAAT & AKSESUAR  |
      | KOZMETİK         |
      | EV & YASAM       |
      | ELEKTRONİK       |
      | SÜPERMARKET      |

  Scenario: Login sonrası ürün resimleri kontrolleri
    Given Trendyol anasayfada cinsiyet popupı açıldığı kontrol edilir
    When Trendyol anasayfada cinsiyet popupı kapatılır
    And Trendyol anasayfasında rastgele taba tıklanır
    And Tabdan rastgele butiğe tıklanır
    Then Ürünlerin imajları kontrol edilir

  Scenario: Login sonrası sepete ekleme kontrolü
    Given Trendyol anasayfada cinsiyet popupı açıldığı kontrol edilir
    When Trendyol anasayfada cinsiyet popupı kapatılır
    And Trendyol anasayfasında rastgele taba tıklanır
    And Tabdan rastgele butiğe tıklanır
    And Ürünlerin içerisinden rastgele seçim yapılır
    Then Ürün detay sayfasının açıldığı kontrol edilir
    When Ürün sayfasında beden seçimi yapılır
    And Ürün sayfasında sepete ekle butonuna tıklanır
    Then Ürün sayfasında sepete eklendi butonu kontrol edilir