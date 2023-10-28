
# Files Collections Exceptions

Leer y Procesar
## Features

- Collections
- Exceptions
- Files
- Testing



## Documentation

- Implementar un método getPersonas de la class RegistroPersonas que reciba el nombre de un archivo y devuelva un objeto LinkedList<Persona> con personas que fueron leídas del archivo de texto con formato "dni apellido edad" (Integer String Integer).
- Implementar un método getPersonasMayoresAEdad que reciba un objeto LinkedList<Persona> y una edad y devuelva otro objeto LinkedList<Persona> con las personas cuyas edades son mayores a esa edad. Guardar esas personas en un archivo “personasMayoresDeXX.out”, donde xx sea la edad que se usó como parámetro. Guardarlo ordenado alfabéticamente.
- Implementar un método que devuelva la edad promedio de la muestra de personas.
- Implementar un método que devuelva la cantidad de personas cuya edad está por encima de la edad promedio.
- ¿Cual es la persona de mayor edad?, si hubiera varias, mostrarlas a todas.
- ¿Cual es la persona de menor edad?, si hubiera varias, mostrarlas a todas.

### Nota: Mejor si recorremos la lista una sola vez.
- Agrupar las personas por edad, o sea, generar un archivo tal que figure en una línea la edad, y debajo todas las personas que tienen esa edad.
### Sobreescribir los métodos:
- equals de Object para determinar que dos objetos personas son iguales si sus dni´s son iguales.
- toString de Object para aplanar el objeto a una cadena que contiene los colaboradores internos del objeto separado por “;”.
- Se debe poder listar a las personas ordenadas por dni, por apellido y por edad (de mayor a menor)

## Related

Implementaciones
- Defina e implente Testing
- Junit 5

