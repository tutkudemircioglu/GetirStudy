@login_sayfası
Feature: Login Test Senaryoları

  Scenario: Başarılı login testi
    Given Giriş ekranında username alanına "hello@getir.com" yazılır
    When Giriş ekranında password alanına "hello" yazılır
    And Giriş ekranında submit butonuna tıklanır
    Then Giriş yapmış kullanıcı için ana ekran kontrol edilir

  Scenario: Başarısız login testi
    Given Giriş ekranında username alanına "hello@getir.com" yazılır
    When Giriş ekranında password alanına "hello1" yazılır
    And Giriş ekranında submit butonuna tıklanır
    Then Kullanıcının giriş yapamadığı kontrol edilir

  Scenario: Başarılı logout testi
    Given Giriş ekranında username alanına "hello@getir.com" yazılır
    When Giriş ekranında password alanına "hello" yazılır
    And Giriş ekranında submit butonuna tıklanır
    And Getir anasayfasında profil butonuna tıklanır
    When Profil ekranında log out butonuna tıklanır
    Then Kullanıcının çıkış yaptığı kontrol edilir

    Scenario: Screenshot için fail alan test
      Given Giriş ekranında username alanına "hello@getir.com" yazılır
      When Giriş ekranında password alanına "hello" yazılır
      And Giriş ekranında submit butonuna tıklanır
      Then Kullanıcının giriş yapamadığı kontrol edilir








