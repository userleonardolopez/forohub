# ForoHub
## 📋 Descripción del proyecto
API REST de foro que permite realizar operaciones CRUD a través de un cliente API.
También integra inicio de sesión elaborado con Spring Security con autenticación por base de datos.

## 🔨 Funcionalidades del proyecto
* `Inicio de sesión`:
  * Devuelve un JWT al usuario para permitirle realizar operaciones CRUD. Debe colocar manualmente el JWT como *Bearer* en las próximas operaciones CRUD (expira en 2 hrs a partir de su generación).
  * Debe existir, al menos, un usuario registrado en la tabla `usuarios` para realizar esta operación.
  * Su *endpoint* es: `/login`
  * El *payload* debe contener los siguientes campos en formato JSON:
    * (String) **login**
    * (String) **clave**
  * ***Ejemplo de Payload:***
    
    * ```
      {
    	"login": "leonardo.lopez",
    	"clave": "123456"
      }
      ```
* `(POST) Registrar tópico`:
  
  ![image](https://github.com/user-attachments/assets/28501aa6-fda0-4de6-ba0a-9b9a6252c0e9)

  * Registra un tópico en la base de datos.
  * Su *endpoint* es: `/topicos`
  * El *payload* debe contener los siguientes campos en formato JSON:
    * (String) **titulo**
    * (String) **mensaje**
    * (String) **autor**
    * (String) **curso**
  * ***Ejemplo de Payload:***
    
    * ```
      {
    	"titulo": "Error 0xc0000157",
    	"mensaje": "Lorem ipsum dolor sit amet",
    	"autor": "Leonardo",
    	"curso": "Spring Boot Security 3"
      }
      ```
* `(GET) Obtener tópicos`:

  ![image](https://github.com/user-attachments/assets/a7ed0fd8-1269-4e4f-bb41-d2cbea702ab5)

  * Muestra todos los tópicos en la base de datos.
  * Su *endpoint* es: `/topicos`
  * El *payload* debe estar vacío.
* `(GET) Obtener tópico por ID`:

  ![image](https://github.com/user-attachments/assets/1299a7f2-4f93-4bab-84dc-63fe1804f1fb)

  * Muestra un tópico específico en la base de datos.
  * Su *endpoint* es: `/topicos/{id}`, donde `{id}` es el ID del tópico que desea consultar.
  * El *payload* debe estar vacío.
* `(PUT) Actualizar tópico por ID`:

  ![image](https://github.com/user-attachments/assets/27844610-f0a8-46f6-aef1-b49c9a9c3128)

  * Actualiza un tópico en la base de datos.
  * Su *endpoint* es: `/topicos/{id}`, donde `{id}` es el ID del tópico que desea actualizar.
  * El *payload* debe contener los siguientes campos en formato JSON:
    * (String) **titulo**
    * (String) **mensaje**
    * (String) **autor**
    * (String) **curso**
  * ***Ejemplo de Payload:***
    
    * ```
      {
    	"titulo": "Error 0xc0000158",
    	"mensaje": "Lorem ipsum dolor",
    	"autor": "Fernando",
    	"curso": "Spring Boot Security 2"
      }
      ```
* `(DELETE) Eliminar tópico`:

  ![image](https://github.com/user-attachments/assets/33c08e51-0fff-4b26-990e-7575dcb15bc1)

  * Elimina un tópico en la base de datos.
  * Su *endpoint* es: `/topicos/{id}`, donde `{id}` es el ID del tópico que desea eliminar.
  * El *payload* debe estar vacío.

## 📂💻 Acceso al proyecto

Para utilizar este proyecto, necesitará instalar y configurar las siguientes herramientas:

- [`Insomnia`](#instalar-insomnia)
- [`MySQL Server`](#instalar-y-configurar-mysql-server)
- [`Java JDK 21`](#instalar-java-jdk-21)
- [`IntelliJ IDEA Community Edition`](#instalar-intellij-idea-community-edition)

¡Le tenemos cubierto! Siga las indicaciones debajo para configurar estas herramientas en su equipo...

### Instalar Insomnia

Insomnia es una herramienta para probar y depurar APIs.

1. Descargue la aplicación desde el sitio oficial: [Insomnia](https://insomnia.rest/download)

2. Seleccione la versión adecuada para su sistema operativo (Windows, macOS o Linux).

3. Ejecute el instalador descargado y siga los pasos que se mostrarán hasta finalizar la instalación.

4. Una vez instalado, abra la aplicación y asegúrese de que funciona correctamente.

<br>

### Instalar y Configurar MySQL Server

MySQL Server es el sistema de gestión de bases de datos utilizado por este proyecto.

1. Descargue MySQL Server desde el sitio oficial: [MySQL Downloads](https://dev.mysql.com/downloads/installer/)

2. Ejecute el instalador descargado y elija la opción **Developer Default** para incluir las herramientas necesarias.

3. Durante el proceso de instalación, configure las siguientes opciones:

   - **Authentication Method**
   - **MySQL Root Password**: Establezca una contraseña segura para el usuario "root" y anótela para su referencia.

4. Complete la instalación y verifique que el servidor MySQL esté funcionando.

5. Opcionalmente, instale una herramienta gráfica como [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) para administrar visualmente las bases de datos.

### Verificar la Configuración de MySQL

1. Abra una terminal o consola de comandos.

2. Conéctese al servidor MySQL utilizando el comando:

   ```bash
   mysql -u root -p
   ```

3. Introduzca la contraseña que configuró durante la instalación.

4. Cree una base de datos para su proyecto ejecutando:

   ```sql
   CREATE DATABASE nombre_de_su_base_de_datos;
   ```

5. Verifique que la base de datos se haya creado correctamente:

   ```sql
   SHOW DATABASES;
   ```

6. ¡Listo! Ahora puede utilizar MySQL Server en su proyecto.

<br>

### Instalar Java JDK 21

El Java Development Kit (JDK) es necesario para compilar y ejecutar aplicaciones Java.

1. Descargue el [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) desde el sitio oficial.

2. Seleccione la versión adecuada para su sistema operativo (Windows, macOS o Linux).

3. Ejecute el instalador y siga las instrucciones hasta completar la instalación.

4. Verifique la instalación abriendo una terminal y ejecutando:

   ```bash
   java --version
   ```

   Debería ver la versión instalada.

<br>

### Instalar IntelliJ IDEA Community Edition

IntelliJ IDEA es un IDE popular para el desarrollo de aplicaciones Java.

1. Descargue IntelliJ IDEA Community desde el sitio oficial: [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/).

2. Ejecute el instalador descargado y siga las instrucciones hasta completar la instalación.

## 🛠️ Abra y ejecute el proyecto

Finalmente, para utilizar el proyecto:

1. Abra y ejecute el servidor desde MySQL.
2. Abra y ejecute este proyecto desde IntelliJ para realizar las migraciones de la API.
3. Abra y utilice Insomnia para realizar operaciones CRUD a la base de datos a través de la API.

## ✔️ Tecnologías utilizadas
* Java JDK 21
* Spring Boot 3
* MySQL

## Desarrolladores del proyecto

| [<img src="https://github.com/user-attachments/assets/6181992d-d324-4155-9537-fc046e538604" width=115><br><sub>userLeonardoLopez</sub>](https://github.com/userLeonardoLopez) | 
| :---: |
