@ürün_ekleme_sayfası
Feature: Ürün Ekleme Test Senaryoları

  Background:
    Given Giriş ekranında username alanına "hello@getir.com" yazılır
    When Giriş ekranında password alanına "hello" yazılır
    And Giriş ekranında submit butonuna tıklanır

  Scenario Outline: Ürünü sepete ekleme
    And Getir anasayfasında <categories> kategorisine tıklanır
    And <categories> kategorisinden rastgele bir ürün sepete eklenir
    And Kategori detay ekranındaki sepetim butonuna tıklanır
    And Sepet ekranında eklenen ürünler kontrol edilir
    And Sepet ekranında eklenen ürünler silinir
    And Sepet ekranında tüm ürünlerin silindiği kontrol edilir
    Examples:
      | categories     |
      | Yiyecek        |
      | Süt & Kahvaltı |
      | Bebek          |

  Scenario Outline: Ödeme ekranı
    And Getir anasayfasında <categories> kategorisine tıklanır
    And <categories> kategorisinden rastgele bir ürün sepete eklenir
    And Kategori detay ekranındaki sepetim butonuna tıklanır
    And Sepet ekranında eklenen ürünler kontrol edilir
    And Sepet ekranında eklenen ürünler birer tane arttırılır
    And Sepet ekranında arttırılan ürünler kontrol edilir
    And Sepet ekranındaki payment butonuna tıklanır
    And Ödeme ekranı kontrol edilir
    And Ödeme ekranındaki geri butonuna tıklanır
    And Sepet ekranında eklenen ürünler silinir
    And Sepet ekranında tüm ürünlerin silindiği kontrol edilir
    Examples:
      | categories     |
      | Yiyecek        |
      | Süt & Kahvaltı |
      | Bebek          |


  Scenario: Sepete rastgele ürün ekleme
    And Getir anasayfasında rastgele kategoriye tıklanır
    And Kategori detay ekranında rasgele bir ürün sepete eklenir
    And Kategori detay ekranındaki sepetim butonuna tıklanır
    And Sepet ekranında eklenen ürünler kontrol edilir


  Scenario Outline: deneme
    And Getir anasayfasında <categories> kategorisine tıklanır
    And <categories> kategorisinden rastgele bir ürün sepete eklenir
    Examples:
      | categories     |
      | Yiyecek        |
      | Süt & Kahvaltı |
      | Bebek          |