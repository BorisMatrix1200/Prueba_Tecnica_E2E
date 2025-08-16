Feature: Login

  Scenario: Compra exitosa después de login
    Given que el usuario accede a la página de login
    When ingresa credenciales válidas
    Then debería ver el mensaje de login exitoso
    And agrega dos productos al carrito
    And visualiza el carrito
    And completa el formulario de compra
    And debería ver el mensaje exitoso