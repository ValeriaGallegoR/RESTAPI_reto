Feature: consulta de pokemon fallida
  como usuario de la plataforma pokemon
  necesito validar las caracteristicas de un pokemon
  para poder jugar con ventaja

  Scenario: pokemon ditto ability fail
    Given el usuario necesita verificar el pokemon ditto
    When el sistema verifica que la habilidad del pokemon exista
    Then el usuario no podra ver la habilidad de ditto porque esta no existe