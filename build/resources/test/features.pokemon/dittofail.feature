Feature: consulta de pokemon fallida
  como usuario de la plataforma pokemon
  necesito validar las caracteristicas de un pokemon
  para poder jugar con ventaja

  Scenario: pokemon ditto ability fail
    Given el usuario necesita verificar el pokemon ditto
    Then el usuario no podra verificar porque saldra un mensaje de Not Found